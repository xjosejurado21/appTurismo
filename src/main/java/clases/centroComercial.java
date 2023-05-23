package clases;

public class centroComercial extends elementoConNombre {
	private int numTiendas;
	private int numPlantas;

	// Constructor
	public centroComercial(String nombre, int numTiendas, int numPlantas) {
		super(nombre);
		this.numTiendas = numTiendas;
		this.numPlantas = numPlantas;
	}

	// Getters and setters

	public int getNumTiendas() {
		return numTiendas;
	}

	public void setNumTiendas(int numTiendas) {
		this.numTiendas = numTiendas;
	}

	public int getNumPlantas() {
		return numPlantas;
	}

	public void setNumPlantas(int numPlantas) {
		this.numPlantas = numPlantas;
	}
}
