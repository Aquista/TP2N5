package edu.fiuba.algo3.vista.inicioScenes;

import edu.fiuba.algo3.Controladores.AgregarJugadoresEventHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class VistaCreacionJugadores extends VBox {

    public VistaCreacionJugadores(Kahoot kahoot){
        Image logo = new Image("file:src/main/java/edu/fiuba/algo3/vista/otros/logo.png");
        ImageView logoView = new ImageView(logo);
        logoView.setFitHeight(140);
        logoView.setFitWidth(240);

        TextField nombreJugador1 = new TextField();
        TextField nombreJugador2 = new TextField();

        nombreJugador1.setPromptText("Ingrese su Nombre");
        nombreJugador1.setStyle("-fx-font-size: 16px");
        nombreJugador2.setPromptText("Ingrese su Nombre");
        nombreJugador2.setStyle("-fx-font-size: 16px");

        Button agregarJugadores = new Button();
        agregarJugadores.setOnAction(new AgregarJugadoresEventHandler(nombreJugador1, nombreJugador2, kahoot));
        agregarJugadores.setText("Enter");
        agregarJugadores.setStyle("-fx-font-size: 16px;-fx-background-color: rgb(51, 51, 51);-fx-text-fill:white;-fx-font-family: 'Cooper Black'");
        agregarJugadores.setMaxWidth(220);

        this.getChildren().addAll(nombreJugador1, nombreJugador2, agregarJugadores);

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setStyle("-fx-background-color:rgb(140, 199, 63)");
        this.getChildren().addAll(logoView);
    }


}
