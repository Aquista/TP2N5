package edu.fiuba.algo3.vista.inicioScenes;

import edu.fiuba.algo3.Controladores.AgregarJugadorEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaCreacionJugador extends VBox {

    public VistaCreacionJugador(Stage stage){
        Image logo = new Image("file:src/main/java/edu/fiuba/algo3/vista/otros/logo.png");
        ImageView logoView = new ImageView(logo);
        logoView.setFitHeight(140);
        logoView.setFitWidth(240);

        TextField nombreJugador = new TextField();
        nombreJugador.setPromptText("Ingrese su Nombre");
        nombreJugador.setStyle("-fx-font-size: 16px");

        Button agregarJugador = new Button();
        AgregarJugadorEventHandler accionAgregarJugador = new AgregarJugadorEventHandler(unStage, nombreJugador, panel);
        agregarJugador.setOnAction(accionAgregarJugador);
        agregarJugador.setText("Enter");
        agregarJugador.setStyle("-fx-font-size: 16px;-fx-background-color: rgb(51, 51, 51);-fx-text-fill:white;-fx-font-family: 'Cooper Black'");
        agregarJugador.setMaxWidth(220);

        this.getChildren().addAll(nombreJugador,agregarJugador);

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setStyle("-fx-background-color:rgb(140, 199, 63)");
        this.getChildren().addAll(logoView);
    }


}
