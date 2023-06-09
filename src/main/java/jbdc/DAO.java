package jbdc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.CentroComercial;
import clases.Destino;
import clases.Evento;
import clases.Hotel;
import clases.Museo;
import clases.Restaurante;
import clases.Servicio;
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
	
	
	
	
	public static ArrayList<Servicio> museosPorCiudad(String ciudad) throws SQLException, ConexionFallidaException{
		
		conexion = DataBaseConnector.getConnection();
		
		Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM museo WHERE ciudad = '"+ciudad+"'");
        
        ArrayList<Servicio> museos = new ArrayList<Servicio>();
        
        
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
	
	
	
	/*POR REVISAR*/
	
	/*public static ArrayList<Hotel> hotelesPorCiudad(String ciudad) throws SQLException, ConexionFallidaException{
		
		conexion = DataBaseConnector.getConnection();
		
		Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM hotel WHERE ciudad = '"+ciudad+"'");
        
        ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
        
        
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String nombre= rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            String horario = rs.getString("horario");
            String direccion = rs.getString("direccion");
            String url = rs.getString("url");
            int num_tiendas = rs.getInt("num_tiendas");
            int num_pisos = rs.getInt("num_pisos");
       
            
            Hotel hotel =null;
            //Hotel hotel = new Hotel(nombre, id, descripcion, url, direccion, ciudad, horario, precio);
           hoteles.add(hotel);
            
            
        }
        
        conexion.close();
		
		return hoteles;
		
		
	}*/
	
	
	
	public static ArrayList<Servicio> centroComercialPorCiudad(String ciudad) throws SQLException, ConexionFallidaException{
		
		conexion = DataBaseConnector.getConnection();
		
		Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM centro_comercial WHERE ciudad = '"+ciudad+"'");
        
        ArrayList<Servicio> centrosComerciales = new ArrayList<Servicio>();
        
        
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String nombre= rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            String horario = rs.getString("horario");
            String direccion = rs.getString("direccion");
            String url = rs.getString("url");
            int numTiendas = rs.getInt("num_tiendas");
            int numPisos = rs.getInt("num_pisos");
       
            
            CentroComercial centro = new CentroComercial(
            		nombre, id, descripcion, url, direccion, ciudad, horario, numTiendas, numPisos
            		);
            
            //Hotel hotel = new Hotel(nombre, id, descripcion, url, direccion, ciudad, horario, precio);
           centrosComerciales.add(centro);
            
            
        }
        
        conexion.close();
		
		return centrosComerciales;
		
		
	}
	
	
public static ArrayList<Servicio> restaurantePorCiudad(String ciudad) throws SQLException, ConexionFallidaException{
		
		conexion = DataBaseConnector.getConnection();
		
		Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM restaurante WHERE ciudad = '"+ciudad+"'");
        
        ArrayList<Servicio> restaurantes = new ArrayList<Servicio>();
        
        
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String nombre= rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            String horario = rs.getString("horario");
            String direccion = rs.getString("direccion");
            int rangoPrecio= rs.getInt("rango_precio");
            String url = rs.getString("url");
            
   
            Restaurante restaurante= new Restaurante(nombre, id, descripcion, url, direccion, ciudad, horario,rangoPrecio);
            
            //Hotel hotel = new Hotel(nombre, id, descripcion, url, direccion, ciudad, horario, precio);
           restaurantes.add(restaurante);
        }
        
        conexion.close();
		
		return restaurantes;
		
	
	}

public static ArrayList<Servicio> eventoPorCiudad(String ciudad) throws SQLException, ConexionFallidaException{
	
	conexion = DataBaseConnector.getConnection();
	
	Statement stmt = conexion.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM evento WHERE ciudad = '"+ciudad+"'");
    
    ArrayList<Servicio> eventos = new ArrayList<Servicio>();
    

    
    while ( rs.next() ) {
        int id = rs.getInt("id");
        String nombre= rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        String fecha= rs.getString("fecha");
        int precio = rs.getInt("precio");
        String hora = rs.getString("hora");
        String direccion = rs.getString("direccion");
        String url = rs.getString("url");
        String artista=rs.getString("artista");
       
  
    
        
        
        
        
        Evento evento= new Evento(nombre, id, descripcion, url, direccion, ciudad, hora,1,artista,ciudad);
        eventos.add(evento);
        
        
    }
    
    conexion.close();
	
	return eventos;
	
	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
