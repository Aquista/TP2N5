package edu.fiuba.algo3.modelo.PreguntaTests;

import edu.fiuba.algo3.modelo.Excepciones.CantidadInvalidaDeOpcionesException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaGroupChoice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PreguntaGroupChoiceTest {

    @Test
    public void test01JugadorCon0PuntosRespondeBienYSuma1Punto(){

        Jugador jugador = new Jugador("J1");
        Jugador contrincante = new Jugador("J2");

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("hola");
        try {
            OpcionConGrupo opcion1 = pregunta.agregarOpcion("Soy del grupo 1", 1);
            OpcionConGrupo opcion2 = pregunta.agregarOpcion("Soy del grupo 2", 2);
            OpcionConGrupo opcion3 = pregunta.agregarOpcion("Soy del grupo 1", 1);

            jugador.responder(pregunta.tipo(), opcion1.duplicar(1), opcion2.duplicar(2), opcion3.duplicar(1));
        } catch(CantidadInvalidaDeOpcionesException e) {}

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(1, jugador.getPuntaje());
    }

    @Test
    public void test02JugadorCon0PuntosRespondeMalYSuma0Puntos(){
        Jugador jugador = new Jugador("J1");
        Jugador contrincante = new Jugador("J2");

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("hola");
        try {
            OpcionConGrupo opcion1 = pregunta.agregarOpcion("Soy del grupo 1", 1);
            OpcionConGrupo opcion2 = pregunta.agregarOpcion("Soy del grupo 2", 2);
            OpcionConGrupo opcion3 = pregunta.agregarOpcion("Soy del grupo 1", 1);

            jugador.responder(pregunta.tipo(), opcion1.duplicar(2), opcion2.duplicar(2), opcion3.duplicar(1));

        } catch(CantidadInvalidaDeOpcionesException e) {}

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void test03JugadoresCon0PuntosRespondenBienYMal(){
        Jugador jugador1 = new Jugador("J1");
        Jugador jugador2 = new Jugador("J2");

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("hola");
        try {
            OpcionConGrupo opcion1 = pregunta.agregarOpcion("Soy del grupo 1", 1);
            OpcionConGrupo opcion2 = pregunta.agregarOpcion("Soy del grupo 2", 2);
            OpcionConGrupo opcion3 = pregunta.agregarOpcion("Soy del grupo 1", 1);

            jugador1.responder(pregunta.tipo(), opcion1.duplicar(1), opcion2.duplicar(2), opcion3.duplicar(1));
            jugador2.responder(pregunta.tipo(), opcion1.duplicar(2), opcion2.duplicar(2), opcion3.duplicar(2));

        } catch(CantidadInvalidaDeOpcionesException e) {}

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

    @Test
    public void test04JugadoresCon0PuntosRespondenBienAmbos(){
        Jugador jugador1 = new Jugador("J1");
        Jugador jugador2 = new Jugador("J2");

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("hola");
        try {
            OpcionConGrupo opcion1 = pregunta.agregarOpcion("Soy del grupo 1", 1);
            OpcionConGrupo opcion2 = pregunta.agregarOpcion("Soy del grupo 2", 2);
            OpcionConGrupo opcion3 = pregunta.agregarOpcion("Soy del grupo 1", 1);

            jugador1.responder(pregunta.tipo(), opcion1.duplicar(1), opcion2.duplicar(2), opcion3.duplicar(1));
            jugador2.responder(pregunta.tipo(), opcion1.duplicar(1), opcion2.duplicar(2), opcion3.duplicar(1));

        } catch(CantidadInvalidaDeOpcionesException e) {}

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void test05JugadoresCon0PuntosRespondenMalAmbos(){
        Jugador jugador1 = new Jugador("J1");
        Jugador jugador2 = new Jugador("J2");

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("hola");
        try {
            OpcionConGrupo opcion1 = pregunta.agregarOpcion("Soy del grupo 1", 1);
            OpcionConGrupo opcion2 = pregunta.agregarOpcion("Soy del grupo 2", 2);
            OpcionConGrupo opcion3 = pregunta.agregarOpcion("Soy del grupo 1", 1);

            jugador1.responder(pregunta.tipo(), opcion1.duplicar(2), opcion2.duplicar(2), opcion3.duplicar(1));
            jugador2.responder(pregunta.tipo(), opcion1.duplicar(1), opcion2.duplicar(1), opcion3.duplicar(1));

        } catch(CantidadInvalidaDeOpcionesException e) {}

        pregunta.evaluarJugadores(jugador1, jugador2);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

    @Test
    public void test06JugadorRespondeConUnaOpcionNulaEntoncesNoSumaPuntos(){

        Jugador jugador = new Jugador("J1");
        Jugador contrincante = new Jugador("J2");

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("hola");
        try {
            OpcionConGrupo opcion1 = pregunta.agregarOpcion("Soy del grupo 1", 1);
            OpcionConGrupo opcion2 = pregunta.agregarOpcion("Soy del grupo 2", 2);
            OpcionConGrupo opcion3 = pregunta.agregarOpcion("Soy del grupo 1", 1);

            jugador.responder(pregunta.tipo(), null);

        } catch(CantidadInvalidaDeOpcionesException e) {}

        pregunta.evaluarJugadores(jugador, contrincante);

        assertEquals(0, jugador.getPuntaje());
    }
    @Test
    public void test07PreguntaConMasDe7OpcionesArrojaExcepcion(){

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("hola");
        try {
            OpcionConGrupo opcion1 = pregunta.agregarOpcion("Soy del grupo 1", 1);
            OpcionConGrupo opcion2 = pregunta.agregarOpcion("Soy del grupo 2", 2);
            OpcionConGrupo opcion3 = pregunta.agregarOpcion("Soy del grupo 1", 1);
            OpcionConGrupo opcion4 = pregunta.agregarOpcion("Soy del grupo 1", 1);
            OpcionConGrupo opcion5 = pregunta.agregarOpcion("Soy del grupo 2", 2);
            OpcionConGrupo opcion6 = pregunta.agregarOpcion("Soy del grupo 2", 2);
        }catch (CantidadInvalidaDeOpcionesException e){}

        assertThrows(CantidadInvalidaDeOpcionesException.class,
                ()-> {
                    OpcionConGrupo opcion7 = pregunta.agregarOpcion("Soy del grupo 1", 1);
                });
    }
}
