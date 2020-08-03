package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaPregunta extends VBox{
    private Pregunta pregunta;
    public VistaPregunta(){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.pregunta=null;
        this.agregarInfo();
    }
    public void agregarInfo(){
        Label textoPregunta=new Label("El patron Poxi existe?");
        textoPregunta.setStyle("-fx-font-size: 35px");
        HBox botones= new HBox(10);
        botones.setAlignment(Pos.CENTER);
        botones.getChildren().addAll(new Button("True"),new Button("False"));
        this.getChildren().addAll(textoPregunta,botones);
    }
}
