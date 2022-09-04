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
import org.biblioteca.abm.session.ClienteSession;
import org.biblioteca.entidad.Cliente;
@Path("cliente_no_usar")
public class ClienteRestService {
@EJB ClienteSession cs;
//GET http://localhost:8080/PROYECTO-REST/rest/cliente/list
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/list")
public List<Cliente> listar() throws Exception{ return cs.buscarTodos();
}
//GET http://localhost:8080/PROYECTO-REST/rest/cliente/find/n
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/find/{codigo}")
public Cliente buscar(@PathParam("codigo") Integer codigo) throws Exception{ return cs.buscarPorCodigo(codigo);
}
//PUT http://localhost:8080/PROYECTO-REST/rest/cliente/update
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Path("/update")
public Cliente actualizar(Cliente cliente) throws Exception { return cs.actualizar(cliente);
}
//DELETE http://localhost:8080/PROYECTO-REST/rest/cliente/delete/n
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Path("/delete/{codigo}")
public void borrar(@PathParam("codigo") Integer codigo) throws Exception{ cs.eliminar(codigo);
}
}
