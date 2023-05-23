package clases;

import java.util.List;

public class alquiler extends elementoConNombre {
    private String tipo;
    private float precio;
    private List<servicio> servicios; 

    //Constructor
    public alquiler(String nombre, String tipo, float precio, List<servicio> servicios) {
		super(nombre);
		this.tipo = tipo;
		this.precio = precio;
		this.servicios = servicios;
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

    public List<servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<servicio> servicios) {
        this.servicios = servicios;
    }
}

