package edu.fiuba.algo3.vista.inicioScenes;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class VistaPrincipal extends VBox {
    public VistaPrincipal(){
        Image logo = new Image("file:src/main/java/edu/fiuba/algo3/vista/otros/logo.png");
        ImageView logoView = new ImageView(logo);
        logoView.setFitHeight(150);
        logoView.setFitWidth(240);
        VistaPrincipalBotones botones =new VistaPrincipalBotones();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setStyle("-fx-background-color:rgb(140, 199, 63)");
        this.getChildren().addAll(logoView,botones);
    }

}
