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

public class VistaCambioTurno extends VBox {
    private int tiempo = 3;
    private Label textoTiempo = new Label(String.valueOf(tiempo));

    public VistaCambioTurno(Jugador jugador, Panel panel){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPrefWidth(200);
        this.textoTiempo.getStyleClass().add("temporizador");
        this.setStyle("-fx-background-color: #26cec5");

        Label textoTurno = new Label("TURNO DE:");
        textoTurno.getStyleClass().add("texto-turno");
        Label nombreJugador = new Label(jugador.nombre());
        nombreJugador.getStyleClass().add("texto-jugador");

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
                                   AvanzarTurnoController.avanzarTurnoPanel(panel);
                                }
                            }
                        }));
        timer.setCycleCount(tiempo);
        timer.play();

        this.getChildren().addAll(textoTiempo, textoTurno, nombreJugador);
    }
}
