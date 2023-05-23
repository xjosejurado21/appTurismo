package clases;

public class Hotel extends ElementoConNombre {
	private int estrellas;

	// Constructor
	public Hotel(String nombre, int estrellas) {
		super(nombre);
		this.estrellas = estrellas;
	}

	// Getters and setters

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}
}
