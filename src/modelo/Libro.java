package modelo;

public class Libro {

	// propiedades
	private int id;
	private String titulo;
	private float precio;

	// 2 constructores
	public Libro(int id, String titulo, float precio) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;

	}

	public Libro() {

	}

	// getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
