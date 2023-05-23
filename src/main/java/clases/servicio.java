package clases;

import java.util.HashSet;

public  abstract class servicio extends elementoConNombre {
   

	private int id;
    private String descripcion;
    private float precio;
    private HashSet<servicio> reservasActivas; // Asumiendo que existe una clase Reserva

   //Constructor
    public servicio(String nombre, int id, String descripcion, float precio, HashSet<servicio> reservasActivas) {
    	super(nombre);
    	this.id = id;
    	this.descripcion = descripcion;
    	this.precio = precio;
    	this.reservasActivas = reservasActivas;
    }
    
    //Metodos

	public void crearReserva(servicio reserva) {
        this.reservasActivas.add(reserva);
    }

	public void anularReserva(servicio reserva) {
        this.reservasActivas.remove(reserva);
    }

    public void modificarReserva(servicio antiguaReserva, servicio nuevaReserva) {
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

    public HashSet<servicio> getReservasActivas() {
        return reservasActivas;
    }
}

