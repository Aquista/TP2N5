package edu.fiuba.algo3.modelo.Modificadores;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

import java.util.ArrayList;

public class ExclusividadSimple implements Exclusividad {

    @Override
    public void aplicar(Puntaje puntaje1, Puntaje puntaje2) {
        ArrayList<Puntaje> correctos = new ArrayList<Puntaje>();
        puntaje1.esExclusivo(correctos);
        puntaje2.esExclusivo(correctos);

        if(correctos.size() == 1)
            correctos.get(0).multiplicar(2);
    }

    @Override
    public String texto() {
        return "Exclusividad";
    }
}