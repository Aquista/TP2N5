package edu.fiuba.algo3.modelo.PreguntaTests.PreguntaVFTEsts;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVFClasicoTest {

    @Test
    public void test01CreoUnaPreguntaClasicaYEvaluoLosJugadorCon1RespuestaCorrecta() {
        int puntajeEsperado = 1;

        Jugador jugador = new Jugador();
        Jugador segundoJugador =  new Jugador();

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");

        jugador.establecerRespuesta(new RespuestaVF());
        jugador.responderCon(1, opcionCorrecta);
        segundoJugador.establecerRespuesta(new RespuestaVF());
        segundoJugador.responderCon(1, opcionCorrecta);

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta",new PuntajeClasico());
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);

        pregunta.evaluarJugadores(jugador,segundoJugador);

        assertEquals(puntajeEsperado,jugador.puntos());

    }

    @Test
    public void test02CreoUnaPreguntaClasicaYEvaluo2Jugadores() {

        Jugador jugador = new Jugador();
        Jugador segundoJugador =  new Jugador();

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");

        jugador.establecerRespuesta(new RespuestaVF());
        jugador.responderCon(1, opcionCorrecta);
        segundoJugador.establecerRespuesta(new RespuestaVF());
        segundoJugador.responderCon(1, opcionIncorrecta);

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta",new PuntajeClasico());
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);

        pregunta.evaluarJugadores(jugador, segundoJugador);

        assertEquals(1,jugador.puntos());
        assertEquals(0,segundoJugador.puntos());
    }
}
