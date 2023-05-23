package clases;

public class Museo extends ElementoConNombre {
	private String tema;
	private int numSalas;

	public Museo(String nombre, String tema, int numSalas) {
		super(nombre);
		this.tema = tema;
		this.numSalas = numSalas;
	}

	// Getters and setters

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getNumSalas() {
		return numSalas;
	}

	public void setNumSalas(int numSalas) {
		this.numSalas = numSalas;
	}
}
