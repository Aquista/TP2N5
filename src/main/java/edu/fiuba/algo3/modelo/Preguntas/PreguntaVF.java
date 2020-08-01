package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class PreguntaVF extends Pregunta{
    public PreguntaVF(String texto, Puntaje unPuntaje) {
        super(texto,unPuntaje);
    }
    
    @Override
    public void evaluarJugador(Jugador unJugador,Opcion unaOpcion){
       Puntaje puntajeJugador = this.puntaje.nuevoPuntaje();
       unaOpcion.evaluar(puntajeJugador);
       puntajeJugador.calcularPuntaje(unJugador, this.totalCorrectas);
    }
    
}
