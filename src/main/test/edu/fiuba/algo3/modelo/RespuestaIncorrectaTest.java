package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaIncorrectaTest {
    @Test
    public void test01RespuestaIncorrectaSuma1RespuestaIncorrectaAMarcador() {
        int cantidadRespuestasIncorrectas = 1;
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Soy una respuesta incorrecta");
        Jugador jugador = new Jugador();
        PuntajeClasico unPuntaje = new PuntajeClasico();


        respuestaIncorrecta.evaluar(unPuntaje);

        assertEquals(unPuntaje.getRespuestasIncorrectas(), cantidadRespuestasIncorrectas);
    }
}