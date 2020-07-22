package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVFTest {

    @Test
    public void test01CreoUnaPreguntaYEvaluo1JugadorCon1RespuestaCorrecta() {
        int puntajeEsperado = 1;

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("true");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("false");
        ArrayList<IRespuesta> respuestasPregunta = new ArrayList<IRespuesta>();
        respuestasPregunta.add(respuestaCorrecta);
        respuestasPregunta.add(respuestaIncorrecta);
        PreguntaVF pregunta = new PreguntaVF(respuestasPregunta);

        Jugador jugador = new Jugador();
        ArrayList<IRespuesta> respuestasJugador = new ArrayList<IRespuesta>();
        respuestasJugador.add(respuestaCorrecta);
        jugador.establecerRespuestas(respuestasJugador);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(jugador.getPuntaje(), puntajeEsperado);
    }

    @Test
    public void test02CreoUnaPreguntaYEvaluo2Jugadores() {

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("true");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("false");
        ArrayList<IRespuesta> respuestasPregunta = new ArrayList<IRespuesta>();
        respuestasPregunta.add(respuestaCorrecta);
        respuestasPregunta.add(respuestaIncorrecta);
        PreguntaVF pregunta = new PreguntaVF(respuestasPregunta);

        Jugador jugador1 = new Jugador();
        ArrayList<IRespuesta> respuestasJugador1 = new ArrayList<IRespuesta>();
        respuestasJugador1.add(respuestaCorrecta);
        jugador1.establecerRespuestas(respuestasJugador1);

        Jugador jugador2 = new Jugador();
        ArrayList<IRespuesta> respuestasJugador2 = new ArrayList<IRespuesta>();
        respuestasJugador2.add(respuestaIncorrecta);
        jugador2.establecerRespuestas(respuestasJugador2);

        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(jugador1.getPuntaje(), 1);
        assertEquals(jugador2.getPuntaje(), 0);
    }
}
