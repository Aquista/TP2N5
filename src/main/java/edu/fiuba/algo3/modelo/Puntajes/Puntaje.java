package edu.fiuba.algo3.modelo.Puntajes;

public abstract class Puntaje {

    protected int cantidadCorrectas = 0;
    protected int cantidadIncorrectas = 0;
    
    public void sumarCorrecta() {
        cantidadCorrectas += 1;
    }

    public void sumarIncorrecta() {
        cantidadIncorrectas += 1;
    }

    public int getRespuestasCorrectas() {
        return cantidadCorrectas;
    }

    public int getRespuestasIncorrectas() {
        return cantidadIncorrectas;
    }
}
