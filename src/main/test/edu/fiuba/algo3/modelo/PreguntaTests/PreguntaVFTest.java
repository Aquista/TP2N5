package edu.fiuba.algo3.modelo.PreguntaTests;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVFTest {

    @Test
    public void test01CreoUnaPreguntaClasicaYEvaluo1JugadorCon1RespuestaCorrecta() {
        int puntajeEsperado = 1;

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionCorrecta);
        PreguntaVF pregunta = new PreguntaVF(opciones);

        Jugador jugador = new Jugador();
        RespuestaVF respuesta=new RespuestaVF();
        respuesta.agregarOpcion(opcionCorrecta);
        jugador.establecerRespuestas(respuesta);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntajeEsperado,jugador.getPuntaje());
    }

    @Test
    public void test02CreoUnaPreguntaClasicaYEvaluo2Jugadores() {

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionCorrecta);
        PreguntaVF pregunta = new PreguntaVF(opciones);
        
        Jugador jugador1 = new Jugador();
        RespuestaVF respuesta1=new RespuestaVF();
        respuesta1.agregarOpcion(opcionCorrecta);
        jugador1.establecerRespuestas(respuesta1);
        

        Jugador jugador2 = new Jugador();
        RespuestaVF respuesta2=new RespuestaVF();
        respuesta2.agregarOpcion(opcionIncorrecta);
        jugador2.establecerRespuestas(respuesta2);

        ArrayList<Jugador> jugadores = new ArrayList<>();
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

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionCorrecta);
        PreguntaVFConPenalidad pregunta = new PreguntaVFConPenalidad(opciones);
        
        RespuestaVF respuesta1=new RespuestaVF();
        respuesta1.agregarOpcion(opcionCorrecta);
        primerJugador.establecerRespuestas(respuesta1);


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
        
        
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionCorrecta);
        PreguntaVFConPenalidad pregunta = new PreguntaVFConPenalidad(opciones);

        RespuestaVF respuesta1=new RespuestaVF();
        respuesta1.agregarOpcion(opcionCorrecta);
        primerJugador.establecerRespuestas(respuesta1);

        RespuestaVF respuesta2=new RespuestaVF();
        respuesta2.agregarOpcion(opcionIncorrecta);
        segundoJugador.establecerRespuestas(respuesta2);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(primerJugador);
        jugadores.add(segundoJugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntosGanados+1,primerJugador.getPuntaje());
        assertEquals(puntosGanados-1,segundoJugador.getPuntaje());
    }
}
