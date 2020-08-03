package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class PreguntaVF extends Pregunta{
    public PreguntaVF(String texto, Puntaje unPuntaje) {
        super(texto,unPuntaje);
    }

    private Puntaje evaluarJugador(Jugador unJugador){
        Puntaje unPuntaje = this.puntaje.nuevoPuntaje(1);
        unJugador.evaluarRespuestas(unPuntaje, this.totalCorrectas);
        return unPuntaje;

    }

    @Override
    public void evaluarJugadores(Jugador primerJugador, Jugador segundoJugador){
        Puntaje puntaje1 = evaluarJugador(primerJugador);
        Puntaje puntaje2 = evaluarJugador(segundoJugador);
        primerJugador.actualizarPuntaje(puntaje1.getPuntos());
        segundoJugador.actualizarPuntaje(puntaje2.getPuntos());
    }


}
