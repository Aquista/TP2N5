package edu.fiuba.algo3.modelo.Jugadores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaOrderChoice;

public class JugadorDeOrderChoice extends JugadorDeTipo {
    @Override
    public void responder(Opcion... opciones) {
        this.respuesta = new RespuestaOrderChoice(opciones);
    }
}
