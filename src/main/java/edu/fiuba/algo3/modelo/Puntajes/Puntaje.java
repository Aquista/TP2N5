package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Jugador;

public abstract class Puntaje {
    protected int puntos = 0;
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