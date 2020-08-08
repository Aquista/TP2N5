package edu.fiuba.algo3.modelo.PreguntaTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeParcial;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaMultipleChoice;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PreguntaMultipleChoiceTest {
    
    @Test
    public void test01JugadorCon0PuntosResponde1SolaOpcionCorrectaDe2YSigueTeniendo0puntos(){
        int puntajeEsperado = 0;

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", new PuntajeClasico());
        OpcionCorrecta op1 = pregunta.agregarOpcionCorrecta("opcion 1");
        OpcionCorrecta op2 = pregunta.agregarOpcionCorrecta("opcion 2");
        OpcionIncorrecta op3 = pregunta.agregarOpcionIncorrecta("opcion 3");

        jugador.responderMultipleChoice(op1);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }

    /*
    @Test
    public void test11AmbosJugadoresRespondenBienConExclusividadYSuman1PuntoEnPuntajeClasico2(){
        int puntajeEsperado = 1;

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PuntajeClasico puntaje = new PuntajeClasico();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("cual es un numero", puntaje);
        OpcionCorrecta op1 = pregunta.agregarOpcionCorrecta("nueve");
        OpcionCorrecta op2 = pregunta.agregarOpcionCorrecta("ocho");
        OpcionIncorrecta op3 = pregunta.agregarOpcionIncorrecta("calculadora");

        //RespuestaMultipleChoice resp1 = new RespuestaMultipleChoice(op1,op2);
        RespuestaMultipleChoice resp1 = new RespuestaMultipleChoice(pregunta,"nueve","ocho");
        jugador1.establecerRespuesta(resp1);
        jugador1.seleccionarExclusividad(0);

        RespuestaMultipleChoice resp2 = new RespuestaMultipleChoice();
        resp2.agregarOpcion(op1);
        resp2.agregarOpcion(op2);
        jugador2.establecerRespuesta(resp2);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeEsperado, jugador1.getPuntaje());
        assertEquals(puntajeEsperado, jugador2.getPuntaje());
    }*/

    @Test
    public void test02JugadorCon0PuntosResponde3OpcionCorrectasDe3YSuma1punto(){
        int puntajeEsperado = 1;

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", new PuntajeClasico());
        OpcionCorrecta op1 = pregunta.agregarOpcionCorrecta("opcion 1");
        OpcionCorrecta op2 = pregunta.agregarOpcionCorrecta("opcion 2");
        OpcionCorrecta op3 = pregunta.agregarOpcionCorrecta("opcion 3");
        OpcionIncorrecta op4 = pregunta.agregarOpcionIncorrecta("opcion 4");

        jugador.responderMultipleChoice(op1, op2, op3);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }
    
    @Test
    public void test03JugadorCon5PuntosResponde1OpcionIncorrectasDe1YNoSumaPuntos(){
        int puntajeEsperado = 5;

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();
        jugador.actualizarPuntaje(puntajeEsperado);

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", new PuntajeClasico());
        OpcionCorrecta op1 = pregunta.agregarOpcionCorrecta("opcion 1");
        OpcionCorrecta op2 = pregunta.agregarOpcionCorrecta("opcion 2");
        OpcionCorrecta op3 = pregunta.agregarOpcionCorrecta("opcion 3");
        OpcionIncorrecta op4 = pregunta.agregarOpcionIncorrecta("opcion 4");

        jugador.responderMultipleChoice(op4);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }
    
    @Test
    public void test04JugadoresCon5PuntosRespondenConOpcionesCorrectasCompletasYConOpcionIncorrectaGanan1Y0Puntos(){
        int puntajeEsperado = 5;

        Jugador primerJugador = new Jugador();
        Jugador segundoJugador = new Jugador();
        primerJugador.actualizarPuntaje(puntajeEsperado);
        segundoJugador.actualizarPuntaje(puntajeEsperado);

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", new PuntajeClasico());
        OpcionCorrecta op1 = pregunta.agregarOpcionCorrecta("opcion 1");
        OpcionCorrecta op2 = pregunta.agregarOpcionCorrecta("opcion 2");
        OpcionCorrecta op3 = pregunta.agregarOpcionCorrecta("opcion 3");
        OpcionIncorrecta op4 = pregunta.agregarOpcionIncorrecta("opcion 4");

        primerJugador.responderMultipleChoice(op1, op2, op3);
        segundoJugador.responderMultipleChoice(op4);

        pregunta.evaluarJugadores(primerJugador, segundoJugador);

        assertEquals(puntajeEsperado + 1, primerJugador.getPuntaje());
        assertEquals(puntajeEsperado, segundoJugador.getPuntaje());
    }

    @Test
    public void test05JugadorCon0PuntosResponde2BienYUnaMalYGana1PuntoEnPreguntaConPenalidad(){
        int puntajeEsperado = 1;

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", new PuntajeConPenalidad());
        OpcionCorrecta op1 = pregunta.agregarOpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = pregunta.agregarOpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = pregunta.agregarOpcionIncorrecta("texto opcion 3");

        jugador.responderMultipleChoice(op1, op2, op3);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }

    @Test
    public void test06JugadorCon5PuntosResponde2MalYPierde2PuntosEnPreguntaConPenalidad(){
        int puntajeEsperado = 3;

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();
        jugador.actualizarPuntaje(5);

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", new PuntajeConPenalidad());
        OpcionCorrecta op1 = pregunta.agregarOpcionCorrecta("texto opcion 1");
        OpcionIncorrecta op2 = pregunta.agregarOpcionIncorrecta("texto opcion 2");
        OpcionIncorrecta op3 = pregunta.agregarOpcionIncorrecta("texto opcion 3");

        jugador.responderMultipleChoice(op2, op3);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }

    @Test
    public void test07JugadorCon0PuntosResponde2De3BienYNingunaMalYSuma2PuntosConPuntajeParcial(){
        int puntajeEsperado = 2;

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", new PuntajeParcial());
        OpcionCorrecta op1 = pregunta.agregarOpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = pregunta.agregarOpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = pregunta.agregarOpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = pregunta.agregarOpcionIncorrecta("texto opcion 4");
        OpcionIncorrecta op5 = pregunta.agregarOpcionIncorrecta("texto opcion 5");

        jugador.responderMultipleChoice(op2, op3);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }

    @Test
    public void test08JugadorCon0PuntosResponde2De3BienY1MalYSuma0PuntosConPuntajeParcial(){
        int puntajeEsperado = 0;

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", new PuntajeParcial());
        OpcionCorrecta op1 = pregunta.agregarOpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = pregunta.agregarOpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = pregunta.agregarOpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = pregunta.agregarOpcionIncorrecta("texto opcion 4");
        OpcionIncorrecta op5 = pregunta.agregarOpcionIncorrecta("texto opcion 5");

        jugador.responderMultipleChoice(op2, op3, op4);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }

    @Test
    public void test09UnJugadorResponde2BienConExclusividadYSuma4PuntosEnPuntajeParcial(){
        int puntajeEsperado = 4;

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", new PuntajeParcial());
        OpcionCorrecta op1 = pregunta.agregarOpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 =  pregunta.agregarOpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 =  pregunta.agregarOpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 =  pregunta.agregarOpcionIncorrecta("texto opcion 4");
        OpcionIncorrecta op5 =  pregunta.agregarOpcionIncorrecta("texto opcion 5");

        jugador1.responderMultipleChoice(op2, op3);
        jugador1.seleccionarExclusividad(0);
        jugador2.responderMultipleChoice(op4);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeEsperado, jugador1.getPuntaje());
    }
    @Test
    public void test10UnJugadorResponde2BienMientrasAmbosSeleccionanExclusividadYSuma8PuntosEnPuntajeParcial(){
        int puntajeEsperado = 8;

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", new PuntajeParcial());
        OpcionCorrecta op1 = pregunta.agregarOpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = pregunta.agregarOpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = pregunta.agregarOpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = pregunta.agregarOpcionIncorrecta("texto opcion 4");
        OpcionIncorrecta op5 = pregunta.agregarOpcionIncorrecta("texto opcion 5");

        jugador1.responderMultipleChoice(op2, op3);
        jugador1.seleccionarExclusividad(0);
        jugador2.responderMultipleChoice(op4);
        jugador2.seleccionarExclusividad(0);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeEsperado, jugador1.getPuntaje());
    }
    @Test
    public void test11AmbosJugadoresRespondenBienConExclusividadYSuman1PuntoEnPuntajeClasico(){
        int puntajeEsperado = 1;

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", new PuntajeClasico());
        OpcionCorrecta op1 = pregunta.agregarOpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = pregunta.agregarOpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = pregunta.agregarOpcionIncorrecta("texto opcion 3");

        jugador1.responderMultipleChoice(op1, op2);
        jugador1.seleccionarExclusividad(0);
        jugador2.responderMultipleChoice(op1, op2);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeEsperado, jugador1.getPuntaje());
        assertEquals(puntajeEsperado, jugador2.getPuntaje());
    }


    @Test
    public void test12UnJugadorRespondeBienYElOtroMalConExclusividadYSuma2PuntosEnPuntajeClasico(){
        int puntajeJugador1Esperado = 2;
        int puntajeJugador2Esperado = 0;

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", new PuntajeClasico());
        OpcionCorrecta op1 = pregunta.agregarOpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = pregunta.agregarOpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = pregunta.agregarOpcionIncorrecta("texto opcion 3");

        jugador1.responderMultipleChoice(op1, op2);
        jugador1.seleccionarExclusividad(0);

        jugador2.responderMultipleChoice(op1);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeJugador1Esperado, jugador1.getPuntaje());
        assertEquals(puntajeJugador2Esperado, jugador2.getPuntaje());
    }

}
