package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionConOrden;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class AsignarRespuestaOrderedChoiceEventHandler implements EventHandler<ActionEvent> {
    Jugador jugador;
    Pregunta pregunta;
    ArrayList<OpcionConOrden> opcionesSeleccionadas;

    public AsignarRespuestaOrderedChoiceEventHandler(Jugador jugador, Pregunta pregunta, ArrayList<OpcionConOrden> opcionesSeleccionadas) {
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.opcionesSeleccionadas = opcionesSeleccionadas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugador.responder(pregunta.tipo(), opcionesSeleccionadas.toArray(new OpcionConOrden[opcionesSeleccionadas.size()]));
    }
}
