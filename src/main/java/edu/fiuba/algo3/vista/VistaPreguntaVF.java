package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Controladores.AsignarRespuestaVFEventHandler;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Panel.Panel;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class VistaPreguntaVF extends VBox{
    private PreguntaVF pregunta;
    private Jugador jugador;
    private VistaPanel vPanel;
    private Panel panel;

    public VistaPreguntaVF(Jugador jugador, PreguntaVF unaPregunta, VistaPanel vPanel,Panel panel){
        this.setStyle("-fx-background-color: #a146f1;");
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.vPanel=vPanel;
        this.pregunta = unaPregunta;
        this.jugador = jugador;
        this.panel=panel;
        this.agregarInfo();
    }

    public void agregarInfo(){
        Label textoPregunta = new Label(this.pregunta.texto());
        textoPregunta.setStyle("-fx-font-size: 35px");

        HBox botones = new HBox(10);
        botones.setAlignment(Pos.CENTER);

        ArrayList<Opcion> opciones = this.pregunta.opciones();

        for (Opcion unaOpcion : opciones){
            VistaOpcion opcion = new VistaOpcion(unaOpcion,this.pregunta,this.jugador,this.vPanel,this.panel);
            botones.getChildren().add(opcion);
        }

        this.getChildren().addAll(textoPregunta,botones);
    }
}
