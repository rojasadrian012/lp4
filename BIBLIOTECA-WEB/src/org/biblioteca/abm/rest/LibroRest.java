package org.biblioteca.abm.rest;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.biblioteca.abm.session.LibroSession;
import org.biblioteca.entidad.Libro;

@Path("libro")
public class LibroRest {
	@EJB
	LibroSession ls;

//GET http://localhost:8080/BIBLIOTECA-WEB/rest/libro/list
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Map<String, Object> listar() throws Exception {
		Map<String, Object> retorno = new HashMap<String, Object>();
		retorno.put("success", true);
		retorno.put("result", ls.buscarTodos());
		return retorno;
	}

//GET http://localhost:8080/BIBLIOTECA-WEB/rest/libro/find/n
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find/{codigo}")
	public Map<String, Object> buscar(@PathParam("codigo") Integer codigo) throws Exception {
		Map<String, Object> retorno = new HashMap<String, Object>();
		retorno.put("success", true);
		retorno.put("result", ls.buscarPorCodigo(codigo));
		return retorno;
	}

//PUT http://localhost:8080/BIBLIOTECA-WEB/rest/libro/update
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Map<String, Object> actualizar(Libro libro) throws Exception {
		Map<String, Object> retorno = new HashMap<String, Object>();
		retorno.put("success", true);
		retorno.put("result", ls.actualizar(libro));
		return retorno;
	}

//DELETE http://localhost:8080/BIBLIOTECA-WEB/rest/libro/delete/n
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{codigo}")
	public Map<String, Object> borrar(@PathParam("codigo") Integer codigo) throws Exception {
		Map<String, Object> retorno = new HashMap<String, Object>();
		retorno.put("success", true);
		ls.eliminar(codigo);
		return retorno;
	}
}