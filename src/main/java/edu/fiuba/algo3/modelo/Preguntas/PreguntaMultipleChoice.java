package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class PreguntaMultipleChoice extends Pregunta {
    
    public PreguntaMultipleChoice(String texto, Puntaje unPuntaje) {
        super(texto,unPuntaje);
    }
    
    @Override
    public void evaluarJugador(Jugador jugador,int unMulti ,Opcion ... elegidas) {
        Puntaje puntajeJugador = this.puntaje.nuevoPuntaje(unMulti);
        for (Opcion unaOpcion:elegidas){
            unaOpcion.evaluar(puntajeJugador);
        }
        puntajeJugador.calcularPuntaje(jugador,this.totalCorrectas);
    }

    private void evaluarJugador(Jugador unJugador){
        unJugador.evaluarRespuestas(this.puntaje.nuevoPuntaje(1), this.totalCorrectas);
    }

    @Override
    public void evaluarJugadores(Jugador primerJugador, Jugador segundoJugador){
        evaluarJugador(primerJugador);
        evaluarJugador(segundoJugador);
    }
    
}
