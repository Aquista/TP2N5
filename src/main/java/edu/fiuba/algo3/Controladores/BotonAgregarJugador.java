package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Panel.Panel;
import edu.fiuba.algo3.vista.VistaPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonAgregarJugador implements EventHandler<ActionEvent> {
    private Stage stage;
    private TextField nombreJugador;
    private Panel panel;
    public BotonAgregarJugador(Stage primerStage, TextField unNombreJugador, Panel panel){
        this.stage = primerStage;
        this.nombreJugador = unNombreJugador;
        this.panel=panel;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String jugador = this.nombreJugador.getText();
        System.out.println(jugador);
        this.nombreJugador.setText(null);
        this.panel.agregarJugador(new Jugador(jugador));
        if(this.panel.cantJugadores() == 2){
            this.panel.iniciarJuego();
            VistaPanel pan=new VistaPanel(this.stage,this.panel);
            Scene scene=new Scene(pan,800,600);
            this.stage.setScene(scene);
        }
    }
}
