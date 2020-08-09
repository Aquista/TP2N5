package edu.fiuba.algo3.modelo.PuntajeTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeParcial;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeParcialTest {

    @Test
    public void test01PuntajeParcialAgrega1PuntoSiUnJugadorContestaBien1Respuesta(){

        Jugador unJugador = new Jugador();

        OpcionCorrecta opcion = new OpcionCorrecta("false");
        unJugador.responderVF(opcion);

        PuntajeParcial puntaje = new PuntajeParcial();
        assertEquals(1, puntaje.calcularPuntaje(unJugador, 1));
    }

    @Test
    public void test02PuntajeParcialNoModificaLosPuntoSiUnJugadorCon0PuntosContestaMal(){

        Jugador unJugador = new Jugador();

        OpcionIncorrecta opcion = new OpcionIncorrecta("false");
        unJugador.responderVF(opcion);

        PuntajeParcial puntaje = new PuntajeParcial();
        assertEquals(0, puntaje.calcularPuntaje(unJugador, 1));
    }
}
