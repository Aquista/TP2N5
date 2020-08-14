package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.AsignarRespuestaOrderedChoiceEventHandler;
import edu.fiuba.algo3.controlador.SeleccionarOpcionConOrdenEventHandler;
import edu.fiuba.algo3.controlador.Ronda;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionConOrden;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaOrderedChoice;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class VistaPreguntaOrderedChoice extends VBox {
    private PreguntaOrderedChoice pregunta;
    private Jugador jugador;
    private Ronda ronda;

    public VistaPreguntaOrderedChoice(Jugador jugador, PreguntaOrderedChoice unaPregunta, Ronda ronda){
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

        ArrayList<OpcionConOrden> opcionesPregunta = this.pregunta.opciones();
        ArrayList<OpcionConOrden> opcionesSeleccionadas = new ArrayList<OpcionConOrden>();

        for (OpcionConOrden unaOpcion : opcionesPregunta){
            Button opcionActual = new Button(unaOpcion.texto());
            SeleccionarOpcionConOrdenEventHandler eventoBoton = new SeleccionarOpcionConOrdenEventHandler(opcionesSeleccionadas, opcionActual, unaOpcion);

            opcionActual.setOnAction(eventoBoton);
            contenedorOpciones.getChildren().add(opcionActual);
        }

        Button enviarRespuesta = new Button("Enviar");
        enviarRespuesta.setOnAction(new AsignarRespuestaOrderedChoiceEventHandler(jugador, pregunta, opcionesSeleccionadas, ronda));
        contenedorOpciones.getChildren().add(enviarRespuesta);

        this.getChildren().addAll(textoPregunta, contenedorOpciones);
    }
}