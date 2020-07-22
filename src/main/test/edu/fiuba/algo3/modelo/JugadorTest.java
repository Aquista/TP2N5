package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test01CreoUnJugadorYLeSumoUnPunto() {
        Jugador primerJugador = new Jugador();
        int cantidadASumar = 1;
        primerJugador.actualizarPuntaje(cantidadASumar);

        assertEquals(cantidadASumar,primerJugador.getPuntaje());
    }
    @Test
    public void test02CreoUnJugadorYLeSumoTresPuntos() {
        Jugador primerJugador = new Jugador();
        int cantidadASumar = 3;
        primerJugador.actualizarPuntaje(cantidadASumar);

        assertEquals(cantidadASumar,primerJugador.getPuntaje());
    }
    @Test
    public void test03CreoUnJugadorCon1RespuestaCorrectaYSeEvalua() {
        int cantidadRespuestasCorrectas = 1;
        Jugador jugador = new Jugador();
        Marcador marcador = new Marcador(jugador);
        RespuestaCorrecta resCorrecta = new RespuestaCorrecta("true");
        ArrayList<IRespuesta> respuestas = new ArrayList<IRespuesta>();
        respuestas.add(resCorrecta);
        jugador.establecerRespuestas(respuestas);

        jugador.evaluarRespuestas(marcador);

        assertEquals(marcador.getRespuestasCorrectas(), cantidadRespuestasCorrectas);
    }
    @Test
    public void test04CreoUnJugadorCon1RespuestaIncorrectaYSeEvalua() {
        int cantidadRespuestasIncorrectas = 1;
        Jugador jugador = new Jugador();
        Marcador marcador = new Marcador(jugador);
        RespuestaIncorrecta resIncorrecta = new RespuestaIncorrecta("false");
        ArrayList<IRespuesta> respuestas = new ArrayList<IRespuesta>();
        respuestas.add(resIncorrecta);
        jugador.establecerRespuestas(respuestas);

        jugador.evaluarRespuestas(marcador);

        assertEquals(marcador.getRespuestasIncorrectas(), cantidadRespuestasIncorrectas);
    }

}
