package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Panel.Panel;
import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.inicioScenes.VistaPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Panel panel = new Panel();
        VistaPrincipal pantallaPrincipal=new VistaPrincipal(stage,panel);
        Scene scene=new Scene(pantallaPrincipal,800,600);
        stage.setScene(scene);
        stage.show();
    }

}