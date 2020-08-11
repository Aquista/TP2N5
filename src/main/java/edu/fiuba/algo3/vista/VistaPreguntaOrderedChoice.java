package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Controladores.AsignarRespuestaMultipleChoiceEventHandler;
import edu.fiuba.algo3.Controladores.AsignarRespuestaOrderedChoiceEventHandler;
import edu.fiuba.algo3.Controladores.AsignarRespuestaVFEventHandler;
import edu.fiuba.algo3.Controladores.SeleccionarOpcionConOrdenEventHandler;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionConOrden;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaOrderedChoice;
import javafx.collections.FXCollections;
import javafx.collections.ModifiableObservableListBase;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class VistaPreguntaOrderedChoice extends VBox {
    private PreguntaOrderedChoice pregunta;
    private Jugador jugador;

    public VistaPreguntaOrderedChoice(Jugador jugador, PreguntaOrderedChoice unaPregunta){
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

        ArrayList<OpcionConOrden> opcionesPregunta = this.pregunta.opciones();
        ArrayList<OpcionConOrden> opcionesSeleccionadas = new ArrayList<OpcionConOrden>();

        for (OpcionConOrden unaOpcion : opcionesPregunta){
            Button opcionActual = new Button(unaOpcion.texto());
            SeleccionarOpcionConOrdenEventHandler eventoBoton = new SeleccionarOpcionConOrdenEventHandler(opcionesSeleccionadas, opcionActual, unaOpcion);

            opcionActual.setOnAction(eventoBoton);
            contenedorOpciones.getChildren().add(opcionActual);
        }

        Button enviarRespuesta = new Button("Enviar");
        enviarRespuesta.setOnAction(new AsignarRespuestaOrderedChoiceEventHandler(jugador, pregunta, opcionesSeleccionadas));
        contenedorOpciones.getChildren().add(enviarRespuesta);

        this.getChildren().addAll(textoPregunta, contenedorOpciones);
    }
}