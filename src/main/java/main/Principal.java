package main;

import javax.swing.*;
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

public class Principal {

    private static Connection connection;

    public static void main(String[] args) {
        try {
            // Conexión con la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoprogramación", "root", "");

            // Crea el JFrame
            JFrame loginFrame = new JFrame("Inicio de sesión/Registro");
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Crea el JPanel
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            // Imagen
            ImageIcon imageIcon = new ImageIcon("path-to-your-image"); // Reemplaza con el path de tu imagen
            JLabel imageLabel = new JLabel(imageIcon);
            panel.add(imageLabel, BorderLayout.CENTER);

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
                    PreparedStatement ps = connection.prepareStatement("SELECT * FROM Usuario WHERE Nombre = ? AND Contraseña = ?");
                    ps.setString(1, userField.getText());
                    ps.setString(2, new String(passwordField.getPassword()));
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        // Cierra la ventana de inicio de sesión/registro
                        loginFrame.dispose();

                        // Abre la página principal
                        new MainPage(rs.getString("Nombre"));
                    } else {
                        JOptionPane.showMessageDialog(loginFrame, "Usuario o contraseña incorrecta. Por favor, intenta de nuevo.");
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
                try {
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO Usuario (Nombre, Contraseña) VALUES (?, ?)");
                    ps.setString(1, userField.getText());
                    ps.setString(2, new String(passwordField.getPassword()));
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(loginFrame, "Registro exitoso. Ahora puedes iniciar sesión.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                // Limpia los campos de texto
                userField.setText("");
                passwordField.setText("");
            });
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    
}

// Aquí necesitarás implementar la clase MainPage
class MainPage extends JFrame {
    public MainPage(String user) {
        super("Página principal");

        // Aquí puedes agregar el contenido de la página principal.

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
