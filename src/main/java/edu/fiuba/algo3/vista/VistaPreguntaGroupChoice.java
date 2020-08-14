package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.controlador.Ronda;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaGroupChoice;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class VistaPreguntaGroupChoice extends VBox {
    private PreguntaGroupChoice pregunta;
    private Jugador jugador;
    private Ronda ronda;

    public VistaPreguntaGroupChoice(Jugador jugador, PreguntaGroupChoice unaPregunta, Ronda ronda){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.pregunta = unaPregunta;
        this.jugador = jugador;
        this.ronda = ronda;
        this.agregarInfo();
    }

    public void agregarInfo(){
        Label textoPregunta = new Label(this.pregunta.texto());
        textoPregunta.setStyle("-fx-font-size: 30px");

        VBox contenedorOpciones = new VBox(10);


        ArrayList<OpcionConGrupo> opciones = this.pregunta.opciones();
        ArrayList<ChoiceBox> choiceBoxes = new ArrayList<ChoiceBox>();

        for (OpcionConGrupo unaOpcion : opciones){
            HBox contenedorOpcion = new HBox(10);
            Label textoOpcion = new Label(unaOpcion.texto());
            ChoiceBox opcionActual = new ChoiceBox(FXCollections.observableArrayList( 1, 2));

            opcionActual.setUserData(unaOpcion);
            contenedorOpcion.getChildren().add(textoOpcion);
            contenedorOpcion.getChildren().add(opcionActual);

            choiceBoxes.add(opcionActual);
            contenedorOpciones.getChildren().add(contenedorOpcion);
        }

        Button enviarRespuesta = new Button("Enviar");
        enviarRespuesta.setOnAction(new AsignarRespuestaGroupChoiceEventHandler(jugador, pregunta, choiceBoxes, ronda));
        contenedorOpciones.getChildren().add(enviarRespuesta);

        this.getChildren().addAll(textoPregunta, contenedorOpciones);
    }
}