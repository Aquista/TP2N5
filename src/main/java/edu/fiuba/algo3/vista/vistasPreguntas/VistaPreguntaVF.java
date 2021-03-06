package edu.fiuba.algo3.vista.vistasPreguntas;

import edu.fiuba.algo3.controlador.AsignarRespuestaVFEventHandler;
import edu.fiuba.algo3.controlador.Panel;
import edu.fiuba.algo3.controlador.Temporizador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collections;

public class VistaPreguntaVF extends VBox {

    private PreguntaVF pregunta;
    private Jugador jugador;
    private Panel panel;
    private int tiempo;

    public VistaPreguntaVF(Jugador jugador, PreguntaVF unaPregunta, Panel panel){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setStyle("-fx-background-color: hotpink");
        this.pregunta = unaPregunta;
        this.tiempo = unaPregunta.getTiempo();
        this.jugador = jugador;
        this.panel = panel;
        this.agregarInfo();
    }

    public void agregarInfo(){
        Label textoPregunta = new Label(this.pregunta.texto());
        textoPregunta.getStyleClass().add("texto-pregunta");

        HBox botones = new HBox(10);
        botones.setAlignment(Pos.CENTER);

        ArrayList<Opcion> opciones = new ArrayList<Opcion>(this.pregunta.opciones());
        Collections.shuffle(opciones);

        Label textoTiempo = new Label(String.valueOf(tiempo));
        Temporizador temporizador = new Temporizador(textoTiempo, tiempo);
        AsignarRespuestaVFEventHandler evento = new AsignarRespuestaVFEventHandler(jugador, pregunta, null, panel, temporizador);
        temporizador.setEvento(evento);
        temporizador.empezarTemporizador();

        textoTiempo.getStyleClass().add("temporizador");

        for (Opcion unaOpcion : opciones){
            Button opcionActual = new Button(unaOpcion.texto());
            opcionActual.getStyleClass().add("opcion-VF");
            AsignarRespuestaVFEventHandler eventoBoton = new AsignarRespuestaVFEventHandler(jugador, pregunta, unaOpcion, panel, temporizador);
            opcionActual.setOnAction(eventoBoton);
            botones.getChildren().add(opcionActual);
        }

        this.getChildren().addAll(textoTiempo, textoPregunta,botones);
    }
}