package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.SonidoEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class VistaMusica extends VBox {
    private String intro;
    private Media media;
    private MediaPlayer reproductor;
    private Image logoEncendido = new Image("file:src/main/java/edu/fiuba/algo3/vista/otros/sonido.png");
    private Image logoApagado = new Image("file:src/main/java/edu/fiuba/algo3/vista/otros/sonidoMuted.png");
    ImageView logoView = new ImageView();
    private boolean apagado;
    public VistaMusica(){
        this.intro="src/main/java/edu/fiuba/algo3/vista/otros/musica.mp3";
        this.media=new Media(Paths.get(this.intro).toUri().toString());
        this.reproductor=new MediaPlayer(this.media);
        this.apagado=true;
        this.setStyle("-fx-background-color:rgb(140, 199, 63)");
        this.setAlignment(Pos.TOP_LEFT);

        logoView.setImage(logoEncendido);
        logoView.setFitHeight(30);
        logoView.setFitWidth(30);
        Button sonido = new Button();
        sonido.setGraphic(logoView);
        sonido.setBackground(Background.EMPTY);
        sonido.setOnAction(new SonidoEventHandler(this));
        this.getChildren().add(sonido);
    }
    public void encender(){
        this.apagado = false;
        this.reproductor.play();
        this.reproductor.setCycleCount(MediaPlayer.INDEFINITE);
        logoView.setImage(logoEncendido);
    }
    public void apagar(){
        this.apagado = true;
        this.reproductor.pause();
        logoView.setImage(logoApagado);
    }
    public void reproducir(){
        if(this.apagado){
            this.encender();
        }else{
            this.apagar();
        }
    }
}
