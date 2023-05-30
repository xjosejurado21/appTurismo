package clases;

public class ServicioConHorario extends Servicio{
	

	private String horario;

	public ServicioConHorario(String nombre, int id, String descripcion, String url, String direccion, String ciudad,
			String horario) {
		super(nombre, id, descripcion, url, direccion, ciudad);
		this.horario = horario;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	
	
	
	
}
