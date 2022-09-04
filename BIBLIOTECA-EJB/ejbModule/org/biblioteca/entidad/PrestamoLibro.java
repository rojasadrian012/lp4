package org.biblioteca.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "prestamos_libros")
public class PrestamoLibro implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pli_secuencia")
	private Integer secuencia;
	@ManyToOne
	@JoinColumn(name = "pli_prestamo")
	private Prestamo prestamo;
	@Temporal(TemporalType.DATE)
	@Column(name = "pli_fecha_devolucion")
	private Date fechaDevolucion;
	@Column(name = "pli_dias")
	private Integer dias;
	@Column(name = "pli_estado")
	private Integer estado;  //0: Prestado 1: Devuelto
	@ManyToOne
	@JoinColumn(name = "pli_libro")
	private Libro libro;
	@Column(name = "pli_valor")
	private Double valor;

	public PrestamoLibro() {
		prestamo = new Prestamo();
		libro = new Libro();
	}

	public Integer getDias() {
		return this.dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Libro getLibro() {
		return this.libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Prestamo getPrestamo() {
		return this.prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Integer getSecuencia() {
		return this.secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}