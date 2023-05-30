package clases;

public class Hotel extends ServicioConHorario {
	private int rangoPrecio;
	private int numHabitaciones;
	// Constructor
	public Hotel(String nombre, int id, String descripcion, String url, String direccion, String ciudad, String horario,
			int rangoPrecio, int numHabitaciones) {
		super(nombre, id, descripcion, url, direccion, ciudad, horario);
		this.rangoPrecio = rangoPrecio;
		this.numHabitaciones = numHabitaciones;
	}
	//Getters y setters
	public int getRangoPrecio() {
		return rangoPrecio;
	}
	public void setRangoPrecio(int rangoPrecio) {
		this.rangoPrecio = rangoPrecio;
	}
	public int getNumHabitaciones() {
		return numHabitaciones;
	}
	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}
	

}
