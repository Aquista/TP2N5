package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.AsignarRespuestaMultipleChoiceEventHandler;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class VistaPreguntaMultipleChoice extends VBox {
    private Pregunta pregunta;
    private Jugador jugador;

    public VistaPreguntaMultipleChoice(Jugador jugador, Pregunta unaPregunta){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.pregunta = unaPregunta;
        this.jugador = jugador;
        this.agregarInfo();
    }

    public void agregarInfo(){
        Label textoPregunta = new Label(this.pregunta.texto());
        textoPregunta.setStyle("-fx-font-size: 30px");

        VBox contenedorOpciones = new VBox(10);


        ArrayList<Opcion> opciones = this.pregunta.opciones();
        ArrayList<CheckBox> checkBoxes = new ArrayList<CheckBox>();

        for (Opcion unaOpcion : opciones){
            CheckBox opcionActual = new CheckBox(unaOpcion.texto());
            opcionActual.setUserData(unaOpcion);

            checkBoxes.add(opcionActual);
            contenedorOpciones.getChildren().add(opcionActual);
        }

        Button enviarRespuesta = new Button("Enviar");
        enviarRespuesta.setOnAction(new AsignarRespuestaMultipleChoiceEventHandler(jugador, pregunta, checkBoxes));
        contenedorOpciones.getChildren().add(enviarRespuesta);

        this.getChildren().addAll(textoPregunta, contenedorOpciones);
    }
}