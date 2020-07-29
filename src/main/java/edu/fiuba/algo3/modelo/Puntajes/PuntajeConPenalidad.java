package edu.fiuba.algo3.modelo;


public class PuntajeConPenalidad extends IPuntaje{
    
    @Override
    public void calcularPuntaje(Jugador unJugador) {
        unJugador.evaluarRespuestas(this);
        unJugador.actualizarPuntaje(this.cantidadCorrectas-this.cantidadIncorrectas);
    }
 
}
