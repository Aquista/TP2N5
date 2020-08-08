package edu.fiuba.algo3.modelo.PreguntaTests;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVFTest {

    @Test
    public void test01CreoUnaPreguntaClasicaYEvaluo1JugadorCon1RespuestaCorrecta() {
        int puntajeEsperado = 1;

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta", new PuntajeClasico());
        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        jugador.responderVF(opcionCorrecta);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado,jugador.getPuntaje());
    }

    @Test
    public void test02CreoUnaPreguntaClasicaYEvaluo2Jugadores() {

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta", new PuntajeClasico());

        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        jugador1.responderVF(opcionCorrecta);
        jugador2.responderVF(opcionIncorrecta);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(1,jugador1.getPuntaje());
        assertEquals(0,jugador2.getPuntaje());
    }
    @Test
    public void test03CreoUnaPreguntaConPenalidadYEvaluo1JugadorCon1RespuestaCorrectaYMultiplicadorX3() {
        int puntajeEsperado = 3;

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta", new PuntajeConPenalidad());
        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        jugador.responderVF(opcionCorrecta);
        jugador.seleccionarMultiplicador(1);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado,jugador.getPuntaje());
    }

    @Test
    public void test04CreoUnaPreguntaConPenalidadYEvaluo1JugadorCon1RespuestaCorrectaYMultiplicadorX2() {
        int puntajeEsperado = 2;

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta", new PuntajeConPenalidad());
        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        jugador.responderVF(opcionCorrecta);
        jugador.seleccionarMultiplicador(0);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado,jugador.getPuntaje());
    }

    @Test
    public void test05UnJugadorRespondeBienYElOtroMalConExclusividadYSuma2PuntosYElOtro0EnPuntajeClasico(){
        int puntajeJugador1Esperado = 2;
        int puntajeJugador2Esperado = 0;

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaVF pregunta = new PreguntaVF("texto", new PuntajeClasico());
        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        jugador1.responderVF(opcionCorrecta);
        jugador1.seleccionarExclusividad(0);
        jugador2.responderVF(opcionIncorrecta);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeJugador1Esperado, jugador1.getPuntaje());
        assertEquals(puntajeJugador2Esperado, jugador2.getPuntaje());
    }

    @Test
    public void test06UnJugadorRespondeBienYElOtroMalCon2ExclusividadYSuma4PuntosYElOtro0EnPuntajeClasico(){
        int puntajeJugador1Esperado = 4;
        int puntajeJugador2Esperado = 0;

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaVF pregunta = new PreguntaVF("texto", new PuntajeClasico());
        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        jugador1.responderVF(opcionCorrecta);
        jugador1.seleccionarExclusividad(0);
        jugador2.responderVF(opcionIncorrecta);
        jugador2.seleccionarExclusividad(0);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeJugador1Esperado, jugador1.getPuntaje());
        assertEquals(puntajeJugador2Esperado, jugador2.getPuntaje());
    }

    @Test
    public void test07UnJugadorRespondeBienYElOtroBienCon2ExclusividadYSuma1PuntoCadaUnoEnPuntajeClasico(){
        int puntajeJugador1Esperado = 1;
        int puntajeJugador2Esperado = 1;

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaVF pregunta = new PreguntaVF("texto", new PuntajeClasico());
        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        jugador1.responderVF(opcionCorrecta);
        jugador1.seleccionarExclusividad(0);
        jugador2.responderVF(opcionCorrecta);
        jugador2.seleccionarExclusividad(0);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeJugador1Esperado, jugador1.getPuntaje());
        assertEquals(puntajeJugador2Esperado, jugador2.getPuntaje());
    }
    
}
