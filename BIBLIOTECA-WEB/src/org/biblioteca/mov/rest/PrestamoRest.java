package org.biblioteca.mov.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.biblioteca.entidad.Prestamo;
import org.biblioteca.entidad.PrestamoLibro;
import org.biblioteca.mov.session.PrestamoSession;

@Path("prestamo")
public class PrestamoRest {
	@EJB
	PrestamoSession cs;

//GET http://localhost:8080/BIBLIOTECA-WEB/rest/prestamo/list
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<Prestamo> listar() throws Exception {
		return cs.buscarTodos();
	}

//GET http://localhost:8080/BIBLIOTECA-WEB/rest/prestamo/find/n
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find/{codigo}")
	public Prestamo buscar(@PathParam("codigo") Integer codigo) throws Exception {
		return cs.buscarPorCodigo(codigo);
	}

	//PUT http://localhost:8080/BIBLIOTECA-WEB/rest/prestamo/update
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	// public Prestamo actualizar(Prestamo prestamo, List<PrestamoLibro>
	// prestamoLibroList) throws Exception {
	public Prestamo actualizar(Map<String, Object> requestData) throws Exception {
		System.out.println("Dato del exterior " + requestData);
		List<Map<String, Object>> lista = (List<Map<String, Object>>) requestData.get("lista");
		Prestamo prestamo = new Prestamo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		prestamo.setNumero(Integer.valueOf(requestData.get("numero").toString()));
		prestamo.setFecha(sdf.parse(requestData.get("fecha").toString()));
		prestamo.getCliente().setCodigo(Integer.valueOf(((Map<String, Object>) requestData.get("cliente")).get("codigo").toString()));
		prestamo.setSituacion(Integer.valueOf(requestData.get("situacion").toString()));
		prestamo.getUsuario().setCodigo(Integer.valueOf(((Map<String, Object>) requestData.get("usuario")).get("codigo").toString()));
		prestamo.setTotal(Double.valueOf(requestData.get("total").toString()));
		prestamo.setObservacion(requestData.get("observacion").toString());

		List<PrestamoLibro> prestamoLibroList = new ArrayList<PrestamoLibro>();
		for (Map<String, Object> map : lista) {

			PrestamoLibro prestamoLibro = new PrestamoLibro();
			prestamoLibro.setDias(Integer.valueOf(map.get("dias").toString()));
			prestamoLibro.setEstado(Integer.valueOf(map.get("estado").toString()));
			prestamoLibro.getLibro().setCodigo((Integer.valueOf(((Map<String, Object>) map.get("libro")).get("codigo").toString())));
			prestamoLibro.setValor(Double.valueOf(map.get("valor").toString()));
			prestamoLibro.setFechaDevolucion(sdf.parse(map.get("fechaDevolucion").toString()));

			prestamoLibroList.add(prestamoLibro);
		}
		return cs.actualizar(prestamo, prestamoLibroList);
	}

//DELETE http://localhost:8080/BIBLIOTECA-WEB/rest/prestamo/delete/n
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{numero}")
	public void borrar(@PathParam("numero") Integer numero) throws Exception {
		cs.anular(numero);
	}
}