package edu.fiuba.algo3.modelo.PreguntaTests.PreguntaVFTEsts;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVFClasicoTest {

    @Test
    public void test01CreoUnaPreguntaClasicaYEvaluo1JugadorCon1RespuestaCorrecta() {
        int puntajeEsperado = 1;

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta",new PuntajeClasico());
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);

        Jugador jugador = new Jugador();
        jugador.responderPreguntaCon(pregunta, opcionCorrecta);

        assertEquals(puntajeEsperado,jugador.puntos());
    }

    @Test
    public void test02CreoUnaPreguntaClasicaYEvaluo2Jugadores() {

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta",new PuntajeClasico());
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);
        
        Jugador jugador1 = new Jugador();
        jugador1.responderPreguntaCon(pregunta, opcionCorrecta);
        Jugador jugador2 = new Jugador();
        jugador2.responderPreguntaCon(pregunta, opcionIncorrecta);

        assertEquals(1,jugador1.puntos());
        assertEquals(0,jugador2.puntos());
    }
}
