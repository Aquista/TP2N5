package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AsignarRespuestaVFEventHandler implements EventHandler<ActionEvent> {
    private Jugador jugador;
    private Pregunta pregunta;
    private Opcion opcionSeleccionada;

    public AsignarRespuestaVFEventHandler(Jugador jugador, Pregunta pregunta, Opcion seleccionada) {
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.opcionSeleccionada = seleccionada;
    }

    @Override
    public void handle(ActionEvent event) {
        jugador.responder(pregunta.tipo(), this.opcionSeleccionada);
    }
}
