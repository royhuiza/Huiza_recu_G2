package pe.edu.upeu.examen.entity;

public class Pelicula {
	private int idpelicula;
	private String titulo;
	private String genero;
	private String idioma;
	
	public Pelicula() {
		super();
	}

	public Pelicula(int idpelicula, String titulo, String genero, String idioma) {
		super();
		this.idpelicula = idpelicula;
		this.titulo = titulo;
		this.genero = genero;
		this.idioma = idioma;
	}

	public int getIdpelicula() {
		return idpelicula;
	}

	public void setIdpelicula(int idpelicula) {
		this.idpelicula = idpelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	

	
}
