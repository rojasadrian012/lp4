package org.biblioteca.mov.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.biblioteca.entidad.Prestamo;
import org.biblioteca.entidad.PrestamoLibro;

@Stateless
public class PrestamoSession {

	@PersistenceContext
	EntityManager em;
	@EJB
	PrestamoLibroSession pls;

	public List<Prestamo> buscarTodos() throws Exception {
		String jpql = "SELECT o FROM Prestamo o ORDER BY o.numero";
		List<Prestamo> Prestamoes = (List<Prestamo>) em.createQuery(jpql, Prestamo.class).getResultList();
		return Prestamoes;
	}

	public Prestamo buscarPorCodigo(Integer codigo) throws Exception {
		return em.find(Prestamo.class, codigo);
	}

	public Prestamo actualizar(Prestamo prestamo, List<PrestamoLibro> prestamoLibroList) throws Exception {
		Prestamo prestamoFromBD = buscarPorCodigo(prestamo.getNumero());
		if (prestamoFromBD == null) {
			prestamo.setNumero(null);
			prestamo.setSituacion(0);
			em.persist(prestamo);
			em.refresh(prestamo);
		} else {
			prestamo = em.merge(prestamo);
		}
		pls.eliminarPorPrestamo(prestamo.getNumero());
		for (PrestamoLibro prestamoLibro : prestamoLibroList) {
			prestamoLibro.setSecuencia(null);
			prestamoLibro.setPrestamo(prestamo);
			em.persist(prestamoLibro);
		}
		return prestamo;
	}

	public void anular(Integer numero) throws Exception {
		Prestamo prestamo = buscarPorCodigo(numero);
		if (prestamo != null) {
			prestamo.setSituacion(1);
			em.merge(prestamo);
		}
	}
}