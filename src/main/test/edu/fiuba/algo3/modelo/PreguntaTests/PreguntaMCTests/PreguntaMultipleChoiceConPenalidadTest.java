package edu.fiuba.algo3.modelo.PreguntaTests.PreguntaMCTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaMultipleChoice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceConPenalidadTest {

    @Test
    public void test01CreoUnaPreguntaUnJugadorCon0PuntosQueContestaUnaOpcionBienYOtraMalTerminaCon0Puntos(){
        int puntajeEsperado = 0;

        Jugador jugador = new Jugador();
        Jugador segundoJugador = new Jugador();
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto",new PuntajeConPenalidad());
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        jugador.establecerRespuesta(new RespuestaMultipleChoice());
        jugador.responderCon(1, op1, op3);
        segundoJugador.establecerRespuesta(new RespuestaMultipleChoice());

        pregunta.evaluarJugadores(jugador, segundoJugador);

        assertEquals(puntajeEsperado, jugador.puntos());
    }

    @Test
    public void test02CreoUnaPreguntaUnJugadorCon10PuntosQueContesta2OpcionesBienTerminaCon12Puntos(){
        int puntajeInicial = 10;
        int puntajeEsperado = 12;

        Jugador jugador = new Jugador();
        Jugador segundoJugador = new Jugador();
        jugador.actualizarPuntaje(puntajeInicial);
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto",new PuntajeConPenalidad());
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);
        jugador.establecerRespuesta(new RespuestaMultipleChoice());
        jugador.responderCon(1, op1, op2);
        segundoJugador.establecerRespuesta(new RespuestaMultipleChoice());

        pregunta.evaluarJugadores(jugador, segundoJugador);

        assertEquals(puntajeEsperado, jugador.puntos());
    }
}
