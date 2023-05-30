package main;

import javax.swing.*;

import clases.Usuario;
import excepciones.ConexionFallidaException;
import jbdc.DataBaseConnector;
import pantallass.PantallaSeleccionDestino;

import java.awt.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal {
	private static Connection connection;

	public static void main(String[] args) {
		try {
			// Conexión con la base de datos
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoprogramación", "root", "");
			connection = DataBaseConnector.getConnection();
			
			
			// Crea el JFrame
			JFrame loginFrame = new JFrame("Inicio de sesión/Registro");
			loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Crea el JPanel
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			
			// Añade la imagen al panel
            ImageIcon icon = new ImageIcon("principal.jpg");
            JLabel label = new JLabel();
            label.setIcon(icon);
            panel.add(label, BorderLayout.CENTER);
			
			
			
			

			// Campos de texto y botones
			JTextField userField = new JTextField(20);
			JPasswordField passwordField = new JPasswordField(20);
			JButton loginButton = new JButton("Iniciar sesión");
			JButton registerButton = new JButton("Registro");

			// Panel para los campos de texto y botones
			JPanel inputPanel = new JPanel();
			inputPanel.add(new JLabel("Usuario:"));
			inputPanel.add(userField);
			inputPanel.add(new JLabel("Contraseña:"));
			inputPanel.add(passwordField);
			inputPanel.add(loginButton);
			inputPanel.add(registerButton);
			panel.add(inputPanel, BorderLayout.SOUTH);

			// Añade el panel al frame
			loginFrame.add(panel);
			loginFrame.setSize(800, 600);
			loginFrame.setLocationRelativeTo(null);
			loginFrame.setVisible(true);

			// Acción para el botón de inicio de sesión
			loginButton.addActionListener(e -> {
				try {
					PreparedStatement ps = connection
							.prepareStatement("SELECT * FROM usuario WHERE nombre = ? AND contrasenia = ?");
					ps.setString(1, userField.getText());
					ps.setString(2, new String(passwordField.getPassword()));
					ResultSet rs = ps.executeQuery();

					if (rs.next()) {
						// Cierra la ventana de inicio de sesión/registro
						loginFrame.dispose();

						
						int id = rs.getInt("id");
						String nombre = rs.getString("nombre");
						String email= rs.getString("email");
						String contrasenia= rs.getString("contrasenia");
						
						// Abre la página principal
						Usuario user = new Usuario(nombre, id, email, false, contrasenia);
						new PantallaSeleccionDestino(user, connection);
						
					} else {
						JOptionPane.showMessageDialog(loginFrame,
								"Usuario o contraseña incorrecta. Por favor, intenta de nuevo.");
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				// Limpia los campos de texto
				userField.setText("");
				passwordField.setText("");
			});

			// Acción para el botón de registro
			registerButton.addActionListener(e -> {
				// Crea una nueva ventana de registro
				JFrame registerFrame = new JFrame("Registro");
				registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				// Crea un panel con los campos para el registro
				JPanel registerPanel = new JPanel();
				JTextField registerUserField = new JTextField(20);
				JPasswordField registerPasswordField = new JPasswordField(20);
				JTextField registerEmailField = new JTextField(20); // Campo para el correo electrónico
				JButton confirmRegisterButton = new JButton("Confirmar Registro");
				registerPanel.add(new JLabel("Usuario:"));
				registerPanel.add(registerUserField);
				registerPanel.add(new JLabel("Contraseña:"));
				registerPanel.add(registerPasswordField);
				registerPanel.add(new JLabel("Email:")); // Etiqueta para el campo de correo electrónico
				registerPanel.add(registerEmailField); // Añade el campo de correo electrónico al panel
				registerPanel.add(confirmRegisterButton);
				registerFrame.add(registerPanel);
				registerFrame.setSize(400, 200);
				registerFrame.setLocationRelativeTo(null);
				registerFrame.setVisible(true);

				// Acción para el botón de confirmación de registro
				confirmRegisterButton.addActionListener(ev -> {
					try {
						// Comprueba si el correo electrónico ya existe en la base de datos
						PreparedStatement checkEmail = connection
								.prepareStatement("SELECT * FROM Usuario WHERE email = ?");
						checkEmail.setString(1, registerEmailField.getText());
						ResultSet rs = checkEmail.executeQuery();

						if (rs.next()) {
							// Si el correo electrónico ya existe, muestra un mensaje al usuario
							JOptionPane.showMessageDialog(registerFrame,
									"Este correo electrónico ya ha sido registrado. Por favor, ingresa un correo electrónico diferente.");
						} else {
							// Si el correo electrónico no existe, inserta el nuevo usuario en la base de
							// datos
							PreparedStatement ps = connection.prepareStatement(
									"INSERT INTO Usuario (nombre, contrasenia, email, isBusiness) VALUES (?, ?, ?, ?)");
							ps.setString(1, registerUserField.getText());
							ps.setString(2, new String(registerPasswordField.getPassword()));
							ps.setString(3, registerEmailField.getText());
							ps.setBoolean(4, false); // asumimos que todos los nuevos usuarios no son administradores
							ps.executeUpdate();

							JOptionPane.showMessageDialog(registerFrame,
									"Registro exitoso. Ahora puedes iniciar sesión.");
							registerFrame.dispose(); // Cierra la ventana de registro
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}

					// Limpia los campos de texto
					registerUserField.setText("");
					registerPasswordField.setText("");
					registerEmailField.setText("");
				});
			});
		} catch (ConexionFallidaException ex) {
			ex.printStackTrace();
		}
	}
}


