package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.controlador.Panel;
import edu.fiuba.algo3.vista.VistaMusica;
import edu.fiuba.algo3.vista.inicioScenes.VistaCreacionJugadores;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class App extends Application{

    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Kahoot kahoot = new Kahoot();
        Panel panel = new Panel(kahoot, stage);
        stage.setTitle("TP2-Kahoot");
        BorderPane layout = new BorderPane();
        VistaMusica musica= new VistaMusica();
        layout.setRight(musica);
        layout.setCenter(new VistaCreacionJugadores(kahoot, panel));
        Scene scene = new Scene(layout,800,600);
        stage.setScene(scene);
        musica.encencer();
        stage.show();

    }

}