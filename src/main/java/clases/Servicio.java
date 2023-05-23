package clases;

import java.util.HashSet;

public abstract class Servicio extends ElementoConNombre {
	private int id;
	private String descripcion;
	private float precio;
	private HashSet<Servicio> reservasActivas; // Asumiendo que existe una clase Reserva

	// Constructor
	public Servicio(String nombre, int id, String descripcion, float precio, HashSet<Servicio> reservasActivas) {
		super(nombre);
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.reservasActivas = reservasActivas;
	}

	// Metodos

	public void crearReserva(Servicio reserva) {
		this.reservasActivas.add(reserva);
	}

	public void anularReserva(Servicio reserva) {
		this.reservasActivas.remove(reserva);
	}

	public void modificarReserva(Servicio antiguaReserva, Servicio nuevaReserva) {
		this.reservasActivas.remove(antiguaReserva);
		this.reservasActivas.add(nuevaReserva);
	}

	// Getters and setters

	public int getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public HashSet<Servicio> getReservasActivas() {
		return reservasActivas;
	}
}
