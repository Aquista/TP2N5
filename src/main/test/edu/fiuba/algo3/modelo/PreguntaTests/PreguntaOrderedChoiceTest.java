package edu.fiuba.algo3.modelo.PreguntaTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.fiuba.algo3.modelo.Excepciones.CantidadInvalidaDeOpcionesException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionConOrden;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaOrderedChoice;
import org.junit.jupiter.api.Test;

public class PreguntaOrderedChoiceTest {

    @Test
    public void test01JugadorCon0PuntosRespondeConOrdenCorrectoYSuma1Punto(){
        Jugador jugador = new Jugador("J1");
        Jugador contrincante = new Jugador("J2");

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        try {
            OpcionConOrden opcion1 = pregunta.agregarOpcion("Voy primero", 1);
            OpcionConOrden opcion2 = pregunta.agregarOpcion("Voy segundo", 2);
            OpcionConOrden opcion3 = pregunta.agregarOpcion("Voy tercero", 3);

            jugador.responder(pregunta.tipo(), opcion1.duplicar(), opcion2.duplicar(), opcion3.duplicar());
        }
        catch (CantidadInvalidaDeOpcionesException e) {

        }

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(1, jugador.getPuntaje());

    }

    @Test
    public void test02JugadorCon0PuntosRespondeConOrdenIncorrectoYSuma0Puntos(){
        Jugador jugador = new Jugador("NOMBRE");
        Jugador contrincante = new Jugador("ASOI");

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        try {
            OpcionConOrden opcion1 = pregunta.agregarOpcion("Voy primero", 1);
            OpcionConOrden opcion2 = pregunta.agregarOpcion("Voy segundo", 2);
            OpcionConOrden opcion3 = pregunta.agregarOpcion("Voy tercero", 3);

            jugador.responder(pregunta.tipo(), opcion1.duplicar(), opcion3.duplicar(), opcion2.duplicar());
        }
        catch (CantidadInvalidaDeOpcionesException e) {

        }

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void test03JugadoresCon0PuntosRespondenConOrdenIncorrectoYConOrdenCorrecto(){
        Jugador jugador1 = new Jugador("ASD");
        Jugador jugador2 = new Jugador("ASDF");

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        try {
            OpcionConOrden opcion1 = pregunta.agregarOpcion("Voy primero", 1);
            OpcionConOrden opcion2 = pregunta.agregarOpcion("Voy segundo", 2);
            OpcionConOrden opcion3 = pregunta.agregarOpcion("Voy tercero", 3);

            jugador1.responder(pregunta.tipo(), opcion1.duplicar(), opcion3.duplicar(), opcion2.duplicar());
            jugador2.responder(pregunta.tipo(), opcion1.duplicar(),opcion2.duplicar(), opcion3.duplicar());
        }
        catch (CantidadInvalidaDeOpcionesException e) {

        }

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void test04JugadoresCon0PuntosRespondenConOrdenCorrectoYConOrdenCorrecto(){
        Jugador jugador1 = new Jugador("FAS");
        Jugador jugador2 = new Jugador("ASDF");

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        try {
            OpcionConOrden opcion1 = pregunta.agregarOpcion("Voy primero", 1);
            OpcionConOrden opcion2 = pregunta.agregarOpcion("Voy segundo", 2);
            OpcionConOrden opcion3 = pregunta.agregarOpcion("Voy tercero", 3);

            jugador1.responder(pregunta.tipo(), opcion1.duplicar(),opcion2.duplicar(), opcion3.duplicar());
            jugador2.responder(pregunta.tipo(), opcion1.duplicar(),opcion2.duplicar(), opcion3.duplicar());
        }
        catch (CantidadInvalidaDeOpcionesException e) {

        }

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void test05JugadoresCon0PuntosRespondenConOrdenIncorrectoYConOrdenIncorrecto(){
        Jugador jugador1 = new Jugador("ASFA");
        Jugador jugador2 = new Jugador("J2");

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        try {
            OpcionConOrden opcion1 = pregunta.agregarOpcion("Voy primero", 1);
            OpcionConOrden opcion2 = pregunta.agregarOpcion("Voy segundo", 2);
            OpcionConOrden opcion3 = pregunta.agregarOpcion("Voy tercero", 3);

            jugador1.responder(pregunta.tipo(), opcion3.duplicar(), opcion2.duplicar(), opcion1.duplicar());
            jugador1.responder(pregunta.tipo(), opcion2.duplicar(), opcion3.duplicar(), opcion1.duplicar());
        }
        catch (CantidadInvalidaDeOpcionesException e) {

        }

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }
    @Test
    public void test06JugadorRespondeConUnaOpcionNulaEntoncesNoSumaPuntos(){
        Jugador jugador = new Jugador("J1");
        Jugador contrincante = new Jugador("J2");

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        try {
            OpcionConOrden opcion1 = pregunta.agregarOpcion("Voy primero", 1);
            OpcionConOrden opcion2 = pregunta.agregarOpcion("Voy segundo", 2);
            OpcionConOrden opcion3 = pregunta.agregarOpcion("Voy tercero", 3);

            jugador.responder(pregunta.tipo(), null);
        }
        catch (CantidadInvalidaDeOpcionesException e) {

        }

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void test07PreguntaOrderedChoiceConMasDe5OpcionesTiraExcepcion(){
        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        try {
            OpcionConOrden opcion1 = pregunta.agregarOpcion("Voy primero", 1);
            OpcionConOrden opcion2 = pregunta.agregarOpcion("Voy segundo", 2);
            OpcionConOrden opcion3 = pregunta.agregarOpcion("Voy tercero", 3);
            OpcionConOrden opcion4 = pregunta.agregarOpcion("Voy cuarto", 4);
            OpcionConOrden opcion5 = pregunta.agregarOpcion("Voy quinto", 5);

        }
        catch (CantidadInvalidaDeOpcionesException e) {}

        assertThrows(CantidadInvalidaDeOpcionesException.class,
                ()-> {
                    OpcionConOrden opcion6 = pregunta.agregarOpcion("opcion6",6);
                });
    }
}
