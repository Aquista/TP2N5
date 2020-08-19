package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
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
    private Temporizador temporizador;

    public AsignarRespuestaOrderedChoiceEventHandler(Jugador jugador, Pregunta pregunta, ArrayList<OpcionConOrden> opcionesSeleccionadas, Panel panel, Temporizador temporizador) {
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.opcionesSeleccionadas = opcionesSeleccionadas;
        this.panel = panel;
        this.temporizador = temporizador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugador.responder(pregunta.tipo(), opcionesSeleccionadas.toArray(new OpcionConOrden[opcionesSeleccionadas.size()]));
        temporizador.apagarTemporizador();
        AvanzarTurnoController.avanzarTurno(panel);
    }
}
