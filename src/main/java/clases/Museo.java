package clases;

import enums.TipoMuseo;

public class Museo extends ServicioConPrecio {

	private TipoMuseo tipo;

	public Museo(String nombre, int id, String descripcion, String url, String direccion, String ciudad, String horario,
			int precio, TipoMuseo tipo) {
		super(nombre, id, descripcion, url, direccion, ciudad, horario, precio);
		this.tipo = tipo;
	}

	public TipoMuseo getTipo() {
		return tipo;
	}

	public void setTipo(TipoMuseo tipo) {
		this.tipo = tipo;
	}
	
}

	
