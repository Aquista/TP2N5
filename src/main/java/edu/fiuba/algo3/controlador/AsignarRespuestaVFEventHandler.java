package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class AsignarRespuestaVFEventHandler implements EventHandler<ActionEvent> {
    private Jugador jugador;
    private Pregunta pregunta;
    private Opcion seleccionada;

    public AsignarRespuestaVFEventHandler(Jugador jugador, Pregunta pregunta, Opcion seleccionada) {
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.seleccionada = seleccionada;
    }

    @Override
    public void handle(ActionEvent event) {
        jugador.responder(pregunta.tipo(), seleccionada);
    }
}
