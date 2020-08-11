package edu.fiuba.algo3.modelo.PanelTest;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Panel.ControlTurnos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlTurnosTest {
    @Test
    public void test01SeIniciaElJuegoConJugador1YELSiguienteEsJugador2(){
        Jugador jugador1 = new Jugador("Kev");
        Jugador jugador2 = new Jugador("Kev2");
        ControlTurnos turnos=new ControlTurnos(jugador1,jugador2);
        turnos.iniciarJuego();
        turnos.cambiarTurno();
        assertEquals(jugador2,turnos.jugadorActual());
    }
}
