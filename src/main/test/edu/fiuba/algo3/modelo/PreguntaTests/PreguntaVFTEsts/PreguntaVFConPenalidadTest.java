package edu.fiuba.algo3.modelo.PreguntaTests.PreguntaVFTEsts;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVFConPenalidadTest {
    @Test
    public void test01CreoUnaPreguntaConPenalidadYEvaluo1JugadorCon1RespuestaCorrecta() {

        int puntajeEsperado = 1;
        Jugador primerJugador = new Jugador();

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta",new PuntajeConPenalidad());
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);

        primerJugador.responderPreguntaCon(pregunta,1, opcionCorrecta);

        assertEquals(puntajeEsperado, primerJugador.puntos());
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

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta",new PuntajeConPenalidad());
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);
        
        
        primerJugador.responderPreguntaCon(pregunta,1,opcionCorrecta);
        segundoJugador.responderPreguntaCon(pregunta,1,opcionIncorrecta);

        assertEquals(puntosGanados + 1, primerJugador.puntos());
        assertEquals(puntosGanados - 1, segundoJugador.puntos());
    }
    @Test
    public void test03CreoUnaPreguntaConPenalidadYEvaluo1JugadorCon1RespuestaCorrectaYMultiplicadorx2() {

        int puntajeEsperado = 1;
        Jugador primerJugador = new Jugador();

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta",new PuntajeConPenalidad());
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);
        
        primerJugador.responderPreguntaCon(pregunta,2, opcionCorrecta);
        
        assertEquals(puntajeEsperado*2, primerJugador.puntos());
    }
    @Test
    public void test04CreoUnaPreguntaConPenalidadYEvaluo2JugadoresConRespuestaCorrectaUnoConMutiplicadorx2() {

        int puntosGanados=4;
        Jugador primerJugador = new Jugador();
        Jugador segundoJugador= new Jugador();
        primerJugador.actualizarPuntaje(puntosGanados);
        segundoJugador.actualizarPuntaje(puntosGanados);


        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("false");

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta",new PuntajeConPenalidad());
        pregunta.agregarOpcionCorrecta(opcionCorrecta);
        pregunta.agregarOpcionIncorrecta(opcionIncorrecta);
        
        primerJugador.responderPreguntaCon(pregunta,2,opcionCorrecta);
        segundoJugador.responderPreguntaCon(pregunta,1, opcionIncorrecta);

        assertEquals(puntosGanados + 2, primerJugador.puntos());
        assertEquals(puntosGanados - 1, segundoJugador.puntos());
    }
}
