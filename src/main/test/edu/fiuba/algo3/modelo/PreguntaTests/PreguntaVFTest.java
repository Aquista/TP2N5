package edu.fiuba.algo3.modelo.PreguntaTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modificadores.ExclusividadSimple;
import edu.fiuba.algo3.modelo.Modificadores.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Modificadores.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVFTest {

    @Test
    public void test01CreoUnaPreguntaClasicaYEvaluo1JugadorCon1RespuestaCorrecta() {
        int puntajeEsperado = 1;

        Jugador jugador = new Jugador("SAFKIH");
        Jugador contrincante = new Jugador("HAMOOD");

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta", new PuntajeClasico());
        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        jugador.responder(pregunta.tipo(), opcionCorrecta);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado,jugador.getPuntaje());
    }

    @Test
    public void test02CreoUnaPreguntaClasicaYEvaluo2Jugadores() {

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta", new PuntajeClasico());

        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        Jugador jugador1 = new Jugador("ASOD");
        Jugador jugador2 = new Jugador("DGSA");
        jugador1.responder(pregunta.tipo(), opcionCorrecta);
        jugador2.responder(pregunta.tipo(), opcionIncorrecta);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(1,jugador1.getPuntaje());
        assertEquals(0,jugador2.getPuntaje());
    }
    @Test
    public void test03CreoUnaPreguntaConPenalidadYEvaluo1JugadorCon1RespuestaCorrectaYMultiplicadorX3() {
        int puntajeEsperado = 3;

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta", new PuntajeConPenalidad());
        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        Jugador jugador = new Jugador("ASDASD");
        Jugador contrincante = new Jugador("GFSS");

        jugador.responder(pregunta.tipo(), opcionCorrecta);
        jugador.seleccionarMultiplicador(new MultiplicadorX3());
        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado,jugador.getPuntaje());
    }

    @Test
    public void test04CreoUnaPreguntaConPenalidadYEvaluo1JugadorCon1RespuestaCorrectaYMultiplicadorX2() {
        int puntajeEsperado = 2;

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta", new PuntajeConPenalidad());
        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        Jugador jugador = new Jugador("DAFG");
        Jugador contrincante = new Jugador("AGF");

        jugador.responder(pregunta.tipo(), opcionCorrecta);
        jugador.seleccionarMultiplicador(new MultiplicadorX2());

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado,jugador.getPuntaje());
    }

    @Test
    public void test05UnJugadorRespondeBienYElOtroMalConExclusividadYSuma2PuntosYElOtro0EnPuntajeClasico(){
        int puntajeJugador1Esperado = 2;
        int puntajeJugador2Esperado = 0;

        Jugador jugador1 = new Jugador("NO SE");
        Jugador jugador2 = new Jugador("JR10");

        PreguntaVF pregunta = new PreguntaVF("texto", new PuntajeClasico());
        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        jugador1.responder(pregunta.tipo(), opcionCorrecta);
        jugador1.seleccionarExclusividad(new ExclusividadSimple());
        jugador2.responder(pregunta.tipo(), opcionIncorrecta);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeJugador1Esperado, jugador1.getPuntaje());
        assertEquals(puntajeJugador2Esperado, jugador2.getPuntaje());
    }

    @Test
    public void test06UnJugadorRespondeBienYElOtroMalCon2ExclusividadYSuma4PuntosYElOtro0EnPuntajeClasico(){
        int puntajeJugador1Esperado = 4;
        int puntajeJugador2Esperado = 0;

        Jugador jugador1 = new Jugador("RASDFASFE");
        Jugador jugador2 = new Jugador("SADAS");

        PreguntaVF pregunta = new PreguntaVF("texto", new PuntajeClasico());
        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        jugador1.responder(pregunta.tipo(), opcionCorrecta);
        jugador1.seleccionarExclusividad(new ExclusividadSimple());
        jugador2.responder(pregunta.tipo(), opcionIncorrecta);
        jugador2.seleccionarExclusividad(new ExclusividadSimple());

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeJugador1Esperado, jugador1.getPuntaje());
        assertEquals(puntajeJugador2Esperado, jugador2.getPuntaje());
    }

    @Test
    public void test07UnJugadorRespondeBienYElOtroBienCon2ExclusividadYSuma1PuntoCadaUnoEnPuntajeClasico(){
        int puntajeJugador1Esperado = 1;
        int puntajeJugador2Esperado = 1;

        Jugador jugador1 = new Jugador("SDSAF");
        Jugador jugador2 = new Jugador("HGSGFH");

        PreguntaVF pregunta = new PreguntaVF("texto", new PuntajeClasico());
        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        jugador1.responder(pregunta.tipo(), opcionCorrecta);
        jugador1.seleccionarExclusividad(new ExclusividadSimple());
        jugador2.responder(pregunta.tipo(), opcionCorrecta);
        jugador2.seleccionarExclusividad(new ExclusividadSimple());

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeJugador1Esperado, jugador1.getPuntaje());
        assertEquals(puntajeJugador2Esperado, jugador2.getPuntaje());
    }

    @Test
    public void test08CreoUnaPreguntaClasicaUnJugadorRespondeConNullYRecibe0Puntos() {
        int puntajeEsperado = 0;

        Jugador jugador = new Jugador("SAFKIH");
        Jugador contrincante = new Jugador("HAMOOD");

        PreguntaVF pregunta = new PreguntaVF("Soy una pregunta", new PuntajeClasico());
        OpcionCorrecta opcionCorrecta = pregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = pregunta.agregarOpcionIncorrecta("false");

        jugador.responder(pregunta.tipo(), null);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado,jugador.getPuntaje());
    }
    
}
