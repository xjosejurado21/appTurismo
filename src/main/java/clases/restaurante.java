package clases;

public class restaurante extends elementoConNombre {
    private String tipoComida;
    private int mesas;

    public restaurante(String nombre, String tipoComida, int mesas) {
        super(nombre);
        this.tipoComida = tipoComida;
        this.mesas = mesas;
    }

    // Getters and setters

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public int getMesas() {
        return mesas;
    }

    public void setMesas(int mesas) {
        this.mesas = mesas;
    }
}

