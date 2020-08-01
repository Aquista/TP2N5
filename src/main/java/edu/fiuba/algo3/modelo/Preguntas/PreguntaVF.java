package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class PreguntaVF extends Pregunta{
    public PreguntaVF(String texto, Puntaje unPuntaje) {
        super(texto,unPuntaje);
    }

    @Override
    public void evaluarJugador(Jugador jugador ,Opcion ... opciones){
        Opcion elegida = opciones[0];
        Puntaje puntajeJugador = this.puntaje.nuevoPuntaje();
        elegida.evaluar(puntajeJugador);
        puntajeJugador.calcularPuntaje(jugador, this.totalCorrectas);
    }
    
}
