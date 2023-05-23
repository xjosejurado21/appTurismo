package clases;

public class Restaurante extends ElementoConNombre {
	private String tipoComida;
	private int mesas;

	// Constructor
	public Restaurante(String nombre, String tipoComida, int mesas) {
		super(nombre);
		this.tipoComida = tipoComida;
		this.mesas = mesas;
	}
	// Getters and setters

	public String getTipoComida() {
		return tipoComida;
	}

	public void setTipoComida(String tipoComida) {
		this.tipoComida = tipoComida;
	}

	public int getMesas() {
		return mesas;
	}

	public void setMesas(int mesas) {
		this.mesas = mesas;
	}
}
