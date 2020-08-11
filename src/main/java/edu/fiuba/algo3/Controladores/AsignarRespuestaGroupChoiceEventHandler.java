package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaGroupChoice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;

public class AsignarRespuestaGroupChoiceEventHandler implements EventHandler<ActionEvent> {
    Jugador jugador;
    PreguntaGroupChoice pregunta;
    ArrayList<ChoiceBox> choiceBoxes;


    public AsignarRespuestaGroupChoiceEventHandler(Jugador jugador, PreguntaGroupChoice pregunta, ArrayList<ChoiceBox> choiceBoxes) {
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.choiceBoxes = choiceBoxes;
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
    }
}
