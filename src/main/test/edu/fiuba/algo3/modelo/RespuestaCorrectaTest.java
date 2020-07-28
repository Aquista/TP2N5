package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaCorrectaTest {
    @Test
    public void test01RespuestaCorrectaSuma1RespuestaCorrectaAMarcador() {
        int cantidadRespuestasCorrectas = 1;
        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Soy una respuesta correcta");
        Jugador jugador = new Jugador();
        PuntajeClasico unPuntaje = new PuntajeClasico();

        respuestaCorrecta.evaluar(unPuntaje);

        assertEquals(unPuntaje.getRespuestasCorrectas(), cantidadRespuestasCorrectas);
    }

}
