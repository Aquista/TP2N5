package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Ronda;

public class AvanzarTurnoController{

    public static void avanzarTurno(Panel panel) {
        Ronda ronda = panel.getRonda();

        if(ronda.finalizada()) {
            ronda.evaluarJugadores();
            panel.avanzarRonda();
        } else {
            ronda.avanzarTurno();
            panel.mostrarCambioTurno();
        }
    }

    public static void avanzarTurnoPanel(Panel panel){
        panel.avanzarTurno();
    }
}