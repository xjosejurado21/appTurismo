package clases;

public class Destino extends ElementoConNombre{

	
	private String descripcion;
	private String ruta;
	private String url;
	
	
	public Destino(String nombre, String descripcion, String ruta, String url) {
		super(nombre);
		this.descripcion = descripcion;
		this.ruta = ruta;
		this.url = url;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
}
