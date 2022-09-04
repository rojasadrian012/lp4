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
import org.biblioteca.abm.session.ClienteSession;
import org.biblioteca.entidad.Cliente;
@Path("cliente")
public class ClienteRest {
@EJB ClienteSession cs;
//GET http://localhost:8080/PROYECTO-REST/rest/cliente/list
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/list")
public Map<String, Object> listar() throws Exception{ 
	Map<String, Object> retorno = new HashMap<String, Object>();
	retorno.put("success", true);
	retorno.put("result", cs.buscarTodos());
	return retorno;
}
//GET http://localhost:8080/BIBLIOTECA-WEB/rest/cliente/find/n
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/find/{codigo}")
public Map<String, Object> buscar(@PathParam("codigo") Integer codigo) throws Exception{ 
	Map<String, Object> retorno = new HashMap<String, Object>();
	retorno.put("success", true);
	retorno.put("result", cs.buscarPorCodigo(codigo));
	return retorno;

}
//PUT http://localhost:8080/BIBLIOTECA-WEB/rest/cliente/update
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Path("/update")
public Map<String, Object> actualizar(Cliente cliente) throws Exception { 
	Map<String, Object> retorno = new HashMap<String, Object>();
	retorno.put("success", true);
	retorno.put("result", cs.actualizar(cliente));
	return retorno;
}
//DELETE http://localhost:8080/BIBLIOTECA-WEB/rest/cliente/delete/n
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Path("/delete/{codigo}")
public Map<String, Object> borrar(@PathParam("codigo") Integer codigo) throws Exception{ 
	Map<String, Object> retorno = new HashMap<String, Object>();
	retorno.put("success", true);
	cs.eliminar(codigo);
	return retorno;
}
}