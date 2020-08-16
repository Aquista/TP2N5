package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaGroupChoice;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class VistaPreguntaGroupChoice extends VistaPregunta{
    private PreguntaGroupChoice pregunta;
    private Jugador jugador;
    private Panel panel;

    public VistaPreguntaGroupChoice(Jugador jugador, PreguntaGroupChoice unaPregunta, Panel panel){
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: rgb(69, 123, 229)");
        this.setSpacing(20);
        this.pregunta = unaPregunta;
        this.jugador = jugador;
        this.panel = panel;
        this.agregarInfo();
    }

    public void agregarInfo(){
        Label textoNombreJugador = new Label(this.jugador.nombre());
        textoNombreJugador.setStyle("-fx-font-size: 25px");

        Label textoPregunta = new Label(this.pregunta.texto());
        textoPregunta.setStyle("-fx-font-size: 25px");
        ArrayList<OpcionConGrupo> opciones = this.pregunta.opciones();
        ArrayList<ChoiceBox> choiceBoxes = new ArrayList<ChoiceBox>();
        GridPane contenedorOpciones = new GridPane();
        contenedorOpciones.setAlignment(Pos.CENTER);
        contenedorOpciones.setHgap(40);
        contenedorOpciones.setVgap(20);
        int columna=0;
        int fila=0;
        for (OpcionConGrupo unaOpcion:opciones){
            HBox contenedorOpcion = new HBox(10);
            Label textoOpcion = new Label(unaOpcion.texto());
            textoOpcion.setStyle("-fx-font-size: 18px");
            ChoiceBox opcionActual = new ChoiceBox(FXCollections.observableArrayList( 1, 2));
            opcionActual.setStyle("-fx-font-size: 14px");
            opcionActual.setUserData(unaOpcion);
            contenedorOpcion.getChildren().addAll(opcionActual,textoOpcion);
            choiceBoxes.add(opcionActual);
            contenedorOpciones.add(contenedorOpcion,columna,fila);
            columna++;
            if(columna==2){
                fila++;
                columna=0;
            }
        }
        Button enviarRespuesta = new Button("Enviar");
        enviarRespuesta.setStyle("-fx-font-size: 18px");
        enviarRespuesta.setOnAction(new AsignarRespuestaGroupChoiceEventHandler(jugador, pregunta, choiceBoxes, panel));
        this.getChildren().addAll(textoNombreJugador, textoPregunta, contenedorOpciones,enviarRespuesta);
    }
}