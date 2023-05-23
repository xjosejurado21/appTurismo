package clases;

import java.util.ArrayList;
import java.util.List;

public class viaje {
	 private usuario usuario;
	 private List<servicio> servicios;

	 public viaje(usuario usuario) {
	     this.usuario = usuario;
	     this.servicios = new ArrayList<servicio>();
	 }

	 public void agregarServicio(servicio servicio) {
	     servicios.add(servicio);
	 }

	 // Otros métodos y propiedades de Viaje
	}
