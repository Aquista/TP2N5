package edu.fiuba.algo3.vista.vistasPreguntas;

import edu.fiuba.algo3.controlador.AsignarRespuestaMultipleChoiceEventHandler;
import edu.fiuba.algo3.controlador.Temporizador;
import edu.fiuba.algo3.controlador.Panel;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoice;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collections;

public class VistaPreguntaMultipleChoice extends VBox {
    private PreguntaMultipleChoice pregunta;
    private Jugador jugador;
    private Panel panel;
    int tiempo;

    public VistaPreguntaMultipleChoice(Jugador jugador, PreguntaMultipleChoice unaPregunta, Panel panel){
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: rgb(217, 208, 54)");
        this.setSpacing(20);
        this.pregunta = unaPregunta;
        this.tiempo = unaPregunta.getTiempo();
        this.jugador = jugador;
        this.panel = panel;
        this.agregarInfo();
    }

    public void agregarInfo(){
        Label textoPregunta = new Label(this.pregunta.texto());
        textoPregunta.getStyleClass().add("texto-pregunta");

        GridPane contenedorOpciones = new GridPane();
        contenedorOpciones.setAlignment(Pos.CENTER);
        contenedorOpciones.setHgap(40);
        contenedorOpciones.setVgap(20);
        int columna = 0;
        int fila = 0;

        ArrayList<Opcion> opciones = new ArrayList<Opcion>(this.pregunta.opciones());
        Collections.shuffle(opciones);
        ArrayList<CheckBox> checkBoxes = new ArrayList<CheckBox>();

        Label textoTiempo = new Label(String.valueOf(tiempo));
        Temporizador temporizador = new Temporizador(textoTiempo, tiempo);
        AsignarRespuestaMultipleChoiceEventHandler evento = new AsignarRespuestaMultipleChoiceEventHandler(jugador, pregunta, checkBoxes, panel, temporizador);
        temporizador.setEvento(evento);
        temporizador.empezarTemporizador();

        textoTiempo.getStyleClass().add("temporizador");

        for (Opcion unaOpcion : opciones){
            CheckBox opcionActual = new CheckBox(unaOpcion.texto());
            opcionActual.setStyle("-fx-font-size: 18px");
            opcionActual.setUserData(unaOpcion);
            checkBoxes.add(opcionActual);
            contenedorOpciones.add(opcionActual,columna,fila);
            columna++;
            if(columna == 2){
                fila++;
                columna = 0;
            }
        }

        Button enviarRespuesta = new Button("Enviar");
        enviarRespuesta.setStyle("-fx-font-size: 18px");
        enviarRespuesta.setOnAction(new AsignarRespuestaMultipleChoiceEventHandler(jugador, pregunta, checkBoxes, panel, temporizador));





        this.getChildren().addAll(textoTiempo,textoPregunta, contenedorOpciones,enviarRespuesta);
    }
}