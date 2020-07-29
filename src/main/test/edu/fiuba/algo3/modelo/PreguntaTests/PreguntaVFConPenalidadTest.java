package edu.fiuba.algo3.modelo.PreguntaTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVFConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVFConPenalidadTest {
    @Test
    public void test01CreoUnaPreguntaConPenalidadYEvaluo1JugadorCon1RespuestaCorrecta() {

        int puntajeEsperado = 1;
        Jugador primerJugador = new Jugador();

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");

        PreguntaVFConPenalidad pregunta = new PreguntaVFConPenalidad();
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);

        RespuestaVF respuesta1=new RespuestaVF();
        respuesta1.agregarOpcion(opcionCorrecta);
        primerJugador.establecerRespuestas(respuesta1);


        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(primerJugador);
        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntajeEsperado,primerJugador.getPuntaje());
    }

    @Test
    public void test02CreoUnaPreguntaConPenalidadYEvaluo2JugadoresConRespuestaCorrectaEInconrrecta() {

        int puntosGanados=4;
        Jugador primerJugador = new Jugador();
        Jugador segundoJugador= new Jugador();
        primerJugador.actualizarPuntaje(puntosGanados);
        segundoJugador.actualizarPuntaje(puntosGanados);


        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");

        PreguntaVFConPenalidad pregunta = new PreguntaVFConPenalidad();
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);

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
