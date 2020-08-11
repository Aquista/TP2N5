package edu.fiuba.algo3.modelo.PanelTest;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Panel.Panel;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PanelTest {
    @Test
    public void test01ElGanadorDelKahootEsElQueTieneMasPuntos(){
        Jugador primerJugador = new Jugador("J1");
        Jugador segundoJugador = new Jugador("J2");
        ArrayList<Jugador> jugadores=new ArrayList<>();
        jugadores.add(primerJugador);
        jugadores.add(segundoJugador);
        Panel panel = new Panel(jugadores);
        PreguntaVF unaPregunta = new PreguntaVF("aprobamos?", new PuntajeClasico());
        OpcionCorrecta opcionCorrecta = unaPregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = unaPregunta.agregarOpcionIncorrecta("false");
        primerJugador.responder(unaPregunta.tipo(),opcionCorrecta);
        segundoJugador.responder(unaPregunta.tipo(),opcionIncorrecta);
        assertEquals(primerJugador,panel.ganador());
    }
    @Test
    public void test02SeIniciaElJuegoConJugador1YELSiguienteEsJugador2DespuesDePasarTurno(){
        Jugador primerJugador = new Jugador("J1");
        Jugador segundoJugador = new Jugador("J2");
        Panel panel = new Panel();
        panel.agregarJugador(primerJugador);
        panel.agregarJugador(segundoJugador);
        panel.iniciarJuego();
        panel.pasarTurno();
        assertEquals(segundoJugador,panel.jugadorActual());
    }
}
