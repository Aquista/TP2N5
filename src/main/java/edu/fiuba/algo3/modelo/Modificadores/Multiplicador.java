package edu.fiuba.algo3.modelo.Modificadores;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public interface Multiplicador {
    void multiplicar(Puntaje puntaje);

    String texto();
}
