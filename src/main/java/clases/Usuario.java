package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import excepciones.ConexionFallidaException;
import jbdc.DataBaseConnector;

//Clase usuario
public class Usuario extends ElementoConNombre {
	// Atributos
	private int id;
	private String email;
	private boolean isAdmin;
	private String contraseña;

	// Constructor
	public Usuario(String nombre, int id, String nombreUsuario, String email, boolean isAdmin, String contrasena) {
		super(nombre);
		this.id = id;
		nombre = nombreUsuario;
		this.email = email;
		this.isAdmin = isAdmin;
		this.contraseña = contrasena;
	}

	// Metodos
	public void crear_usuario() throws ConexionFallidaException {
		
		
		
		    String sql = "INSERT INTO Usuario (Id, Nombre, Contraseña, Email, isAdmin) VALUES (?, ?, ?, ?, ?)";

		    try (Connection conn = DataBaseConnector.getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {

		        pstmt.setInt(1, this.id);
		        pstmt.setString(2, this.getNombre());
		        pstmt.setString(3, this.contraseña);
		        pstmt.setString(4, this.email);
		        pstmt.setBoolean(5, this.isAdmin);

		        pstmt.executeUpdate();

		    } catch (SQLException e) {
		        System.out.println(e.getMessage());
		    }
	}

	public void crear_contraseña() throws ConexionFallidaException {
		
		    String sql = "UPDATE Usuario SET Contraseña = ? WHERE Id = ?";

		    try (Connection conn = DataBaseConnector.getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {

		        pstmt.setString(1, this.contraseña);
		        pstmt.setInt(2, this.id);

		        pstmt.executeUpdate();

		    } catch (SQLException e) {
		        System.out.println(e.getMessage());
		    
		}


		
		
		
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
		return contraseña;
	}

	public void setContrasena(String contrasena) {
		this.contraseña = contrasena;
	}
}
