package excepciones;

public class ServicioYaPresenteException extends Exception{
	
	public ServicioYaPresenteException() {
        super("El servicio ya está presente en el archivo");
    }

}
