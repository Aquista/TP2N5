package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {

    @Test
    public void test01CsreoUnaPruebaConRespuestaCorrecta() {
        int puntosPregunta = 100;
        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta(true);
        Pregunta pregunta = new Pregunta(puntosPregunta, respuestaCorrecta);

        Jugador primerJugador = new Jugador();
        Jugador segundoJugador = new Jugador();
        RespuestaCorrecta res1 = new RespuestaCorrecta(true);
        RespuestaCorrecta res2 = new RespuestaCorrecta(true);

        pregunta.evaluarRespuestas(primerJugador, res1, segundoJugador, res2);

        assertEquals(primerJugador.misPuntos(), puntosPregunta);
    }
}
