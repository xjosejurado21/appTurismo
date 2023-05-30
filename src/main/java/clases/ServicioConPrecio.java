package clases;

public class ServicioConPrecio extends ElementoConNombre {

	private int precio;

	public ServicioConPrecio(String nombre, int precio) {
		super(nombre);
		this.precio = precio;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	
}
