package jbdc;

import java.sql.*;

import excepciones.ConexionFallidaException;

public class DataBaseConnector {
	
	
	
	//Creamos las variables privadas con los respectivos valores para conectarnos a la base de datos.
		private static final String ddbb = "appturismo";
	    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/"+ddbb;
	    private static final String DATABASE_USER = "root";
	    private static final String DATABASE_PASSWORD = "";
	//Aqui creamos una excepcion propia la cual llamamos ConexionFallidaException
	    public static Connection getConnection() throws ConexionFallidaException {
	        try {
	            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
	            // Aquí simplemente retornamos la conexión. No lanzamos una excepción.
	            return connection;
	        } catch (SQLException ex) {
	            throw new ConexionFallidaException("Fallo al conectar a la base de datos.");
	        }
	    }
	}