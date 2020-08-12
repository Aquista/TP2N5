package edu.fiuba.algo3.modelo.PanelTest;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Panel.ControlTurnos;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlTurnosTest {
    @Test
    public void test01SeIniciaElJuegoConJugador1YELSiguienteEsJugador2(){
        Jugador jugador1 = new Jugador("Kev");
        Jugador jugador2 = new Jugador("Kev2");
        PreguntaVF pregunta1=new PreguntaVF("A",new PuntajeClasico());
        pregunta1.agregarOpcionCorrecta("True");
        pregunta1.agregarOpcionIncorrecta("False");
        ArrayList<PreguntaVF> lista=new ArrayList<>();
        lista.add(pregunta1);
        ControlTurnos turnos=new ControlTurnos(lista,jugador1,jugador2);
        turnos.iniciarJuego();
        turnos.cambiarTurno();
        assertEquals(jugador2,turnos.jugadorActual());
    }
}
