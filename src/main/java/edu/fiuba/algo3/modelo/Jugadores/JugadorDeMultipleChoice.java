package edu.fiuba.algo3.modelo.Jugadores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaMultipleChoice;

public class JugadorDeMultipleChoice extends JugadorDeTipo {
    @Override
    public void responder(Opcion... opciones) {
        this.respuesta = new RespuestaMultipleChoice(opciones);
    }
}
