package edu.fiuba.algo3.modelo.Puntajes;


import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeConPenalidad extends Puntaje {

    @Override
    public void calcularPuntaje(Jugador unJugador, int cantidadRespCorrectasPregunta) {
        unJugador.evaluarRespuestas(this);
        puntos = cantidadCorrectas - cantidadIncorrectas;
        unJugador.aplicarMultiplicador(this);
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
