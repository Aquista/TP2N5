package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AsignarRespuestaVFEventHandler implements EventHandler<ActionEvent> {
    private Jugador jugador;
    private Pregunta pregunta;
    private Opcion seleccionada;
    private Panel panel;

    public AsignarRespuestaVFEventHandler(Jugador jugador, Pregunta pregunta, Opcion seleccionada, Panel panel) {
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.seleccionada = seleccionada;
        this.panel = panel;
    }

    @Override
    public void handle(ActionEvent event) {
        jugador.responder(pregunta.tipo(), seleccionada);
        AvanzarTurnoController.avanzarTurno(panel);
    }
}