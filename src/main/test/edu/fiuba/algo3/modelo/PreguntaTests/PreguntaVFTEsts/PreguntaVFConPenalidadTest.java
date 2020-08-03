package edu.fiuba.algo3.modelo.PreguntaTests.PreguntaVFTEsts;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVFConPenalidadTest {
    @Test
    public void test01CreoUnaPreguntaConPenalidadYEvaluoLosJugadoresCon1RespuestaCorrecta() {
        int puntajeEsperado = 1;

        Jugador primerJugador = new Jugador();
        Jugador segundoJugador = new Jugador();

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");

        primerJugador.responderConRespuesta(1, new RespuestaVF(opcionCorrecta));
        segundoJugador.responderConRespuesta(1, new RespuestaVF(opcionCorrecta));

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta",new PuntajeConPenalidad());
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);

        pregunta.evaluarJugadores(primerJugador, segundoJugador);

        assertEquals(puntajeEsperado, primerJugador.puntos());
    }

    @Test
    public void test02CreoUnaPreguntaConPenalidadYEvaluo2JugadoresConRespuestaCorrectaEInconrrecta() {

        int puntosGanados=4;

        Jugador primerJugador = new Jugador();
        primerJugador.actualizarPuntaje(puntosGanados);
        Jugador segundoJugador = new Jugador();
        segundoJugador.actualizarPuntaje(puntosGanados);

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");

        primerJugador.responderConRespuesta(1, new RespuestaVF(opcionCorrecta));
        segundoJugador.responderConRespuesta(1, new RespuestaVF(opcionIncorrecta));

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta",new PuntajeConPenalidad());
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);

        pregunta.evaluarJugadores(primerJugador, segundoJugador);

        assertEquals(puntosGanados + 1, primerJugador.puntos());
        assertEquals(puntosGanados - 1, segundoJugador.puntos());
    }
    @Test
    public void test03CreoUnaPreguntaConPenalidadYEvaluoLosJugadoresCon1RespuestaCorrectaYMultiplicadorx2() {

        int puntajeEsperado = 1;

        Jugador primerJugador = new Jugador();
        Jugador segundoJugador = new Jugador();

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");

        primerJugador.responderConRespuesta(2, new RespuestaVF(opcionCorrecta));
        segundoJugador.responderConRespuesta(2, new RespuestaVF(opcionCorrecta));

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta",new PuntajeConPenalidad());
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);

        pregunta.evaluarJugadores(primerJugador, segundoJugador);

        assertEquals(puntajeEsperado*2, primerJugador.puntos());
    }

}
