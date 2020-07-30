package edu.fiuba.algo3.modelo.PreguntaTests.PreguntaVFTEsts;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVFClasico;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVFClasicoTest {

    @Test
    public void test01CreoUnaPreguntaClasicaYEvaluo1JugadorCon1RespuestaCorrecta() {
        int puntajeEsperado = 1;

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");

        PreguntaVFClasico pregunta = new PreguntaVFClasico("Soy una pregunta");
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);

        Jugador jugador = new Jugador();
        RespuestaVF respuesta = new RespuestaVF();
        respuesta.agregarOpcion(opcionCorrecta);
        jugador.establecerRespuesta(respuesta);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntajeEsperado,jugador.getPuntaje());
    }

    @Test
    public void test02CreoUnaPreguntaClasicaYEvaluo2Jugadores() {

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");

        PreguntaVFClasico pregunta = new PreguntaVFClasico("Soy una pregunta");
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

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(1,jugador1.getPuntaje());
        assertEquals(0,jugador2.getPuntaje());
    }
}
