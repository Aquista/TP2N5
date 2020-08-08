package edu.fiuba.algo3.modelo.PreguntaTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionConOrden;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaOrderChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PreguntaOrderedChoiceTest {

    @Test

    public void test01JugadorCon0PuntosRespondeConOrdenCorrectoYSuma1Punto(){
        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        OpcionConOrden opcion1 = pregunta.agregarOpcion("Voy primero", 1);
        OpcionConOrden opcion2 = pregunta.agregarOpcion("Voy segundo", 2);
        OpcionConOrden opcion3 = pregunta.agregarOpcion("Voy tercero", 3);

        jugador.responderConOrden(opcion1.duplicar(), opcion2.duplicar(), opcion3.duplicar());

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(1, jugador.getPuntaje());

    }
    @Test
    public void test02JugadorCon0PuntosRespondeConOrdenIncorrectoYSuma0Puntos(){
        Jugador jugador = new Jugador();
        Jugador contrincante = new Jugador();

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        OpcionConOrden opcion1 = pregunta.agregarOpcion("Voy primero", 1);
        OpcionConOrden opcion2 = pregunta.agregarOpcion("Voy segundo", 2);
        OpcionConOrden opcion3 = pregunta.agregarOpcion("Voy tercero", 3);

        jugador.responderConOrden(opcion1.duplicar(), opcion3.duplicar(), opcion2.duplicar());

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void test03JugadoresCon0PuntosRespondenConOrdenIncorrectoYConOrdenCorrecto(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        OpcionConOrden opcion1 = pregunta.agregarOpcion("Voy primero", 1);
        OpcionConOrden opcion2 = pregunta.agregarOpcion("Voy segundo", 2);
        OpcionConOrden opcion3 = pregunta.agregarOpcion("Voy tercero", 3);

        jugador1.responderConOrden(opcion1.duplicar(), opcion3.duplicar(), opcion2.duplicar());
        jugador2.responderConOrden(opcion1.duplicar(),opcion2.duplicar(), opcion3.duplicar());

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void test04JugadoresCon0PuntosRespondenConOrdenCorrectoYConOrdenCorrecto(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        OpcionConOrden opcion1 = pregunta.agregarOpcion("Voy primero", 1);
        OpcionConOrden opcion2 = pregunta.agregarOpcion("Voy segundo", 2);
        OpcionConOrden opcion3 = pregunta.agregarOpcion("Voy tercero", 3);

        jugador1.responderConOrden(opcion1.duplicar(),opcion2.duplicar(), opcion3.duplicar());
        jugador2.responderConOrden(opcion1.duplicar(),opcion2.duplicar(), opcion3.duplicar());

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void test05JugadoresCon0PuntosRespondenConOrdenIncorrectoYConOrdenIncorrecto(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        OpcionConOrden opcion1 = pregunta.agregarOpcion("Voy primero", 1);
        OpcionConOrden opcion2 = pregunta.agregarOpcion("Voy segundo", 2);
        OpcionConOrden opcion3 = pregunta.agregarOpcion("Voy tercero", 3);

        jugador1.responderConOrden(opcion3.duplicar(), opcion2.duplicar(), opcion1.duplicar());
        jugador1.responderConOrden(opcion2.duplicar(), opcion3.duplicar(), opcion1.duplicar());

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }
}
