package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test01JugadorNuevoTiene0Puntos() {
        Jugador primerJugador = new Jugador();
        assertEquals(0,primerJugador.getPuntaje());
    }
    @Test
    public void test02CreoUnJugadorYLeSumo3Puntos() {
        Jugador primerJugador = new Jugador();
        int puntos = 3;
        primerJugador.actualizarPuntaje(puntos);

        assertEquals(puntos, primerJugador.getPuntaje());
    }
    @Test
    public void test03AUnJugadorCon0PuntosLeResto1PuntoYSigueTeniendo0Puntos() {
        Jugador primerJugador = new Jugador();
        int puntos = -1;
        int puntosEsperados = 0;
        primerJugador.actualizarPuntaje(puntos);

        assertEquals(puntosEsperados, primerJugador.getPuntaje());
    }
    @Test
    public void test04AUnJugadorCon6PuntosLeResto4PuntosYTiene2Puntos() {
        Jugador primerJugador = new Jugador();
        int puntosIniciales = 6;
        int puntosARestar = -4;
        int puntosEsperados = 2;
        primerJugador.actualizarPuntaje(puntosIniciales);
        primerJugador.actualizarPuntaje(puntosARestar);


        assertEquals(puntosEsperados, primerJugador.getPuntaje());
    }

    @Test
    public void test05CreoUnJugadorCon1RespuestaCorrectaYSeEvalua() {
        int cantidadRespuestasCorrectas = 1;
        Jugador jugador = new Jugador();
        PuntajeClasico unPuntaje = new PuntajeClasico();
        RespuestaCorrecta resCorrecta = new RespuestaCorrecta("true");
        ArrayList<IRespuesta> respuestas = new ArrayList<IRespuesta>();
        respuestas.add(resCorrecta);
        jugador.establecerRespuestas(respuestas);

        jugador.evaluarRespuestas(unPuntaje);

        assertEquals(unPuntaje.getRespuestasCorrectas(), cantidadRespuestasCorrectas);
    }
    @Test
    public void test06CreoUnJugadorCon1RespuestaIncorrectaYSeEvalua() {
        int cantidadRespuestasIncorrectas = 1;
        Jugador jugador = new Jugador();
        PuntajeClasico unPuntaje = new PuntajeClasico();
        RespuestaIncorrecta resIncorrecta = new RespuestaIncorrecta("false");
        ArrayList<IRespuesta> respuestas = new ArrayList<IRespuesta>();
        respuestas.add(resIncorrecta);
        jugador.establecerRespuestas(respuestas);

        jugador.evaluarRespuestas(unPuntaje);

        assertEquals(unPuntaje.getRespuestasIncorrectas(), cantidadRespuestasIncorrectas);
    }


}
