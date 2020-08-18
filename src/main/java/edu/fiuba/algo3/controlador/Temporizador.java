package edu.fiuba.algo3.controlador;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Temporizador {
    private Timeline temporizador = new Timeline();
    private Label texto;
    private int tiempo;
    private int tiempoAlerta = 5;
    private boolean activo = true;
    private EventHandler<ActionEvent> evento = null;


    public Temporizador(Label texto, int tiempo) {
        this.texto = texto;
        this.tiempo = tiempo;
    }

    public void setEvento(EventHandler<ActionEvent> evento) {
        this.evento = evento;
    }

    public void empezarTemporizador() {
        if(evento == null)
            return;

        temporizador = new Timeline(
            new KeyFrame(Duration.seconds(1),
                new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        tiempo--;
                        if(tiempo > 0) {
                            texto.setText(String.valueOf(tiempo));
                            if(tiempo <= tiempoAlerta)
                                texto.getStyleClass().add("alerta");
                        }
                        else if(activo == true){
                            evento.handle(event);
                        }
                    }
                }));

        temporizador.setCycleCount(tiempo);
        temporizador.play();
    }

    public void apagarTemporizador() {
        activo = false;
    }
}
