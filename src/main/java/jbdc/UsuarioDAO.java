package jbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.Usuario;
import excepciones.ConexionFallidaException;
//Nueva Clase Dao
public class UsuarioDAO {
    public void crear(Usuario usuario) throws ConexionFallidaException {
        String sql = "INSERT INTO usuario (id, nombre, contrasenia, email, isBusiness) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DataBaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, usuario.getId());
            pstmt.setString(2, usuario.getNombre());
            pstmt.setString(3, usuario.getContrasenia());
            pstmt.setString(4, usuario.getEmail());
            pstmt.setBoolean(5, usuario.getisBusiness());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ConexionFallidaException("Fallo al crear el usuario.");
        }
    }

    public void actualizarContrasenia(Usuario usuario) throws ConexionFallidaException {
        String sql = "UPDATE usuario SET contrasenia = ? WHERE id = ?";

        try (Connection conn = DataBaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getContrasenia());
            pstmt.setInt(2, usuario.getId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ConexionFallidaException("Fallo al actualizar la contraseña del usuario.");
        }
    }
}

