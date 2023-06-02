package clases;

public class Evento extends ServicioConPrecio {

	private String fecha;
	private String artista;

	// Constructor
	public Evento(String nombre, int id, String descripcion, String url, String direccion, String ciudad,
			String horario, int precio, String fecha, String artista) {
		super(nombre, id, descripcion, url, direccion, ciudad, horario, precio);
		this.fecha = fecha;
		this.artista = artista;
	}
	
	//Getters and setters

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return super.toString()+ "Fecha=" + fecha + ", artista=" + artista;
	}

	

	
	
	

}
