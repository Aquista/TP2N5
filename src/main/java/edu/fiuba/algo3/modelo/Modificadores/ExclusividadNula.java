package edu.fiuba.algo3.modelo.Modificadores;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class ExclusividadNula implements Exclusividad {

    @Override
    public void aplicar(Puntaje puntaje1, Puntaje puntaje2) {

    }

    @Override
    public String texto() {
        return "Exclusividad nula";
    }
}
