package edu.fiuba.algo3.modelo.PreguntaTests.PreguntaVFTests;

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

    @Test
    public void test05UnJugadorRespondeBienYElOtroMalConExclusividadYSuma2PuntosYElOtro0EnPuntajeClasico(){
        int puntajeJugador1Esperado = 2;
        int puntajeJugador2Esperado = 0;

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionIncorrecta op2 = new OpcionIncorrecta("texto opcion 2");
        PuntajeClasico puntaje = new PuntajeClasico();

        PreguntaVF pregunta = new PreguntaVF("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionIncorrecta(op2);

        RespuestaVF resp1 = new RespuestaVF();
        resp1.agregarOpcion(op1);
        jugador1.establecerRespuesta(resp1);
        jugador1.seleccionarExclusividad(0);

        RespuestaVF resp2 = new RespuestaVF();
        resp2.agregarOpcion(op2);
        jugador2.establecerRespuesta(resp2);

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

        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionIncorrecta op2 = new OpcionIncorrecta("texto opcion 2");
        PuntajeClasico puntaje = new PuntajeClasico();

        PreguntaVF pregunta = new PreguntaVF("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionIncorrecta(op2);

        RespuestaVF resp1 = new RespuestaVF();
        resp1.agregarOpcion(op1);
        jugador1.establecerRespuesta(resp1);
        jugador1.seleccionarExclusividad(0);

        RespuestaVF resp2 = new RespuestaVF();
        resp2.agregarOpcion(op2);
        jugador2.establecerRespuesta(resp2);
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

        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionIncorrecta op2 = new OpcionIncorrecta("texto opcion 2");
        PuntajeClasico puntaje = new PuntajeClasico();

        PreguntaVF pregunta = new PreguntaVF("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionIncorrecta(op2);

        RespuestaVF resp1 = new RespuestaVF();
        resp1.agregarOpcion(op1);
        jugador1.establecerRespuesta(resp1);
        jugador1.seleccionarExclusividad(0);

        RespuestaVF resp2 = new RespuestaVF();
        resp2.agregarOpcion(op1);
        jugador2.establecerRespuesta(resp2);
        jugador2.seleccionarExclusividad(0);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeJugador1Esperado, jugador1.getPuntaje());
        assertEquals(puntajeJugador2Esperado, jugador2.getPuntaje());
    }
    
}
