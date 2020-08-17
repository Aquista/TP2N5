package edu.fiuba.algo3.modelo.Jugadores;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaGroupChoice;

public class JugadorDeGroupChoice extends JugadorDeTipo {
    public void responder(Opcion... opciones) {
        this.respuesta = new RespuestaGroupChoice(opciones);
    }
}
