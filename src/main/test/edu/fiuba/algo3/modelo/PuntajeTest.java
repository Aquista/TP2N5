package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PuntajeTest {
    
    @Test
    public void test01PuntajeClasicoAgrega1PuntoSiUnJugadorRespondeCorrectamente(){
        Jugador unJugador = new Jugador();

        RespuestaCorrecta resCorrecta = new RespuestaCorrecta("true");
        ArrayList<IRespuesta> respuestas = new ArrayList<IRespuesta>();
        respuestas.add(resCorrecta);
        unJugador.establecerRespuestas(respuestas);

        PuntajeClasico unPuntaje = new PuntajeClasico();
        unPuntaje.calcularPuntaje(unJugador);
        assertEquals(1,unJugador.getPuntaje());
    }
    @Test
    public void test02PuntajeClasicoNoSaca1PuntoSiUnJugadorRespondeIncorrectamente(){
        int puntosGanados=5;
        Jugador unJugador = new Jugador();
        unJugador.actualizarPuntaje(puntosGanados);
        RespuestaIncorrecta resIncorrecta = new RespuestaIncorrecta("false");
        ArrayList<IRespuesta> respuestas = new ArrayList<IRespuesta>();
        respuestas.add(resIncorrecta);
        unJugador.establecerRespuestas(respuestas);

        PuntajeClasico unPuntaje = new PuntajeClasico();
        unPuntaje.calcularPuntaje(unJugador);
        assertEquals(puntosGanados,unJugador.getPuntaje());
    }
    @Test
    public void test03PuntajeConPenalidadAgrega1PuntoSiUnJugadorRespondeCorrectamente(){
        Jugador unJugador = new Jugador(); 
        RespuestaCorrecta resCorrecta = new RespuestaCorrecta("true");
        ArrayList<IRespuesta> respuestas = new ArrayList<IRespuesta>();
        respuestas.add(resCorrecta);
        unJugador.establecerRespuestas(respuestas);
        PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();
        unPuntaje.calcularPuntaje(unJugador);
        assertEquals(1,unJugador.getPuntaje()); 
    }
    @Test
    public void test04PuntajeConPenalidadSaca1PuntoSiUnJugadorRespondeIncorrectamente(){
        int puntosGanados=5;
        Jugador unJugador = new Jugador();
        unJugador.actualizarPuntaje(puntosGanados);
        RespuestaIncorrecta resIncorrecta = new RespuestaIncorrecta("true");
        ArrayList<IRespuesta> respuestas = new ArrayList<IRespuesta>();
        respuestas.add(resIncorrecta);
        unJugador.establecerRespuestas(respuestas);
        PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();
        unPuntaje.calcularPuntaje(unJugador);
        assertEquals(puntosGanados-1,unJugador.getPuntaje()); 
    }
    
}
