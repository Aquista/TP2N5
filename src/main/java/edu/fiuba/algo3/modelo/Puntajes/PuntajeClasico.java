package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeClasico extends Puntaje {

    private int puntos = 1;
    
    @Override
    public void calcularPuntaje(Jugador unJugador, int cantidadRespCorrectasPregunta) {
        if(cantidadCorrectas == cantidadRespCorrectasPregunta && cantidadIncorrectas == 0)
            unJugador.actualizarPuntaje(puntos);
    }

    @Override
    public Puntaje nuevoPuntaje() {
        return new PuntajeClasico();
    }
}