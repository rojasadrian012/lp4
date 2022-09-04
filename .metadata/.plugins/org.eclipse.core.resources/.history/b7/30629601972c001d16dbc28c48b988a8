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

import org.biblioteca.abm.session.AutorSession;
import org.biblioteca.abm.session.UsuarioSession;
import org.biblioteca.entidad.Autor;
import org.biblioteca.entidad.Usuario;

@Path("autor_no_usar")
public class AutorRestService {
@EJB AutorSession as;
	
	//GET http://localhost:8080/PROYECTO-REST/rest/autor/list
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<Autor> listar() throws Exception{ 
		return as.buscarTodos();
	}
	//GET http://localhost:8080/PROYECTO-REST/rest/autor/find/n
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find/{codigo}")
	public Autor buscar(@PathParam("codigo") Integer codigo) throws Exception{ 
		return as.buscarPorCodigo(codigo);
	}
	//PUT http://localhost:8080/PROYECTO-REST/rest/autor/update
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Autor actualizar(Autor autor) throws Exception { 
		return as.actualizar(autor);
	}
	//DELETE http://localhost:8080/PROYECTO-REST/rest/autor/delete/n
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{codigo}")
	public void borrar(@PathParam("codigo") Integer codigo) throws Exception{ as.eliminar(codigo);
	}
	}
