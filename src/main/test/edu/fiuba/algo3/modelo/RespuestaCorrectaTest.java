package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaCorrectaTest {
    @Test
    public void test01RespuestaCorrectaSuma1RespuestaCorrectaAMarcador() {
        int cantidadRespuestasCorrectas = 1;
        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Soy una respuesta correcta");
        Jugador jugador = new Jugador();
        Marcador marcador = new Marcador(jugador);

        respuestaCorrecta.evaluar(marcador);

        assertEquals(marcador.getRespuestasCorrectas(), cantidadRespuestasCorrectas);
    }

}
