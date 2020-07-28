package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVFTest {

    @Test
    public void test01CreoUnaPreguntaClasicaYEvaluo1JugadorCon1RespuestaCorrecta() {
        int puntajeEsperado = 1;

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("true");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("false");
        ArrayList<IRespuesta> respuestasPregunta = new ArrayList<IRespuesta>();
        respuestasPregunta.add(respuestaCorrecta);
        respuestasPregunta.add(respuestaIncorrecta);
        PreguntaVF pregunta = new PreguntaVF(respuestasPregunta);

        Jugador jugador = new Jugador();
        ArrayList<IRespuesta> respuestasJugador = new ArrayList<IRespuesta>();
        respuestasJugador.add(respuestaCorrecta);
        jugador.establecerRespuestas(respuestasJugador);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntajeEsperado,jugador.getPuntaje());
    }

    @Test
    public void test02CreoUnaPreguntaClasicaYEvaluo2Jugadores() {

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("true");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("false");
        ArrayList<IRespuesta> respuestasPregunta = new ArrayList<IRespuesta>();
        respuestasPregunta.add(respuestaCorrecta);
        respuestasPregunta.add(respuestaIncorrecta);
        PreguntaVF pregunta = new PreguntaVF(respuestasPregunta);

        Jugador jugador1 = new Jugador();
        ArrayList<IRespuesta> respuestasJugador1 = new ArrayList<IRespuesta>();
        respuestasJugador1.add(respuestaCorrecta);
        jugador1.establecerRespuestas(respuestasJugador1);

        Jugador jugador2 = new Jugador();
        ArrayList<IRespuesta> respuestasJugador2 = new ArrayList<IRespuesta>();
        respuestasJugador2.add(respuestaIncorrecta);
        jugador2.establecerRespuestas(respuestasJugador2);

        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(1,jugador1.getPuntaje());
        assertEquals(0,jugador2.getPuntaje());
    }
    
    @Test
    public void test03CreoUnaPreguntaConPenalidadYEvaluo1JugadorCon1RespuestaCorrecta() {

        int puntajeEsperado = 1;
        Jugador primerJugador = new Jugador();

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("true");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("false");
        ArrayList<IRespuesta> respuestasPregunta = new ArrayList<>();
        respuestasPregunta.add(respuestaCorrecta);
        respuestasPregunta.add(respuestaIncorrecta);
        PreguntaVFConPenalidad pregunta = new PreguntaVFConPenalidad(respuestasPregunta);

        ArrayList<IRespuesta> respuestasPrimerJugador = new ArrayList<>();
        respuestasPrimerJugador.add(respuestaCorrecta);
        primerJugador.establecerRespuestas(respuestasPrimerJugador);


        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(primerJugador);      
        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntajeEsperado,primerJugador.getPuntaje());
    }

    @Test
    public void test04CreoUnaPreguntaConPenalidadYEvaluo2JugadoresConRespuestaCorrectaEInconrrecta() {
        
        int puntosGanados=4;
        Jugador primerJugador = new Jugador();
        Jugador segundoJugador= new Jugador();
        primerJugador.actualizarPuntaje(puntosGanados);
        segundoJugador.actualizarPuntaje(puntosGanados);
        
        
        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("true");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("false");
        ArrayList<IRespuesta> respuestasPregunta = new ArrayList<>();
        respuestasPregunta.add(respuestaCorrecta);
        respuestasPregunta.add(respuestaIncorrecta);
        PreguntaVFConPenalidad pregunta = new PreguntaVFConPenalidad(respuestasPregunta);

        ArrayList<IRespuesta> respuestasPrimerJugador = new ArrayList<>();
        respuestasPrimerJugador.add(respuestaCorrecta);
        primerJugador.establecerRespuestas(respuestasPrimerJugador);

        ArrayList<IRespuesta> respuestasSegundoJugador = new ArrayList<>();
        respuestasSegundoJugador.add(respuestaIncorrecta);
        segundoJugador.establecerRespuestas(respuestasSegundoJugador);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(primerJugador);
        jugadores.add(segundoJugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntosGanados+1,primerJugador.getPuntaje());
        assertEquals(puntosGanados-1,segundoJugador.getPuntaje());
    }
}
