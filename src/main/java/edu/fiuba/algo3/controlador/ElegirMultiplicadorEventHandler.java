package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modificadores.Multiplicador;
import edu.fiuba.algo3.vista.VistaModificadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ElegirMultiplicadorEventHandler implements EventHandler<ActionEvent> {
    private Jugador jugador;
    private Multiplicador multiplicador;
    private VistaModificadores vista;
    private Button seleccionado;
    public ElegirMultiplicadorEventHandler(Jugador jugador, Multiplicador multiplicador, VistaModificadores vista, Button seleccionado) {
        this.jugador = jugador;
        this.multiplicador = multiplicador;
        this.vista = vista;
        this.seleccionado = seleccionado;
    }

    @Override
    public void handle(ActionEvent event) {
        jugador.seleccionarMultiplicador(multiplicador);
        vista.deshabilitarBotones(seleccionado);
    }
}
