package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;

public class AsignarRespuestaMultipleChoiceEventHandler implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private Pregunta pregunta;
    private ArrayList<CheckBox> checkBoxes;
    private Panel panel;
    private Temporizador temporizador;

    public AsignarRespuestaMultipleChoiceEventHandler(Jugador jugador, Pregunta pregunta, ArrayList<CheckBox> checkBoxes, Panel panel, Temporizador temporizador) {
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.checkBoxes = checkBoxes;
        this.panel = panel;
        this.temporizador = temporizador;
    }

    @Override
    public void handle(ActionEvent event) {
        ArrayList<Opcion> seleccionadas = new ArrayList<Opcion>();
        for(CheckBox checkBox : checkBoxes) {
            if(checkBox.isSelected())
            {
                seleccionadas.add((Opcion)checkBox.getUserData());
            }
        }
        jugador.responder(pregunta.tipo(), seleccionadas.toArray(new Opcion[seleccionadas.size()]));
        temporizador.apagarTemporizador();
        AvanzarTurnoController.avanzarTurno(panel);
    }
}
