package clases;

public class ServicioConHorario extends ElementoConNombre{
	private String horario;

	public ServicioConHorario(String nombre, String horario) {
		super(nombre);
		this.horario = horario;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
