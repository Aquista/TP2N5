package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class VistaPuntajes extends HBox {
    private Jugador jugador1;
    private Jugador jugador2;
    private Label puntajeJugador1;
    private Label puntajeJugador2;

    public VistaPuntajes(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        agregarInfo();
    }
    public void agregarInfo() {
        Label nombreJugador1 = new Label(this.jugador1.nombre() + ": ");
        puntajeJugador1 = new Label(String.valueOf(this.jugador1.getPuntaje()));


        Label nombreJugador2 = new Label(this.jugador2.nombre() + ": ");
        puntajeJugador2 = new Label(String.valueOf(this.jugador2.getPuntaje()));

        nombreJugador1.setStyle("-fx-font-size: 25px");
        nombreJugador2.setStyle("-fx-font-size: 25px");
        puntajeJugador1.setStyle("-fx-font-size: 25px");
        puntajeJugador2.setStyle("-fx-font-size: 25px");

        final Pane espacio = new Pane();
        HBox.setHgrow(espacio, Priority.ALWAYS);
        espacio.setMinSize(10, 1);

        this.getChildren().addAll(nombreJugador1, puntajeJugador1, espacio, nombreJugador2, puntajeJugador2);
    }
    public void actualizar() {
        puntajeJugador1.setText(String.valueOf(this.jugador1.getPuntaje()));
        puntajeJugador2.setText(String.valueOf(this.jugador2.getPuntaje()));
    }
}