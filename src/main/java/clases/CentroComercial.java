package clases;

public class CentroComercial extends ServicioConHorario {
	private int numTiendas;
	private int numPisos;
	// Constructor
	public CentroComercial(String nombre, int id, String descripcion, String url, String direccion, String ciudad,
			String horario, int numTiendas, int numPisos) {
		super(nombre, id, descripcion, url, direccion, ciudad, horario);
		this.numTiendas = numTiendas;
		this.numPisos = numPisos;
	}
	public int getNumTiendas() {
		return numTiendas;
	}
	public void setNumTiendas(int numTiendas) {
		this.numTiendas = numTiendas;
	}
	public int getNumPisos() {
		return numPisos;
	}
	public void setNumPisos(int numPisos) {
		this.numPisos = numPisos;
	}
	
}
