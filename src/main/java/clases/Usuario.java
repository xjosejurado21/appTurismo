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
	private boolean isBusiness;
	private String contrasenia;

	// Constructor
	public Usuario(String nombre, int id, String email, boolean isBusiness, String contrasenia) {
		super(nombre);
		this.id = id;
		this.email = email;
		this.isBusiness = isBusiness;
		this.contrasenia = contrasenia;
	}

	// Metodos
	public void crear_usuario() throws ConexionFallidaException {
		
		
		
		    String sql = "INSERT INTO usuario (id, nombre, contrasenia, email, isBusiness) VALUES (?, ?, ?, ?, ?)";

		    try (Connection conn = DataBaseConnector.getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {

		        pstmt.setInt(1, this.id);
		        pstmt.setString(2, this.getNombre());
		        pstmt.setString(3, this.contrasenia);
		        pstmt.setString(4, this.email);
		        pstmt.setBoolean(5, this.isBusiness);

		        pstmt.executeUpdate();

		    } catch (SQLException e) {
		        System.out.println(e.getMessage());
		    }
	}

	public void crear_contrasenia() throws ConexionFallidaException {
		
		    String sql = "UPDATE usuario SET contrasenia = ? WHERE id = ?";

		    try (Connection conn = DataBaseConnector.getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {

		        pstmt.setString(1, this.contrasenia);
		        pstmt.setInt(2, this.id);

		        pstmt.executeUpdate();

		    } catch (SQLException e) {
		        System.out.println(e.getMessage());
		    
		}
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

	public boolean getisBusiness() {
		return isBusiness;
	}

	public void setisBusiness(boolean isBusiness) {
		this.isBusiness = isBusiness;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}
