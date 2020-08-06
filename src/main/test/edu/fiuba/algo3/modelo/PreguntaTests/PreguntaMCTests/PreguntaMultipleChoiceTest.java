package edu.fiuba.algo3.modelo.PreguntaTests.PreguntaMCTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeParcial;
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

        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PuntajeClasico puntaje = new PuntajeClasico();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        RespuestaMultipleChoice resp = new RespuestaMultipleChoice();
        resp.agregarOpcion(op1);
        jugador.establecerRespuesta(resp);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }

    @Test
    public void test02JugadorCon0PuntosResponde3OpcionCorrectasDe3YSuma1punto(){
        int puntajeEsperado = 1;

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = new OpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = new OpcionIncorrecta("texto opcion 4");
        PuntajeClasico puntaje = new PuntajeClasico();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionCorrecta(op3);
        pregunta.agregarOpcionIncorrecta(op4);

        RespuestaMultipleChoice resp = new RespuestaMultipleChoice();
        resp.agregarOpcion(op1);
        resp.agregarOpcion(op2);
        resp.agregarOpcion(op3);
        jugador.establecerRespuesta(resp);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }
    
    @Test
    public void test03JugadorCon5PuntosResponde1OpcionIncorrectasDe1YNoSumaPuntos(){
        int puntajeEsperado = 5;

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        jugador.actualizarPuntaje(puntajeEsperado);
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = new OpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = new OpcionIncorrecta("texto opcion 4");
        PuntajeClasico puntaje = new PuntajeClasico();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionCorrecta(op3);
        pregunta.agregarOpcionIncorrecta(op4);

        RespuestaMultipleChoice resp = new RespuestaMultipleChoice();
        resp.agregarOpcion(op4);
        jugador.establecerRespuesta(resp);

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
        
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = new OpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = new OpcionIncorrecta("texto opcion 4");
        PuntajeClasico puntaje = new PuntajeClasico();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionCorrecta(op3);
        pregunta.agregarOpcionIncorrecta(op4);

        RespuestaMultipleChoice resp1 = new RespuestaMultipleChoice();
        resp1.agregarOpcion(op1);
        resp1.agregarOpcion(op2);
        resp1.agregarOpcion(op3);
        primerJugador.establecerRespuesta(resp1);

        RespuestaMultipleChoice resp2 = new RespuestaMultipleChoice();
        resp2.agregarOpcion(op4);
        segundoJugador.establecerRespuesta(resp2);

        pregunta.evaluarJugadores(primerJugador, segundoJugador);

        assertEquals(puntajeEsperado + 1, primerJugador.getPuntaje());
        assertEquals(puntajeEsperado, segundoJugador.getPuntaje());
    }

    @Test
    public void test05JugadorCon0PuntosResponde2BienYUnaMalYGana1PuntoEnPreguntaConPenalidad(){
        int puntajeEsperado = 1;

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PuntajeConPenalidad puntaje = new PuntajeConPenalidad();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        RespuestaMultipleChoice resp = new RespuestaMultipleChoice();
        resp.agregarOpcion(op1);
        resp.agregarOpcion(op2);
        resp.agregarOpcion(op3);
        jugador.establecerRespuesta(resp);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }

    @Test
    public void test06JugadorCon5PuntosResponde2MalYPierde2PuntosEnPreguntaConPenalidad(){
        int puntajeEsperado = 3;

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();
        jugador.actualizarPuntaje(5);


        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionIncorrecta op2 = new OpcionIncorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PuntajeConPenalidad puntaje = new PuntajeConPenalidad();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionIncorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        RespuestaMultipleChoice resp = new RespuestaMultipleChoice();
        resp.agregarOpcion(op2);
        resp.agregarOpcion(op3);
        jugador.establecerRespuesta(resp);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }

    @Test
    public void test07JugadorCon0PuntosResponde2De3BienYNingunaMalYSuma2PuntosConPuntajeParcial(){
        int puntajeEsperado = 2;

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = new OpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = new OpcionIncorrecta("texto opcion 4");
        OpcionIncorrecta op5 = new OpcionIncorrecta("texto opcion 5");
        PuntajeParcial puntaje = new PuntajeParcial();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionCorrecta(op3);
        pregunta.agregarOpcionIncorrecta(op4);
        pregunta.agregarOpcionIncorrecta(op5);

        RespuestaMultipleChoice resp = new RespuestaMultipleChoice();
        resp.agregarOpcion(op2);
        resp.agregarOpcion(op3);
        jugador.establecerRespuesta(resp);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }

    @Test
    public void test08JugadorCon0PuntosResponde2De3BienY1MalYSuma0PuntosConPuntajeParcial(){
        int puntajeEsperado = 0;

        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = new OpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = new OpcionIncorrecta("texto opcion 4");
        OpcionIncorrecta op5 = new OpcionIncorrecta("texto opcion 5");
        PuntajeParcial puntaje = new PuntajeParcial();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionCorrecta(op3);
        pregunta.agregarOpcionIncorrecta(op4);
        pregunta.agregarOpcionIncorrecta(op5);

        RespuestaMultipleChoice resp = new RespuestaMultipleChoice();
        resp.agregarOpcion(op2);
        resp.agregarOpcion(op3);
        resp.agregarOpcion(op4);
        jugador.establecerRespuesta(resp);

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }

    @Test
    public void test09UnJugadorResponde2BienConExclusividadYSuma4PuntosEnPuntajeParcial(){
        int puntajeEsperado = 4;

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = new OpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = new OpcionIncorrecta("texto opcion 4");
        OpcionIncorrecta op5 = new OpcionIncorrecta("texto opcion 5");
        PuntajeParcial puntaje = new PuntajeParcial();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionCorrecta(op3);
        pregunta.agregarOpcionIncorrecta(op4);
        pregunta.agregarOpcionIncorrecta(op5);

        RespuestaMultipleChoice resp1 = new RespuestaMultipleChoice();
        resp1.agregarOpcion(op2);
        resp1.agregarOpcion(op3);
        jugador1.establecerRespuesta(resp1);
        jugador1.seleccionarExclusividad(0);

        RespuestaMultipleChoice resp2 = new RespuestaMultipleChoice();
        resp2.agregarOpcion(op4);
        jugador2.establecerRespuesta(resp2);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeEsperado, jugador1.getPuntaje());
    }
    @Test
    public void test10UnJugadorResponde2BienMientrasAmbosSeleccionanExclusividadYSuma8PuntosEnPuntajeParcial(){
        int puntajeEsperado = 8;

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = new OpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = new OpcionIncorrecta("texto opcion 4");
        OpcionIncorrecta op5 = new OpcionIncorrecta("texto opcion 5");
        PuntajeParcial puntaje = new PuntajeParcial();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionCorrecta(op3);
        pregunta.agregarOpcionIncorrecta(op4);
        pregunta.agregarOpcionIncorrecta(op5);

        RespuestaMultipleChoice resp1 = new RespuestaMultipleChoice();
        resp1.agregarOpcion(op2);
        resp1.agregarOpcion(op3);
        jugador1.establecerRespuesta(resp1);
        jugador1.seleccionarExclusividad(0);

        RespuestaMultipleChoice resp2 = new RespuestaMultipleChoice();
        resp2.agregarOpcion(op4);
        jugador2.establecerRespuesta(resp2);
        jugador2.seleccionarExclusividad(0);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeEsperado, jugador1.getPuntaje());
    }
    @Test
    public void test11AmbosJugadoresRespondenBienConExclusividadYSuman1PuntoEnPuntajeClasico(){
        int puntajeEsperado = 1;

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PuntajeClasico puntaje = new PuntajeClasico();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        RespuestaMultipleChoice resp1 = new RespuestaMultipleChoice();
        resp1.agregarOpcion(op1);
        resp1.agregarOpcion(op2);
        jugador1.establecerRespuesta(resp1);
        jugador1.seleccionarExclusividad(0);

        RespuestaMultipleChoice resp2 = new RespuestaMultipleChoice();
        resp2.agregarOpcion(op1);
        resp2.agregarOpcion(op2);
        jugador2.establecerRespuesta(resp2);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeEsperado, jugador1.getPuntaje());
        assertEquals(puntajeEsperado, jugador2.getPuntaje());
    }
    /*@Test
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
    public void test12UnJugadorRespondeBienYElOtroMalConExclusividadYSuma2PuntosEnPuntajeClasico(){
        int puntajeJugador1Esperado = 2;
        int puntajeJugador2Esperado = 0;

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PuntajeClasico puntaje = new PuntajeClasico();

        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto", puntaje);
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        RespuestaMultipleChoice resp1 = new RespuestaMultipleChoice();
        resp1.agregarOpcion(op1);
        resp1.agregarOpcion(op2);
        jugador1.establecerRespuesta(resp1);
        jugador1.seleccionarExclusividad(0);

        RespuestaMultipleChoice resp2 = new RespuestaMultipleChoice();
        resp2.agregarOpcion(op1);
        jugador2.establecerRespuesta(resp2);

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(puntajeJugador1Esperado, jugador1.getPuntaje());
        assertEquals(puntajeJugador2Esperado, jugador2.getPuntaje());
    }

}
