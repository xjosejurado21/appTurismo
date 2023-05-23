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

public class Principal {

    private static String registeredUser = null;
    private static String registeredPassword = null;

    public static void main(String[] args) {
        
        JFrame loginFrame = new JFrame("Bienvenido");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Imagen
        JPanel imagePanel = new JPanel();
        ImageIcon image = new ImageIcon("path-to-image.jpg"); // Change this to your image path
        JLabel imageLabel = new JLabel(image);
        imagePanel.add(imageLabel);

        // Login/Registro
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

       
        loginButton.addActionListener(e -> {
            if (registeredUser == null || registeredPassword == null) {
                JOptionPane.showMessageDialog(loginFrame, "Por favor, regístrese primero.");
            } else if (userField.getText().equals(registeredUser) && new String(passwordField.getPassword()).equals(registeredPassword)) {
                loginFrame.dispose();
                new main("user");
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Usuario o contraseña incorrecta. Por favor, intente de nuevo.");
            }
            // limpiar archivos
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
            // limpiar contenido
            userField.setText("");
            passwordField.setText("");
        });
        
        
        
        
        
        
    }



}

