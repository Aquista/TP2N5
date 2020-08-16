package edu.fiuba.algo3.modelo.Modificadores;

import edu.fiuba.algo3.modelo.Modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class MultiplicadorX3 implements Multiplicador {

    @Override
    public void multiplicar(Puntaje puntaje) {
        puntaje.multiplicar(3);
    }

    @Override
    public String texto() {
        return "Multiplicador x3";
    }
}
