package clases;
public class hotel extends elementoConNombre {
    private int estrellas;

    public hotel(String nombre, int estrellas) {
        super(nombre);
        this.estrellas = estrellas;
    }

    // Getters and setters

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }
}

	
