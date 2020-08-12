package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class AgregarJugadoresEventHandler implements EventHandler<ActionEvent> {
    private String nombreJugador1;
    private String nombreJugador2;
    private Kahoot kahoot;

    public AgregarJugadoresEventHandler(String nombreJugador1, String nombreJugador2, Kahoot kahoot){
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        this.kahoot = kahoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.agregarJugadores(nombreJugador1, nombreJugador2);
        kahoot.empezarPartida();
    }
}
