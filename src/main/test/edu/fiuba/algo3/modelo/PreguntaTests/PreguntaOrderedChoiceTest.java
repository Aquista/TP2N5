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

        OpcionConOrden opcion1 = new OpcionConOrden("Voy primero", 1);
        OpcionConOrden opcion2 = new OpcionConOrden("Voy segundo", 2);
        OpcionConOrden opcion3 = new OpcionConOrden("Voy tercero", 3);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        pregunta.agregarOpcion(opcion1);
        pregunta.agregarOpcion(opcion2);
        pregunta.agregarOpcion(opcion3);

        RespuestaOrderChoice respuesta = new RespuestaOrderChoice();
        respuesta.agregarOpcion(opcion1);
        respuesta.agregarOpcion(opcion2);
        respuesta.agregarOpcion(opcion3);

        jugador.establecerRespuesta(respuesta);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(1, jugador.getPuntaje());

    }
    @Test
    public void test02JugadorCon0PuntosRespondeConOrdenIncorrectoYSuma0Puntos(){
        Jugador jugador = new Jugador();

        OpcionConOrden opcion1 = new OpcionConOrden("Voy primero", 1);
        OpcionConOrden opcion2 = new OpcionConOrden("Voy segundo", 2);
        OpcionConOrden opcion3 = new OpcionConOrden("Voy tercero", 3);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        pregunta.agregarOpcion(opcion1);
        pregunta.agregarOpcion(opcion2);
        pregunta.agregarOpcion(opcion3);

        RespuestaOrderChoice respuesta = new RespuestaOrderChoice();
        respuesta.agregarOpcion(opcion1);
        respuesta.agregarOpcion(opcion3);
        respuesta.agregarOpcion(opcion2);

        jugador.establecerRespuesta(respuesta);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void test03JugadoresCon0PuntosRespondenConOrdenIncorrectoYConOrdenCorrecto(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        OpcionConOrden opcion1 = new OpcionConOrden("Voy primero", 1);
        OpcionConOrden opcion2 = new OpcionConOrden("Voy segundo", 2);
        OpcionConOrden opcion3 = new OpcionConOrden("Voy tercero", 3);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        pregunta.agregarOpcion(opcion1);
        pregunta.agregarOpcion(opcion2);
        pregunta.agregarOpcion(opcion3);

        RespuestaOrderChoice respuesta1 = new RespuestaOrderChoice();
        RespuestaOrderChoice respuesta2 = new RespuestaOrderChoice();

        respuesta1.agregarOpcion(opcion1);
        respuesta1.agregarOpcion(opcion3);
        respuesta1.agregarOpcion(opcion2);
        jugador1.establecerRespuesta(respuesta1);

        respuesta2.agregarOpcion(opcion1);
        respuesta2.agregarOpcion(opcion2);
        respuesta2.agregarOpcion(opcion3);
        jugador2.establecerRespuesta(respuesta2);


        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void test04JugadoresCon0PuntosRespondenConOrdenCorrectoYConOrdenCorrecto(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        OpcionConOrden opcion1 = new OpcionConOrden("Voy primero", 1);
        OpcionConOrden opcion2 = new OpcionConOrden("Voy segundo", 2);
        OpcionConOrden opcion3 = new OpcionConOrden("Voy tercero", 3);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        pregunta.agregarOpcion(opcion1);
        pregunta.agregarOpcion(opcion2);
        pregunta.agregarOpcion(opcion3);

        RespuestaOrderChoice respuesta1 = new RespuestaOrderChoice();
        RespuestaOrderChoice respuesta2 = new RespuestaOrderChoice();

        respuesta1.agregarOpcion(opcion1);
        respuesta1.agregarOpcion(opcion2);
        respuesta1.agregarOpcion(opcion3);
        jugador1.establecerRespuesta(respuesta1);

        respuesta2.agregarOpcion(opcion1);
        respuesta2.agregarOpcion(opcion2);
        respuesta2.agregarOpcion(opcion3);
        jugador2.establecerRespuesta(respuesta2);


        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void test05JugadoresCon0PuntosRespondenConOrdenIncorrectoYConOrdenIncorrecto(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        OpcionConOrden opcion1 = new OpcionConOrden("Voy primero", 1);
        OpcionConOrden opcion2 = new OpcionConOrden("Voy segundo", 2);
        OpcionConOrden opcion3 = new OpcionConOrden("Voy tercero", 3);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("hola");
        pregunta.agregarOpcion(opcion1);
        pregunta.agregarOpcion(opcion2);
        pregunta.agregarOpcion(opcion3);

        RespuestaOrderChoice respuesta1 = new RespuestaOrderChoice();
        RespuestaOrderChoice respuesta2 = new RespuestaOrderChoice();

        respuesta1.agregarOpcion(opcion3);
        respuesta1.agregarOpcion(opcion2);
        respuesta1.agregarOpcion(opcion1);
        jugador1.establecerRespuesta(respuesta1);

        respuesta2.agregarOpcion(opcion2);
        respuesta2.agregarOpcion(opcion3);
        respuesta2.agregarOpcion(opcion1);
        jugador2.establecerRespuesta(respuesta2);


        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }
}
