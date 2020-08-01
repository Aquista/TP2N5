package edu.fiuba.algo3.modelo.PreguntaTests.PreguntaMCTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceConPenalidadTest {

    @Test
    public void test01CreoUnaPreguntaUnJugadorCon0PuntosQueContestaUnaOpcionBienYOtraMalTerminaCon0Puntos(){
        int puntajeEsperado = 0;

        Jugador jugador = new Jugador();
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto",new PuntajeConPenalidad());
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);
        
        ArrayList<Opcion> elegidas = new ArrayList<>();
        elegidas.add(op1);
        elegidas.add(op3);
        jugador.responderCon(elegidas, pregunta);

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
        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("texto",new PuntajeConPenalidad());
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);
        
        ArrayList<Opcion> elegidas = new ArrayList<>();
        elegidas.add(op1);
        elegidas.add(op2);
        jugador.responderCon(elegidas, pregunta);

        assertEquals(puntajeEsperado, jugador.puntos());
    }
}
