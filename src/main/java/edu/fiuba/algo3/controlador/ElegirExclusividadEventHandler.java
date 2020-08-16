package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Modificadores.Exclusividad;
import edu.fiuba.algo3.vista.VistaModificadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ElegirExclusividadEventHandler implements EventHandler<ActionEvent> {
    private Jugador jugador;
    private Exclusividad exclusividad;
    private VistaModificadores vista;
    private Button seleccionado;

    public ElegirExclusividadEventHandler(Jugador jugador, Exclusividad exclusividad, VistaModificadores vista, Button seleccionado) {
        this.jugador = jugador;
        this.exclusividad = exclusividad;
        this.vista = vista;
        this.seleccionado = seleccionado;
    }

    @Override
    public void handle(ActionEvent event) {
        jugador.seleccionarExclusividad(exclusividad);
        vista.deshabilitarBotones(seleccionado);
    }
}
