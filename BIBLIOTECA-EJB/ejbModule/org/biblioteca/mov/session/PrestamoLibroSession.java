package org.biblioteca.mov.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.biblioteca.entidad.Prestamo;
import org.biblioteca.entidad.PrestamoLibro;

@Stateless
public class PrestamoLibroSession {
	@PersistenceContext
	EntityManager em;

	public List<PrestamoLibro> buscarPorNumeroPrestamo(Integer numeroPrestamo) throws Exception {
		String jpql = "SELECT o FROM PrestamoLibro o WHERE o.prestamo = " + numeroPrestamo;
		List<PrestamoLibro> prestamosLibros = (List<PrestamoLibro>) em.createQuery(jpql, PrestamoLibro.class).getResultList();
		return prestamosLibros;
	}

	public void eliminarPorPrestamo(Integer numeroPrestamo) throws Exception {
		Query q = em.createQuery("DELETE FROM PrestamoLibro pl WHERE pl.prestamo=" + numeroPrestamo);
		q.executeUpdate();
	}
}