package org.biblioteca.abm.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.biblioteca.entidad.Libro;

@Stateless
@LocalBean
public class LibroSession {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public LibroSession() {
		// TODO Auto-generated constructor stub
	}

	public List<Libro> buscarTodos() throws Exception {
		String jpql = "SELECT o FROM Libro o ORDER BY o.codigo";
		List<Libro> Libroes = (List<Libro>) em.createQuery(jpql, Libro.class).getResultList();
		return Libroes;
	}

	public Libro buscarPorCodigo(Integer codigo) throws Exception {
		return em.find(Libro.class, codigo);
	}

	public Libro actualizar(Libro LibroAct) throws Exception {
		Libro Libro = buscarPorCodigo(LibroAct.getCodigo()); // Busca el objeto Libro
		if (Libro == null) { // Si no encuentra Libro valdrá null
			LibroAct.setCodigo(null); // para que la bd auto-genere el ID
			em.persist(LibroAct);
			em.refresh(LibroAct);
		} else {
			LibroAct = em.merge(LibroAct);
		}
		return LibroAct;
	}

	public void eliminar(Integer codigo) throws Exception {
		Libro ciu = buscarPorCodigo(codigo); // Busca el objeto Libro
		if (ciu != null) {
			em.remove(ciu);
		}
	}
}
