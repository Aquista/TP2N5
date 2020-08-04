package edu.fiuba.algo3.modelo.Modificadores;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class MultiplicadorX2 implements Multiplicador {

    @Override
    public void multiplicar(Puntaje puntaje) {
        puntaje.multiplicar(2);
    }
}
