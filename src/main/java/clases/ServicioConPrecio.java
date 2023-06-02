package clases;

public class ServicioConPrecio extends ServicioConHorario {

	private int precio;

	public ServicioConPrecio(String nombre, int id, String descripcion, String url, String direccion, String ciudad,
			String horario, int precio) {
		super(nombre, id, descripcion, url, direccion, ciudad, horario);
		this.precio = precio;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return super.toString()+"Precio=" + precio;
	}
	
	
	
	
}
