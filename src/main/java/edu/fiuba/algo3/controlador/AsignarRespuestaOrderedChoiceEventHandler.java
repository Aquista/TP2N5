package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionConOrden;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class AsignarRespuestaOrderedChoiceEventHandler implements EventHandler<ActionEvent> {
    private Jugador jugador;
    private Pregunta pregunta;
    private ArrayList<OpcionConOrden> opcionesSeleccionadas;
    private Panel panel;


    public AsignarRespuestaOrderedChoiceEventHandler(Jugador jugador, Pregunta pregunta, ArrayList<OpcionConOrden> opcionesSeleccionadas, Panel panel) {
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.opcionesSeleccionadas = opcionesSeleccionadas;
        this.panel = panel;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugador.responder(pregunta.tipo(), opcionesSeleccionadas.toArray(new OpcionConOrden[opcionesSeleccionadas.size()]));
        AvanzarTurnoController.avanzarTurno(panel);
    }
}
