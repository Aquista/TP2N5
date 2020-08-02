package edu.fiuba.algo3.modelo.PreguntaTests.PreguntaMCTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeParcial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceParcialTest {
    @Test
    public void test01CreoUnaPreguntaUnJugadorCon0PuntosQueContestaUnaOpcionBienYOtraMalTerminaCon0Puntos(){
        int puntajeEsperado = 0;

        Jugador jugador = new Jugador();
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("Soy unaa pregunta", new PuntajeParcial());
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        jugador.responderPreguntaCon(pregunta,0, op1, op3);

        assertEquals(puntajeEsperado, jugador.puntos());
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
        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("Soy unaa pregunta", new PuntajeParcial());
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        jugador.responderPreguntaCon(pregunta,0, op1, op2);

        assertEquals(puntajeEsperado, jugador.puntos());
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
        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("Soy unaa pregunta", new PuntajeParcial());
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionIncorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        jugador.responderPreguntaCon(pregunta,0, op1, op2);
      
        assertEquals(puntajeEsperado, jugador.puntos());
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
        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("Soy unaa pregunta", new PuntajeParcial());
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        jugador.responderPreguntaCon(pregunta,0, op1);

        assertEquals(puntajeEsperado, jugador.puntos());
    }
}
