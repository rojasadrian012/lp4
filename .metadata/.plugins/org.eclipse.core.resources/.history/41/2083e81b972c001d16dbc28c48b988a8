package org.biblioteca.abm.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.biblioteca.abm.session.CiudadSession;
import org.biblioteca.entidad.Ciudad;

@Path("ciudad_no_usar")
public class CiudadRestService {
	@EJB
	CiudadSession cs;

//GET http://localhost:8080/PROYECTO-REST/rest/ciudad/list
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<Ciudad> listar() throws Exception {
		return cs.buscarTodos();
	}

//GET http://localhost:8080/PROYECTO-REST/rest/ciudad/find/variable
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find/{codigo}")
	public Ciudad buscar(@PathParam("codigo") Integer codigo) throws Exception {
		return cs.buscarPorCodigo(codigo);
	}

//PUT http://localhost:8080/PROYECTO-REST/rest/ciudad/update
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Ciudad actualizar(Ciudad ciudad) throws Exception {
		return cs.actualizar(ciudad);
	}

//DELETE http://localhost:8080/PROYECTO-REST/rest/ciudad/delete/variable
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{codigo}")
	public void borrar(@PathParam("codigo") Integer codigo) throws Exception {
		cs.eliminar(codigo);
	}
}