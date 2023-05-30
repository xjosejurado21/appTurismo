package jbdc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Destino;
import clases.Hotel;
import clases.Museo;
import enums.TipoMuseo;
import excepciones.ConexionFallidaException;

public class DAO {

	private static Connection conexion = null;
	
	public static ArrayList<Destino> todosDestinos() throws ConexionFallidaException, SQLException{
		
		conexion = DataBaseConnector.getConnection();
		
		Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Destino");
        
        ArrayList<Destino> destinos = new ArrayList<Destino>();
        
        
        while ( rs.next() ) {
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            String ruta = rs.getString("imagen");
            String web = rs.getString("url");
            
            
            
            Destino destino = new Destino(nombre, descripcion, ruta, web);
            destinos.add(destino);
            
        }
        
        conexion.close();
		
		return destinos;
	}
	
	
	
	
	public static ArrayList<Museo> museosPorCiudad(String ciudad) throws SQLException, ConexionFallidaException{
		
		conexion = DataBaseConnector.getConnection();
		
		Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM museo WHERE ciudad = "+ciudad);
        
        ArrayList<Museo> museos = new ArrayList<Museo>();
        
        
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String nombre= rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            int precio = rs.getInt("precio");
            String horario = rs.getString("horario");
            String direccion = rs.getString("direccion");
            String url = rs.getString("url");
            String tipo = rs.getString("tipo");
      
            TipoMuseo tipoMuseo = null;
            
            switch(tipo) {
            
            case "HISTORIA":
            	tipoMuseo = TipoMuseo.HISTORIA;
            	break;
            	
            case "ARTE":
            	tipoMuseo = TipoMuseo.ARTE;
            	break;
            case "CIENCIA":
            	tipoMuseo = TipoMuseo.CIENCIA;
            	break;
            default:
            	tipoMuseo = TipoMuseo.OTROS;
            	break;
            }
            
            
            Museo museo = new Museo(nombre, id, descripcion, url, direccion, ciudad, horario, precio, tipoMuseo);
            museos.add(museo);
            
            
        }
        
        conexion.close();
		
		return museos;
		
		
	}
	
	
	
public static ArrayList<Hotel> hotelesPorCiudad(String ciudad) throws SQLException, ConexionFallidaException{
		
		conexion = DataBaseConnector.getConnection();
		
		Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM hotel WHERE ciudad = "+ciudad);
        
        ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
        
        
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String nombre= rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            int precio = rs.getInt("precio");
            String horario = rs.getString("horario");
            String direccion = rs.getString("direccion");
            String url = rs.getString("url");
            String tipo = rs.getString("tipo");
      
            
       
            
            Hotel hotel =null;
            //Hotel hotel = new Hotel(nombre, id, descripcion, url, direccion, ciudad, horario, precio);
           hoteles.add(hotel);
            
            
        }
        
        conexion.close();
		
		return hoteles;
		
		
	}
	
	
	
	
}
