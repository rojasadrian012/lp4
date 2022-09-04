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

import org.biblioteca.abm.session.UsuarioSession;
import org.biblioteca.entidad.Usuario;
@Path("usuario_no_usar")
public class UsuarioRestService {

	@EJB UsuarioSession us;
	
	//GET http://localhost:8080/PROYECTO-REST/rest/usuario/list
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<Usuario> listar() throws Exception{ 
		return us.buscarTodos();
	}
	//GET http://localhost:8080/PROYECTO-REST/rest/usuario/find/n
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find/{codigo}")
	public Usuario buscar(@PathParam("codigo") Integer codigo) throws Exception{ 
		return us.buscarPorCodigo(codigo);
	}
	//PUT http://localhost:8080/PROYECTO-REST/rest/usuario/update
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public Usuario actualizar(Usuario usuario) throws Exception { 
		return us.actualizar(usuario);
	}
	//DELETE http://localhost:8080/PROYECTO-REST/rest/usuario/delete/n
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{codigo}")
	public void borrar(@PathParam("codigo") Integer codigo) throws Exception{ us.eliminar(codigo);
	}
	}


