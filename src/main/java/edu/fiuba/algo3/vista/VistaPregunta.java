package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class VistaPregunta extends VBox{
    private Pregunta pregunta;
    public VistaPregunta(Pregunta unaPregunta){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.pregunta=unaPregunta;
        this.agregarInfo();
    }
    public void agregarInfo(){
        Label textoPregunta=new Label(this.pregunta.texto());
        textoPregunta.setStyle("-fx-font-size: 35px");
        HBox botones= new HBox(10);
        botones.setAlignment(Pos.CENTER);
        ArrayList<Opcion> opciones = this.pregunta.opciones();
        for (Opcion unaOpcion:opciones){
            botones.getChildren().add(new VistaOpcion (unaOpcion.texto()));
        }
        this.getChildren().addAll(textoPregunta,botones);
    }
}
