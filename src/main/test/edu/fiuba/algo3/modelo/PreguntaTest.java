package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {

    @Test
    public void creoUnaPruebaConRespuestaCorrecta() {
        int puntosPregunta = 100;
        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta(true);
        Pregunta pregunta = new Pregunta(puntosPregunta, respuestaCorrecta);

        Jugador j1 = new Jugador();
        Jugador j2 = new Jugador();
        RespuestaCorrecta res1 = new RespuestaCorrecta(true);
        RespuestaCorrecta res2 = new RespuestaCorrecta(true);

        pregunta.evaluarRespuestas(j1, res1, j2, res2);

        assertEquals(j1.getPuntos(), puntosPregunta);

        //Respuesta, tipoRespuesta RespuestaCorrecta.evaluar() o RespuestaIncorrecta.evaluar()
    }
}
