package pantallass;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;

import clases.Destino;
import clases.Servicio;
import clases.Usuario;
import main.PantallaInicio;
import main.Principal;

public class Ventana extends JFrame{
	
	
	private PantallaInicio pantallaInicio;
	private PantallaSeleccionDestino pantallaSeleccionDestino;
	private PantallaServicios pantallaServicios;
	private PantallaDetalle pantallaDetalle;
	private Usuario usuario;
	private Destino destinoSeleccionado;
	

	




	public Ventana() {
		
		setBackground(Color.WHITE);
		/*setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\panch\\Documents\\PROGRAMACI\u00D3N\\MauroPernas-WarInCenec\\imagenes\\blood-icon.png"));*/
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
		setTitle("AppTurismo");
		
		setVisible(true);
		//this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.pantallaInicio = new PantallaInicio(this);
		this.setContentPane(this.pantallaInicio);

		this.setVisible(true);
	}
	
	
	
	
	/**
	 * Función para viajar de una pantalla a otra. Carga una nueva pantalla y mata la anterior.
	 */
	public void irAPantallaSeleccionDestino() {

		//Crea nueva pantalla
		if (this.pantallaSeleccionDestino == null) {
			this.pantallaSeleccionDestino = new PantallaSeleccionDestino(this);

		}
		
		
		
		//Elimina pantallas anteriores
		if(this.pantallaInicio!=null) {
			this.pantallaInicio.setVisible(false);
			this.pantallaInicio = null;
		}
		
		if(this.pantallaServicios!=null) {
			this.pantallaServicios.setVisible(false);
			this.pantallaServicios = null;
		}
		
		
		this.setContentPane(pantallaSeleccionDestino);
		this.pantallaSeleccionDestino.setVisible(true);
	}
	
	
	
	public void irAPantallaServicios() {

		//Crea nueva pantalla
		if (this.pantallaServicios == null) {
			this.pantallaServicios = new PantallaServicios(this);

		}
		
		
		
		//Elimina pantallas anteriores
		if(this.pantallaSeleccionDestino!=null) {
			this.pantallaSeleccionDestino.setVisible(false);
			this.pantallaSeleccionDestino = null;
		}
		
		if(this.pantallaDetalle!=null) {
			this.pantallaDetalle.setVisible(false);
			this.pantallaDetalle = null;
		}
		
		
		this.setContentPane(pantallaServicios);
		this.pantallaServicios.setVisible(true);
	}
	

	public void irAPantallaDetalle(Servicio servicio) {

		//Crea nueva pantalla
		if (this.pantallaDetalle == null) {
			this.pantallaDetalle = new PantallaDetalle(this, servicio);

		}
		
		
		
		//Elimina pantallas anteriores
		if(this.pantallaServicios!=null) {
			this.pantallaServicios.setVisible(false);
			this.pantallaServicios = null;
		}
		
		
		this.setContentPane(pantallaDetalle);
		this.pantallaDetalle.setVisible(true);
	}

	



	
	/*
	 * public void irAPantallaInicio() {

		if (this.pantallaInicio == null) {
			this.pantallaInicio = new PantallaInicio(this);

		}
		

		if (this.pantallaSeleccionPersonaje != null) {
			this.pantallaSeleccionPersonaje=null;
		}
		
		
		this.setContentPane(pantallaInicio);
		this.pantallaInicio.setVisible(true);
	}
	 * 
	 * */
	
	
	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	public Destino getDestinoSeleccionado() {
		return destinoSeleccionado;
	}




	public void setDestinoSeleccionado(Destino destinoSeleccionado) {
		this.destinoSeleccionado = destinoSeleccionado;
	}
	
}
