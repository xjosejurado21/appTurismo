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

public class principal {

    private static String registeredUser = null;
    private static String registeredPassword = null;

    public static void main(String[] args) {
        
        JFrame loginFrame = new JFrame("Bienvenido");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Image
        JPanel imagePanel = new JPanel();
        ImageIcon image = new ImageIcon("path-to-image.jpg"); // Change this to your image path
        JLabel imageLabel = new JLabel(image);
        imagePanel.add(imageLabel);

        // Login/Registration
        JPanel loginPanel = new JPanel();
        JTextField userField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Iniciar sesión");
        JButton registerButton = new JButton("Registro");

        loginPanel.add(new JLabel("Usuario:"));
        loginPanel.add(userField);
        loginPanel.add(new JLabel("Contraseña:"));
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);

        mainPanel.add(imagePanel, BorderLayout.CENTER);
        mainPanel.add(loginPanel, BorderLayout.SOUTH);

        loginFrame.add(mainPanel);
        loginFrame.setSize(800, 600);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);

        // Add event listeners to buttons
        loginButton.addActionListener(e -> {
            if (registeredUser == null || registeredPassword == null) {
                JOptionPane.showMessageDialog(loginFrame, "Por favor, regístrese primero.");
            } else if (userField.getText().equals(registeredUser) && new String(passwordField.getPassword()).equals(registeredPassword)) {
                loginFrame.dispose();
                new MainPage("user");
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Usuario o contraseña incorrecta. Por favor, intente de nuevo.");
            }
            // Clear fields
            userField.setText("");
            passwordField.setText("");
        });

        registerButton.addActionListener(e -> {
            if (userField.getText().isEmpty() || passwordField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(loginFrame, "Ambos campos deben estar llenos para registrarse.");
            } else {
                registeredUser = userField.getText();
                registeredPassword = new String(passwordField.getPassword());
                JOptionPane.showMessageDialog(loginFrame, "Registro exitoso. Ahora puede iniciar sesión.");
            }
            // Clear fields
            userField.setText("");
            passwordField.setText("");
        });
    }
}

class MainPage extends JFrame {

    public MainPage(String userType) {
        super("Página Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();

        // Add elements depending on user type
        if ("unregistered".equals(userType)) {
            // Display services
            mainPanel.add(new JLabel("Mostrar servicios aquí"));
        } else if ("user".equals(userType)) {
            // Display and edit reservations
            mainPanel.add(new JLabel("Mostrar y editar reservas aquí"));
        } else if ("admin".equals(userType)) {
            // Administer users
            mainPanel.add(new JLabel("Administrar usuarios aquí"));
        }

        add(mainPanel);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
