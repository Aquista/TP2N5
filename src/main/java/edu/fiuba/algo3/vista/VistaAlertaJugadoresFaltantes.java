package edu.fiuba.algo3.vista;

import javafx.scene.control.Alert;

public class VistaAlertaJugadoresFaltantes extends Alert {

    public VistaAlertaJugadoresFaltantes() {
        super(AlertType.WARNING);
        this.setTitle("Faltan Jugadores");
        this.setHeaderText("Agregue a los jugadores que faltan.");
    }
}
