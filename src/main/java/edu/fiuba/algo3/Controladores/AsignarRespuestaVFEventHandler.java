package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Panel.Panel;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.vista.VistaPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AsignarRespuestaVFEventHandler implements EventHandler<ActionEvent> {
    private Jugador jugador;
    private Pregunta pregunta;
    private Opcion opcionSeleccionada;
    private VistaPanel vPanel;
    private Panel panel;

    public AsignarRespuestaVFEventHandler(Jugador jugador, Pregunta pregunta, Opcion seleccionada, VistaPanel vPanel,Panel panel) {
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.opcionSeleccionada = seleccionada;
        this.vPanel=vPanel;
        this.panel=panel;
    }

    @Override
    public void handle(ActionEvent event) {
        jugador.responder(pregunta.tipo(), this.opcionSeleccionada);
        System.out.println("F");
        this.panel.pasarTurno();
        this.vPanel.actulizarVistaPanel();
    }
}
