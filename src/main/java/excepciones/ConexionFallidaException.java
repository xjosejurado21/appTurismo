package excepciones;

public class ConexionFallidaException extends Exception {

    // Constructor sin parámetros
    public ConexionFallidaException() {
        super("Fallo en la conexión con la base de datos");
    }

    // Constructor con mensaje personalizado
    public ConexionFallidaException(String mensaje) {
        super(mensaje);
    }
}
	
