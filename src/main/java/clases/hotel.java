package clases;
public class hotel extends servicio {
	private String ubicacion;
	 private int estrellas;
	 public hotel(String nombre, String ubicacion, int estrellas) {
	     super(nombre);
	     this.ubicacion = ubicacion;
	     this.estrellas = estrellas;
	 }
	 @Override
	 public void mostrarDetalles() {
	     // Implementación de mostrarDetalles para Hotel
	 }

	 // Otros métodos y propiedades de Hotel
	}
