package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.VistaAlertaJugadoresFaltantes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;


public class AgregarJugadoresEventHandler implements EventHandler<ActionEvent> {
    private TextField nombreJugador1;
    private TextField nombreJugador2;
    private Kahoot kahoot;
    private Panel panel;

    public AgregarJugadoresEventHandler(TextField nombreJugador1, TextField nombreJugador2, Kahoot kahoot, Panel panel){
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        this.kahoot = kahoot;
        this.panel = panel;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String primerJugador = nombreJugador1.getText().toUpperCase();
        String segundoJugador = nombreJugador2.getText().toUpperCase();
        if(primerJugador.isEmpty() || segundoJugador.isEmpty()){
            VistaAlertaJugadoresFaltantes alerta = new VistaAlertaJugadoresFaltantes();
            alerta.showAndWait();
        }else{
            kahoot.agregarJugadores(primerJugador, segundoJugador );
            panel.empezarPartida();
        }
    }
}
