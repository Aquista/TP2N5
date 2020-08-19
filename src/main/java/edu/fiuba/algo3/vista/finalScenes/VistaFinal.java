package edu.fiuba.algo3.vista.finalScenes;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaFinal extends VBox {

    public VistaFinal(Jugador ganador, Jugador perdedor){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPrefWidth(200);
        this.setStyle("-fx-background-color: #8CC73F");

        Label nombreGanador = new Label("♕ " + ganador.nombre() + " ♕");
        Label puntajeGanador = new Label(String.valueOf(ganador.getPuntaje()));
        nombreGanador.getStyleClass().add("texto-jugador");
        nombreGanador.setStyle("-fx-font-size: 70px; -fx-text-fill: #fffebb; -fx-font-smoothing-type: gray");
        puntajeGanador.getStyleClass().add("texto-puntaje");
        puntajeGanador.setStyle("-fx-font-size: 50px");
        VBox.setMargin(puntajeGanador, new Insets(-60,0,50,0));

        Label nombrePerdedor = new Label(perdedor.nombre());
        Label puntajePerdedor = new Label(String.valueOf(perdedor.getPuntaje()));
        nombrePerdedor.getStyleClass().add("texto-jugador");
        nombrePerdedor.setStyle("-fx-font-size: 25px");
        puntajePerdedor.getStyleClass().add("texto-puntaje");
        puntajePerdedor.setStyle("-fx-font-size: 20px");
        VBox.setMargin(puntajePerdedor, new Insets(-30,0,0,0));

        this.getChildren().addAll(nombreGanador, puntajeGanador, nombrePerdedor, puntajePerdedor);
    }
}
