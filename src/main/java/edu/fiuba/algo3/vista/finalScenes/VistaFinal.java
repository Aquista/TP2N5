package edu.fiuba.algo3.vista.finalScenes;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaFinal extends VBox {

    public VistaFinal(Jugador ganador, Jugador perdedor){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPrefWidth(200);

        Label nombreGanador = new Label("♕ " + ganador.nombre() + " ♕");
        Label puntajeGanador = new Label(String.valueOf(ganador.getPuntaje()));
        nombreGanador.setStyle("-fx-font-size: 40px; -fx-text-fill: #ff8080; -fx-margin-bottom: 0px");
        puntajeGanador.setStyle("-fx-font-size: 30px; -fx-margin-top: 0px; -fx-font-family: 'Cooper Black'");
        System.out.println(javafx.scene.text.Font.getFamilies());
        Label nombrePerdedor = new Label("Cebollita: " + perdedor.nombre());
        Label puntajePerdedor = new Label(String.valueOf(perdedor.getPuntaje()));
        nombrePerdedor.setStyle("-fx-font-size: 20px; -fx-text-fill: #000000; -fx-font-family: 'Cooper Black'");

        this.getChildren().addAll(nombreGanador, puntajeGanador, nombrePerdedor, puntajePerdedor);
    }
}
