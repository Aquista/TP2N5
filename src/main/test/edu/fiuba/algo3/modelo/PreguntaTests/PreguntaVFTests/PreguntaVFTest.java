package edu.fiuba.algo3.modelo.PreguntaTests.PreguntaVFTests;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVFTest {

    @Test
    public void test01CreoUnaPreguntaClasicaYEvaluo1JugadorCon1RespuestaCorrecta() {
        int puntajeEsperado = 1;

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");
        PuntajeClasico puntaje = new PuntajeClasico();

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta", puntaje);
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        RespuestaVF respuesta = new RespuestaVF();
        respuesta.agregarOpcion(opcionCorrecta);
        jugador.establecerRespuesta(respuesta);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado,jugador.getPuntaje());
    }

    @Test
    public void test02CreoUnaPreguntaClasicaYEvaluo2Jugadores() {

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");
        PuntajeClasico puntaje = new PuntajeClasico();

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta", puntaje);
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);
        
        Jugador jugador1 = new Jugador();
        RespuestaVF respuesta1=new RespuestaVF();
        respuesta1.agregarOpcion(opcionCorrecta);
        jugador1.establecerRespuesta(respuesta1);

        Jugador jugador2 = new Jugador();
        RespuestaVF respuesta2=new RespuestaVF();
        respuesta2.agregarOpcion(opcionIncorrecta);
        jugador2.establecerRespuesta(respuesta2);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(1,jugador1.getPuntaje());
        assertEquals(0,jugador2.getPuntaje());
    }
    @Test
    public void test03CreoUnaPreguntaConPenalidadYEvaluo1JugadorCon1RespuestaCorrectaYMultiplicadorX3() {
        int puntajeEsperado = 3;

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");
        PuntajeConPenalidad puntaje = new PuntajeConPenalidad();

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta", puntaje);
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        RespuestaVF respuesta = new RespuestaVF();
        respuesta.agregarOpcion(opcionCorrecta);
        jugador.establecerRespuesta(respuesta);
        jugador.seleccionarMultiplicador(1);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado,jugador.getPuntaje());
    }

    @Test
    public void test04CreoUnaPreguntaConPenalidadYEvaluo1JugadorCon1RespuestaCorrectaYMultiplicadorX2() {
        int puntajeEsperado = 2;

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");
        PuntajeConPenalidad puntaje = new PuntajeConPenalidad();

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta", puntaje);
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        RespuestaVF respuesta = new RespuestaVF();
        respuesta.agregarOpcion(opcionCorrecta);
        jugador.establecerRespuesta(respuesta);
        jugador.seleccionarMultiplicador(0);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado,jugador.getPuntaje());
    }
}
