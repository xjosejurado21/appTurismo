package clases;

public class Restaurante extends ServicioConHorario {
	private int rangoPrecio;
		//Constructor
	public Restaurante(String nombre, int id, String descripcion, String url, String direccion, String ciudad,
			String horario, int rangoPrecio) {
		super(nombre, id, descripcion, url, direccion, ciudad, horario);
		this.rangoPrecio = rangoPrecio;
	}
	//Getters and setters
	public int getRangoPrecio() {
		return rangoPrecio;
	}
	public void setRangoPrecio(int rangoPrecio) {
		this.rangoPrecio = rangoPrecio;
	}
}
