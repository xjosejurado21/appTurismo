package clases;

import java.util.List;

public class Alquiler extends ElementoConNombre {
	private String tipo;
	private float precio;
	private List<Servicio> Servicios;

	// Constructor
	public Alquiler(String nombre, String tipo, float precio, List<Servicio> Servicios) {
		super(nombre);
		this.tipo = tipo;
		this.precio = precio;
		this.Servicios = Servicios;
	}
	// Getters and setters

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<Servicio> getServicios() {
		return Servicios;
	}

	public void setServicios(List<Servicio> Servicios) {
		this.Servicios = Servicios;
	}
}
