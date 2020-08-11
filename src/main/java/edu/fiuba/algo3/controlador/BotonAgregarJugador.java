package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonAgregarJugador implements EventHandler<ActionEvent> {
    private Stage stage;
    private TextField nombreJugador;
    private ArrayList<Jugador> jugadores;
    public BotonAgregarJugador(Stage primerStage, TextField unNombreJugador){
        this.stage=primerStage;
        this.nombreJugador=unNombreJugador;
        this.jugadores=new ArrayList<>();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String jugador= this.nombreJugador.getText();
        this.jugadores.add(new Jugador(jugador));
        System.out.println(jugador);
        this.nombreJugador.setText("");
    }
}
