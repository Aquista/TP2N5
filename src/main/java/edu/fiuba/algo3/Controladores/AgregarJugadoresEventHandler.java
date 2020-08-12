package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


public class AgregarJugadoresEventHandler implements EventHandler<ActionEvent> {
    private TextField nombreJugador1;
    private TextField nombreJugador2;
    private Kahoot kahoot;

    public AgregarJugadoresEventHandler(TextField nombreJugador1, TextField nombreJugador2, Kahoot kahoot){
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        this.kahoot = kahoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.agregarJugadores(nombreJugador1.getText(), nombreJugador2.getText());
        kahoot.empezarPartida();
    }
}
