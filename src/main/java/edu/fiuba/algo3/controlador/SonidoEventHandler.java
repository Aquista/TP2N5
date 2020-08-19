package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaMusica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SonidoEventHandler implements EventHandler<ActionEvent>{
    private VistaMusica musica;
    public SonidoEventHandler(VistaMusica unaMusica){
        this.musica=unaMusica;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        this.musica.reproducir();
    }
}
