package org.biblioteca.abm.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.biblioteca.entidad.Cliente;
import org.biblioteca.entidad.Usuario;


@Stateless
@LocalBean
public class UsuarioSession {

	@PersistenceContext
	EntityManager em;

    public UsuarioSession() {
        // TODO Auto-generated constructor stub
    }

    public List<Usuario> buscarTodos() throws Exception {
		String jpql = "SELECT o FROM Usuario o ORDER BY o.codigo";
		List<Usuario> usuario = (List<Usuario>) em.createQuery(jpql, Usuario.class).getResultList();
		return usuario;
	}

	public Usuario buscarPorCodigo(Integer codigo) throws Exception {
		return em.find(Usuario.class, codigo);
	}

	public Usuario actualizar(Usuario usuarioAct) throws Exception {
		Usuario usuario = buscarPorCodigo(usuarioAct.getCodigo()); //Busca el objeto
		if (usuario == null) { // Si no encuentra usuario valdrá null
			usuarioAct.setCodigo(null); // para que la bd auto-genere el ID
			em.persist(usuarioAct);
			em.refresh(usuarioAct);
		} else {
			usuarioAct = em.merge(usuarioAct);
		}
		return usuarioAct;
	}

	public void eliminar(Integer codigo) throws Exception {
		Usuario usu = buscarPorCodigo(codigo); // Busca el objeto usuario
		if (usu != null) {
			em.remove(usu);
		}
	}
}

