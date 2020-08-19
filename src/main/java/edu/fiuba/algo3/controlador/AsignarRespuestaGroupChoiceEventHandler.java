package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaGroupChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;

public class AsignarRespuestaGroupChoiceEventHandler implements EventHandler<ActionEvent> {
    private Jugador jugador;
    private PreguntaGroupChoice pregunta;
    private ArrayList<ChoiceBox> choiceBoxes;
    private Panel panel;
    private Temporizador temporizador;

    public AsignarRespuestaGroupChoiceEventHandler(Jugador jugador, PreguntaGroupChoice pregunta, ArrayList<ChoiceBox> choiceBoxes, Panel panel, Temporizador temporizador) {
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.choiceBoxes = choiceBoxes;
        this.panel = panel;
        this.temporizador = temporizador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<OpcionConGrupo> seleccionadas = new ArrayList<OpcionConGrupo>();

        for(ChoiceBox choiceBox : choiceBoxes) {
            if(choiceBox.getValue() != null){
                OpcionConGrupo opcionSeleccionada = ((OpcionConGrupo)choiceBox.getUserData()).duplicar((int)choiceBox.getValue());
                seleccionadas.add(opcionSeleccionada);
            }
        }
        jugador.responder(pregunta.tipo(), seleccionadas.toArray(new Opcion[seleccionadas.size()]));
        temporizador.apagarTemporizador();
        AvanzarTurnoController.avanzarTurno(panel);
    }
}
