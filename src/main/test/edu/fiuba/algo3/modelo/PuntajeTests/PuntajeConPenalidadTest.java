package edu.fiuba.algo3.modelo.PuntajeTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeConPenalidadTest {
    @Test
    public void test01PuntajeConPenalidadAgrega1PuntoSiUnJugadorRespondeCorrectamente(){

        Jugador unJugador = new Jugador();
        OpcionCorrecta opcion = new OpcionCorrecta("true");

        unJugador.responderVF(opcion);

        PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();

        unPuntaje.asignarPuntaje(unJugador);
        assertEquals(1,unPuntaje.calcularPuntaje(unJugador, 1));
    }
    @Test
    public void test02PuntajeConPenalidadSaca1PuntoSiUnJugadorRespondeIncorrectamente(){

        Jugador unJugador = new Jugador();
        OpcionIncorrecta opcion = new OpcionIncorrecta("true");

        unJugador.responderVF(opcion);

        PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();

        unPuntaje.asignarPuntaje(unJugador);
        assertEquals(-1,unPuntaje.calcularPuntaje(unJugador, 1));
    }
}
