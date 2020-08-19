package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AsignarRespuestaVFEventHandler implements EventHandler<ActionEvent> {
    private Jugador jugador;
    private Pregunta pregunta;
    private Opcion seleccionada;
    private Panel panel;
    private Temporizador temporizador;

    public AsignarRespuestaVFEventHandler(Jugador jugador, Pregunta pregunta, Opcion seleccionada, Panel panel, Temporizador temporizador) {
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.seleccionada = seleccionada;
        this.panel = panel;
        this.temporizador = temporizador;
    }

    @Override
    public void handle(ActionEvent event) {
        if(seleccionada != null)
            jugador.responder(pregunta.tipo(), seleccionada);
        else
            jugador.responder(pregunta.tipo(), new OpcionIncorrecta("provisorio"));

        temporizador.apagarTemporizador();
        AvanzarTurnoController.avanzarTurno(panel);
    }
}