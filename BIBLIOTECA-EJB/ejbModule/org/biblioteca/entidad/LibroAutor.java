package org.biblioteca.entidad;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "libros_autores")
public class LibroAutor implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	LibroAutorPK id;
	@ManyToOne
	@JoinColumn(name = "lau_autor", insertable = false, updatable = false)
	private Autor autor;
	@ManyToOne
	@JoinColumn(name = "lau_libro", insertable = false, updatable = false)
	private Libro libro;

	public LibroAutor() {
	}

	public LibroAutorPK getId() {
		return id;
	}

	public void setId(LibroAutorPK id) {
		this.id = id;
	}

	public Autor getAutor() {
		return this.autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Libro getLibro() {
		return this.libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
}
