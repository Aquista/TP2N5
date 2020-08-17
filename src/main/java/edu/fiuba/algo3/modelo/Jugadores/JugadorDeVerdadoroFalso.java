package edu.fiuba.algo3.modelo.Jugadores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;

public class JugadorDeVerdadoroFalso extends JugadorDeTipo {
    @Override
    public void responder(Opcion... opciones) {
        this.respuesta =  new RespuestaVF(opciones[0]);
    }
}
