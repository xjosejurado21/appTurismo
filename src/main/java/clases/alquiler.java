package clases;

import java.util.List;

public class alquiler {
    private String tipo;
    private float precio;
    private List<servicio> servicios; 

    public alquiler(String tipo, float precio, List<servicio> servicios) {
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

