package edu.fiuba.algo3.modelo.PreguntaTests.PreguntaMCTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoiceConPenalidad;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoiceParcial;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVFConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceParcialTest {
    @Test
    public void test01CreoUnaPreguntaUnJugadorCon0PuntosQueContestaUnaOpcionBienYOtraMalTerminaCon0Puntos(){
        int puntajeEsperado = 0;

        Jugador jugador = new Jugador();
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("Soy unaa pregunta");
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        RespuestaMultipleChoice resp = new RespuestaMultipleChoice();
        resp.agregarOpcion(op1);
        resp.agregarOpcion(op3);
        jugador.establecerRespuesta(resp);

        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }

    @Test
    public void test02CreoUnaPreguntaUnJugadorCon10PuntosQueContesta2OpcionesBienTerminaCon12Puntos(){
        int puntajeInicial = 10;
        int puntajeEsperado = 12;

        Jugador jugador = new Jugador();
        jugador.actualizarPuntaje(puntajeInicial);
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("Soy unaa pregunta");
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        RespuestaMultipleChoice resp = new RespuestaMultipleChoice();
        resp.agregarOpcion(op1);
        resp.agregarOpcion(op2);
        jugador.establecerRespuesta(resp);

        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }

    @Test
    public void test03CreoUnaPreguntaUnJugadorCon10PuntosQueContesta2OpcionesMalTerminaCon10Puntos(){
        int puntajeInicial = 10;
        int puntajeEsperado = 10;

        Jugador jugador = new Jugador();
        jugador.actualizarPuntaje(puntajeInicial);
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionIncorrecta op2 = new OpcionIncorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("Soy unaa pregunta");
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionIncorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        RespuestaMultipleChoice resp = new RespuestaMultipleChoice();
        resp.agregarOpcion(op1);
        resp.agregarOpcion(op2);
        jugador.establecerRespuesta(resp);

        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }

    @Test
    public void test04CreoUnaPreguntaConDosOpcionesCorrectasUnJugadorCon10PuntosQueContesta1OpcionBienTerminaCon11Puntos(){
        int puntajeInicial = 10;
        int puntajeEsperado = 11;

        Jugador jugador = new Jugador();
        jugador.actualizarPuntaje(puntajeInicial);
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial("Soy unaa pregunta");
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        RespuestaMultipleChoice resp = new RespuestaMultipleChoice();
        resp.agregarOpcion(op1);
        jugador.establecerRespuesta(resp);

        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }
}