package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.Ronda;
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
    private Ronda ronda;

    public AsignarRespuestaVFEventHandler(Jugador jugador, Pregunta pregunta, Opcion seleccionada, Ronda ronda) {
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.seleccionada = seleccionada;
        this.ronda = ronda;
    }

    @Override
    public void handle(ActionEvent event) {
        jugador.responder(pregunta.tipo(), seleccionada);
        ronda.avanzarTurno();
    }
}