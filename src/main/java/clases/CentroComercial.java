package clases;

public class CentroComercial extends ServicioConHorario {
	private int numTiendas;
	private int numPlantas;
	// Constructor
	public CentroComercial(String nombre, int id, String descripcion, String url, String direccion, String ciudad,
			String horario, int numTiendas, int numPlantas) {
		super(nombre, id, descripcion, url, direccion, ciudad, horario);
		this.numTiendas = numTiendas;
		this.numPlantas = numPlantas;
	}
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
