package clases;

import java.util.Date;
import java.util.List;

public class viaje extends elementoConNombre {
	private String destino;
	private Date fechaLlegada;
	private Date fechaSalida;
	private int numPersonas;
	private List<servicio> listaServicios;
	private String tarjetaCredito;

	// Constructor
	public viaje(String nombre, String destino, Date fechaLlegada, Date fechaSalida, int numPersonas,
			List<servicio> listaServicios, String tarjetaCredito) {
		super(nombre);
		this.destino = destino;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.numPersonas = numPersonas;
		this.listaServicios = listaServicios;
		this.tarjetaCredito = tarjetaCredito;
	}

	// Metodo
	public void actualizarServicios(List<servicio> nuevosServicios) {
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

	public List<servicio> getListaServicios() {
		return listaServicios;
	}

	public String getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(String tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}
}
