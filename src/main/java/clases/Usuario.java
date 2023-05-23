package clases;

//Clase usuario
public class Usuario extends ElementoConNombre {
	// Atributos
	private int id;
	private String email;
	private boolean isAdmin;
	private String contrasena;

	// Constructor
	public Usuario(String nombre, int id, String nombreUsuario, String email, boolean isAdmin, String contrasena) {
		super(nombre);
		this.id = id;
		nombre = nombreUsuario;
		this.email = email;
		this.isAdmin = isAdmin;
		this.contrasena = contrasena;
	}

	// Metodos
	public void crear_usuario() {
		// Implementar la lógica para crear un usuario
	}

	public void eliminar_usuario() {
		// Implementar la lógica para eliminar un usuario
	}

	public void crear_contrasena() {
		// Implementar la lógica para crear una contraseña
	}

	public void modificar_contrasena() {
		// Implementar la lógica para modificar una contraseña
	}

	public void modificar_nombre() {
		// Implementar la lógica para modificar el nombre
	}

	public void crear_valoracion() {
		// Implementar la lógica para crear una valoración
	}

	// Getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}
