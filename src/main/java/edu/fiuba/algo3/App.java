package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.inicioScenes.VistaCreacionJugadores;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Kahoot kahoot = new Kahoot(stage);
        stage.setTitle("TP2-Kahoot");

        VistaCreacionJugadores vistaCreacionJugadores = new VistaCreacionJugadores(kahoot);
        Scene scene = new Scene(vistaCreacionJugadores,800,600);
        stage.setScene(scene);
        stage.show();
    }

}