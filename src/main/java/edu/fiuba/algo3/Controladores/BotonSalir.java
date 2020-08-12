package edu.fiuba.algo3.Controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonSalir implements EventHandler<ActionEvent> {
    private Stage stage;
    public BotonSalir(Stage stage){
        this.stage=stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.stage.close();
    }
}
