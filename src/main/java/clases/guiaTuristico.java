package clases;

public class guiaTuristico extends servicio {
	private String idioma;
	 public guiaTuristico(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}
	 public guiaTuristico(String nombre, String idioma) {
	     super(nombre);
	     this.idioma = idioma;
	 }
	 @Override
	 public void mostrarDetalles() {
	     // Implementación de mostrarDetalles para GuiaTuristico
	 }
}