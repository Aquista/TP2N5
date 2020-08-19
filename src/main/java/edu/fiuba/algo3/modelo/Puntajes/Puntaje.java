package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;

import java.util.ArrayList;

public abstract class Puntaje {

    protected int puntos = 0;
    protected int cantidadCorrectas = 0;
    protected int cantidadIncorrectas = 0;

    public abstract int calcularPuntaje(Jugador unJugador, int cantidadRespCorrectasPregunta);

    public void asignarPuntaje(Jugador unJugador) {
        unJugador.actualizarPuntaje(puntos);
    }

    public abstract Puntaje duplicar();

    public void sumarCorrecta() {
        cantidadCorrectas += 1;
    }

    public void sumarIncorrecta() {
        cantidadIncorrectas += 1;
    }
    
    public void multiplicar(int multiplicador) {
        puntos = puntos * multiplicador;
    }

    public void aplicarExclusividad(ArrayList<Puntaje> correctos) {
        if(puntos > 0)
            correctos.add(this);
    }
}
