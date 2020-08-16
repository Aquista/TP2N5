package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.AsignarRespuestaOrderedChoiceEventHandler;
import edu.fiuba.algo3.controlador.Panel;
import edu.fiuba.algo3.controlador.SeleccionarOpcionConOrdenEventHandler;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionConOrden;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaOrderedChoice;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class VistaPreguntaOrderedChoice extends VistaPregunta {
    private PreguntaOrderedChoice pregunta;
    private Jugador jugador;
    private Panel panel;

    public VistaPreguntaOrderedChoice(Jugador jugador, PreguntaOrderedChoice unaPregunta, Panel panel){
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #FFA630");
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
        textoPregunta.setStyle("-fx-font-size: 30px");

        GridPane contenedorOpciones = new GridPane();
        contenedorOpciones.setAlignment(Pos.CENTER);
        contenedorOpciones.setHgap(40);
        contenedorOpciones.setVgap(20);
        int columna=0;
        int fila=0;

        ArrayList<OpcionConOrden> opcionesPregunta = this.pregunta.opciones();
        ArrayList<OpcionConOrden> opcionesSeleccionadas = new ArrayList<OpcionConOrden>();

        for (OpcionConOrden unaOpcion : opcionesPregunta){
            Button opcionActual = new Button(unaOpcion.texto());
            opcionActual.setStyle("-fx-font-size: 18px");
            SeleccionarOpcionConOrdenEventHandler eventoBoton = new SeleccionarOpcionConOrdenEventHandler(opcionesSeleccionadas, opcionActual, unaOpcion);
            opcionActual.setOnAction(eventoBoton);
            contenedorOpciones.add(opcionActual,columna,fila);
            columna++;
            if(columna==2){
                fila++;
                columna=0;
            }
        }

        Button enviarRespuesta = new Button("Enviar");
        enviarRespuesta.setStyle("-fx-font-size: 18px");
        enviarRespuesta.setOnAction(new AsignarRespuestaOrderedChoiceEventHandler(jugador, pregunta, opcionesSeleccionadas, panel));

        this.getChildren().addAll(textoNombreJugador, textoPregunta, contenedorOpciones,enviarRespuesta);
    }
}