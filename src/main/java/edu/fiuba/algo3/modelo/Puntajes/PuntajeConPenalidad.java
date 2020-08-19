package edu.fiuba.algo3.modelo.Puntajes;


import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeConPenalidad extends Puntaje {

    @Override
    public int calcularPuntaje(Jugador unJugador, int cantidadRespCorrectasPregunta) {
        unJugador.evaluarRespuestas(this);
        puntos = cantidadCorrectas - cantidadIncorrectas;
        unJugador.aplicarMultiplicador(this);
        return puntos;
    }

    @Override
    public void asignarPuntaje(Jugador unJugador) {
        unJugador.actualizarPuntaje(puntos);
    }

    @Override
    public PuntajeConPenalidad duplicar() {
        return new PuntajeConPenalidad();
    }
}
