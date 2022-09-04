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
import org.biblioteca.abm.session.LibroSession;
import org.biblioteca.entidad.Libro;
@Path("libro")
public class LibroRestService {
@EJB
LibroSession ls;
//GET http://localhost:8080/PROYECTO-REST/rest/libro/list
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/list") public List<Libro> listar() throws Exception{ return ls.buscarTodos();
}
//GET http://localhost:8080/PROYECTO-REST/rest/libro/find/n
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/find/{codigo}")
public Libro buscar(@PathParam("codigo") Integer codigo) throws Exception{
return ls.buscarPorCodigo(codigo);
}
//PUT http://localhost:8080/PROYECTO-REST/rest/libro/update
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Path("/update")
public Libro actualizar(Libro libro) throws Exception {
return ls.actualizar(libro);
}
//DELETE http://localhost:8080/PROYECTO-REST/rest/libro/delete/n
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Path("/delete/{codigo}")
public void borrar(@PathParam("codigo") Integer codigo) throws Exception{
ls.eliminar(codigo);
}
}