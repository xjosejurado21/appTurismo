package clases;

import java.util.List;

public class GuiaTuristico extends ElementoConNombre {

	private List<String> idiomas;
	private int experiencia;

	// constructor
	public GuiaTuristico(String nombre, List<String> idiomas, int experiencia) {
		super(nombre);
		this.idiomas = idiomas;
		this.experiencia = experiencia;
	}

	// Getters and setters

	public List<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<String> idiomas) {
		this.idiomas = idiomas;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
}