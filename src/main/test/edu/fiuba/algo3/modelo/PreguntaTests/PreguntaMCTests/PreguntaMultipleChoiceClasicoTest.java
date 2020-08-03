package edu.fiuba.algo3.modelo.PreguntaTests.PreguntaMCTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Respuestas.RespuestaMultipleChoice;
import org.junit.jupiter.api.Test;

public class PreguntaMultipleChoiceClasicoTest {
    
    @Test
    public void test01JugadorCon0PuntosResponde1SolaOpcionCorrectaDe2YSigueTeniendo0puntos(){
        int puntajeEsperado = 0;

        Jugador jugador = new Jugador();
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto",new PuntajeClasico());
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        jugador.responderPreguntaCon(pregunta,1, op1);

        assertEquals(puntajeEsperado, jugador.puntos());
    }

    @Test
    public void test02JugadorCon0PuntosResponde3OpcionCorrectasDe3YSuma1punto(){
        int puntajeEsperado = 1;

        Jugador jugador = new Jugador();
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = new OpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = new OpcionIncorrecta("texto opcion 4");
        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto",new PuntajeClasico());
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionCorrecta(op3);
        pregunta.agregarOpcionIncorrecta(op4);

        jugador.responderPreguntaCon(pregunta,1, op1, op2, op3);

        assertEquals(puntajeEsperado, jugador.puntos());
    }
    
    @Test
    public void test03JugadorCon5PuntosResponde1OpcionIncorrectasDe1YNoSumaPuntos(){
        int puntosGanados = 5;

        Jugador jugador = new Jugador();
        jugador.actualizarPuntaje(puntosGanados);
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = new OpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = new OpcionIncorrecta("texto opcion 4");
        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto",new PuntajeClasico());
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionCorrecta(op3);
        pregunta.agregarOpcionIncorrecta(op4);

        jugador.responderPreguntaCon(pregunta,1, op4);

        assertEquals(puntosGanados, jugador.puntos());
    }
    
    @Test
    public void test04JugadoresCon5PuntosRespondenConOpcionesCorrectasCompletasYConOpcionIncorrectaGanan1Y0Puntos(){
        int puntosGanados = 5;

        Jugador primerJugador = new Jugador();
        Jugador segundoJugador = new Jugador();
        primerJugador.actualizarPuntaje(puntosGanados);
        segundoJugador.actualizarPuntaje(puntosGanados);
        
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = new OpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = new OpcionIncorrecta("texto opcion 4");
        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto",new PuntajeClasico());
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionCorrecta(op3);
        pregunta.agregarOpcionIncorrecta(op4);
        primerJugador.establecerRespuesta(new RespuestaMultipleChoice());
        primerJugador.responderCon(1, op1, op2, op3);
        segundoJugador.establecerRespuesta(new RespuestaMultipleChoice());
        segundoJugador.responderCon(1, op4);

        pregunta.evaluarJugadores(primerJugador,segundoJugador);

        assertEquals(puntosGanados+1, primerJugador.puntos());
        assertEquals(puntosGanados, segundoJugador.puntos());
    }
}
