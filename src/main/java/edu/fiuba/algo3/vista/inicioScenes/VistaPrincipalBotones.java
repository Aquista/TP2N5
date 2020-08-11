package edu.fiuba.algo3.vista.inicioScenes;

import edu.fiuba.algo3.controlador.BotonAgregarJugador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaPrincipalBotones extends VBox {
    public VistaPrincipalBotones(Stage unStage){
        TextField nombreJugador=new TextField();
        nombreJugador.setPromptText("Ingrese su Nombre");
        nombreJugador.setStyle("-fx-font-size: 16px");
        Button agregarJugador=new Button();
        BotonAgregarJugador accionAgregarJugador = new BotonAgregarJugador(unStage,nombreJugador);
        agregarJugador.setOnAction(accionAgregarJugador);
        agregarJugador.setText("Enter");
        agregarJugador.setStyle("-fx-font-size: 16px;-fx-background-color: rgb(51, 51, 51);-fx-text-fill:white;-fx-font-family: 'Cooper Black'");
        agregarJugador.setMaxWidth(220);
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);
        this.setMaxWidth(220);
        this.getChildren().addAll(nombreJugador,agregarJugador);
    }
}
