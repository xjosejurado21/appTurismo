package clases;

import java.util.Date;

public class otrasActividades extends elementoConNombre {
	private String descripcion;
	private Date fechaInicio;
	private Date fechaSalida;

	//Cosntructor
	public otrasActividades(String nombre, String descripcion, Date fechaInicio, Date fechaSalida) {
		super(nombre);
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaSalida = fechaSalida;
	}

	// Getters and setters

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
}
