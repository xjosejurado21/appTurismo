package clases;

public class ServicioTurismo extends ElementoConNombre {

	private String direccion;
	private String horario;
	private String categoria;
	private String imagen;
	private String contacto;

	// Constructor
	public ServicioTurismo(String nombre, String direccion, String horario, String categoria, String imagen,
			String contacto) {
		super(nombre);
		this.direccion = direccion;
		this.horario = horario;
		this.categoria = categoria;
		this.imagen = imagen;
		this.contacto = contacto;
	}

	// Metodos

	public void seleccionarServicio() {
		// Implementar lógica para seleccionar un servicio
	}

	public void cancelarServicio() {
		// Implementar lógica para cancelar un servicio
	}

	public void modificarServicio() {
		// Implementar lógica para modificar un servicio
	}

	// Getters and setters

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

}
