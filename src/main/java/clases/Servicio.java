package clases;

import java.util.HashSet;

public abstract class Servicio extends ElementoConNombre {
	
	private int id;
	private String descripcion;
	private String url;
	private String direccion;
	private String ciudad;
	
	//Constructor
	public Servicio(String nombre, int id, String descripcion, String url, String direccion, String ciudad) {
		super(nombre);
		this.id = id;
		this.descripcion = descripcion;
		this.url = url;
		this.direccion = direccion;
		this.ciudad = ciudad;
	}
	//Getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
	
	
	
}
