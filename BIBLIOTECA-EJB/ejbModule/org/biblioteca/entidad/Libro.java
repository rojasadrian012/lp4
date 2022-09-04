package org.biblioteca.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lib_codigo")
	private Integer codigo;
	@Column(name = "lib_descripcion")
	private String descripcion;
	@Column(name = "lib_cantidad")
	private Integer cantidad;
	@Column(name = "lib_obs")
	private String obs;

	@ManyToOne
	@JoinColumn(name = "lib_tipo")
	private LibrosTipos tipos;
	
	public Libro() {
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public LibrosTipos getTipos() {
		return tipos;
	}

	public void setTipos(LibrosTipos tipos) {
		this.tipos = tipos;
	}
	
	
	
}