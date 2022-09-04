package org.biblioteca.mov.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.biblioteca.entidad.PrestamoLibro;
import org.biblioteca.mov.session.PrestamoLibroSession;

@Path("prestamo-libro")
public class PrestamoLibroRest {
	@EJB
	PrestamoLibroSession pls;
	//GET http://localhost:8080/BIBLIOTECA-WEB/rest/prestamo-libro/find-by-prestamo/{prestamoId}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find-by-prestamo/{prestamoId}")
	public List<PrestamoLibro> buscar(@PathParam("prestamoId") Integer prestamoId) throws Exception{
	return pls.buscarPorNumeroPrestamo(prestamoId);
	}
	//DELETE http://localhost:8080/BIBLIOTECA-WEB/rest/prestamo-libro/delete/{prestamoId}
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{prestamoId}")
	public void borrarPorPrestamo(@PathParam("prestamoId") Integer prestamoId) throws Exception{
	pls.eliminarPorPrestamo(prestamoId);
	}

}