package edu.fiuba.algo3.modelo.PuntajeTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeParcial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeParcialTest {

    @Test
    public void test01PuntajeParcialAgrega1PuntoSiUnJugadorContestaBien1Respuesta(){
        Jugador unJugador = new Jugador();
        PuntajeParcial puntaje = new PuntajeParcial();
        OpcionCorrecta opcion = new OpcionCorrecta("false");
        opcion.evaluar(puntaje);
        puntaje.calcularPuntaje(unJugador,0);
        assertEquals(1, unJugador.puntos());
    }

    @Test
    public void test02PuntajeParcialNoModificaLosPuntoSiUnJugadorCon0PuntosContestaMal(){
        Jugador unJugador = new Jugador();
        PuntajeParcial puntaje = new PuntajeParcial();
        OpcionIncorrecta opcion = new OpcionIncorrecta("false");
        opcion.evaluar(puntaje);

        puntaje.calcularPuntaje(unJugador,0);
        assertEquals(0, unJugador.puntos());
    }
}
