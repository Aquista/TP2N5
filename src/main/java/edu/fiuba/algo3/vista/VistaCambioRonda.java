package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.AvanzarTurnoController;
import edu.fiuba.algo3.controlador.Panel;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class VistaCambioRonda extends VBox {
    private int tiempo = 5;
    private Label textoTiempo = new Label(String.valueOf(tiempo));

    public VistaCambioRonda(Jugador jugador1, Jugador jugador2, Panel panel){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPrefWidth(200);
        this.textoTiempo.getStyleClass().add("temporizador");
        this.setStyle("-fx-background-color: #00b7ae");

        Label nombreJugador1 = new Label(jugador1.nombre());
        Label puntajeJugador1 = new Label(String.valueOf(jugador1.getPuntaje()));
        nombreJugador1.getStyleClass().add("texto-jugador");
        puntajeJugador1.getStyleClass().add("texto-puntaje");

        Label nombreJugador2 = new Label(jugador2.nombre());
        Label puntajeJugador2 = new Label(String.valueOf(jugador2.getPuntaje()));
        nombreJugador2.getStyleClass().add("texto-jugador");
        puntajeJugador2.getStyleClass().add("texto-puntaje");


        Timeline timer = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                tiempo--;
                                if(tiempo > 0) {
                                    textoTiempo.setText(String.valueOf(tiempo));
                                }
                                else {
                                    AvanzarTurnoController.avanzarTurno(panel);
                                }
                            }
                        }));
        timer.setCycleCount(tiempo);
        timer.play();

        this.getChildren().addAll(textoTiempo, nombreJugador1, puntajeJugador1, nombreJugador2, puntajeJugador2);
    }
}

