package clases;

import java.util.Date;
import java.util.List;

public class Viaje extends ElementoConNombre {
	private String destino;
	private Date fechaLlegada;
	private Date fechaSalida;
	private int numPersonas;
	private List<Servicio> listaServicios;
	private String tarjetaCredito;

	// Constructor
	public Viaje(String nombre, String destino, Date fechaLlegada, Date fechaSalida, int numPersonas,
			List<Servicio> listaServicios, String tarjetaCredito) {
		super(nombre);
		this.destino = destino;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.numPersonas = numPersonas;
		this.listaServicios = listaServicios;
		this.tarjetaCredito = tarjetaCredito;
	}

	// Metodo
	public void actualizarServicios(List<Servicio> nuevosServicios) {
		this.listaServicios = nuevosServicios;
	}

	// Getters and setters

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public List<Servicio> getListaServicios() {
		return listaServicios;
	}

	public String getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(String tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}
}
