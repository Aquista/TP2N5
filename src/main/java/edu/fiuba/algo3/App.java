package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.VistaPanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        VistaPanel panelPrincipal=new VistaPanel();
        Scene scene=new Scene(panelPrincipal,600,600);
        stage.setScene(scene);
        stage.show();
    }

}