package edu.fiuba.algo3.modelo.PreguntaTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaOrderChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PreguntaGroupChoiceTest {

    @Test

    public void test01JugadorCon0PuntosRespondeBienYSuma1Punto(){
        Jugador jugador = new Jugador();

        OpcionConGrupo opcion1 = new OpcionConGrupo("Soy del grupo 1", 1);
        OpcionConGrupo opcion2 = new OpcionConGrupo("Soy del grupo 2", 2);
        OpcionConGrupo opcion3 = new OpcionConGrupo("Soy del grupo 1", 1);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("hola");
        pregunta.agregarOpcion(opcion1);
        pregunta.agregarOpcion(opcion2);
        pregunta.agregarOpcion(opcion3);


        RespuestaGroupChoice respuesta = new RespuestaGroupChoice();
        respuesta.agregarOpcion(opcion1, 1);
        respuesta.agregarOpcion(opcion2, 2);
        respuesta.agregarOpcion(opcion3, 1);

        jugador.establecerRespuesta(respuesta);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(1, jugador.getPuntaje());

    }
    @Test
    public void test02JugadorCon0PuntosRespondeMalYSuma0Puntos(){
        Jugador jugador = new Jugador();

        OpcionConGrupo opcion1 = new OpcionConGrupo("Soy del grupo 1", 1);
        OpcionConGrupo opcion2 = new OpcionConGrupo("Soy del grupo 2", 2);
        OpcionConGrupo opcion3 = new OpcionConGrupo("Soy del grupo 1", 1);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("hola");
        pregunta.agregarOpcion(opcion1);
        pregunta.agregarOpcion(opcion2);
        pregunta.agregarOpcion(opcion3);


        RespuestaGroupChoice respuesta = new RespuestaGroupChoice();
        respuesta.agregarOpcion(opcion1, 2);
        respuesta.agregarOpcion(opcion2, 2);
        respuesta.agregarOpcion(opcion3, 1);

        jugador.establecerRespuesta(respuesta);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(0, jugador.getPuntaje());
    }

    @Test
    public void test03JugadoresCon0PuntosRespondenBienYMal(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        OpcionConGrupo opcion1 = new OpcionConGrupo("Soy del grupo 1", 1);
        OpcionConGrupo opcion2 = new OpcionConGrupo("Soy del grupo 2", 2);
        OpcionConGrupo opcion3 = new OpcionConGrupo("Soy del grupo 1", 1);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("hola");
        pregunta.agregarOpcion(opcion1);
        pregunta.agregarOpcion(opcion2);
        pregunta.agregarOpcion(opcion3);

        RespuestaGroupChoice respuesta1 = new RespuestaGroupChoice();
        respuesta1.agregarOpcion(opcion1, 1);
        respuesta1.agregarOpcion(opcion2, 2);
        respuesta1.agregarOpcion(opcion3, 1);
        jugador1.establecerRespuesta(respuesta1);

        RespuestaGroupChoice respuesta2 = new RespuestaGroupChoice();
        respuesta2.agregarOpcion(opcion1, 2);
        respuesta2.agregarOpcion(opcion2, 2);
        respuesta2.agregarOpcion(opcion3, 2);
        jugador2.establecerRespuesta(respuesta2);

        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

    @Test
    public void test04JugadoresCon0PuntosRespondenBienAmbos(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        OpcionConGrupo opcion1 = new OpcionConGrupo("Soy del grupo 1", 1);
        OpcionConGrupo opcion2 = new OpcionConGrupo("Soy del grupo 2", 2);
        OpcionConGrupo opcion3 = new OpcionConGrupo("Soy del grupo 1", 1);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("hola");
        pregunta.agregarOpcion(opcion1);
        pregunta.agregarOpcion(opcion2);
        pregunta.agregarOpcion(opcion3);

        RespuestaGroupChoice respuesta1 = new RespuestaGroupChoice();
        respuesta1.agregarOpcion(opcion1, 1);
        respuesta1.agregarOpcion(opcion2, 2);
        respuesta1.agregarOpcion(opcion3, 1);
        jugador1.establecerRespuesta(respuesta1);

        RespuestaGroupChoice respuesta2 = new RespuestaGroupChoice();
        respuesta2.agregarOpcion(opcion1, 1);
        respuesta2.agregarOpcion(opcion2, 2);
        respuesta2.agregarOpcion(opcion3, 1);
        jugador2.establecerRespuesta(respuesta2);

        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(1, jugador1.getPuntaje());
        assertEquals(1, jugador2.getPuntaje());
    }

    @Test
    public void test05JugadoresCon0PuntosRespondenMalAmbos(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        OpcionConGrupo opcion1 = new OpcionConGrupo("Soy del grupo 1", 1);
        OpcionConGrupo opcion2 = new OpcionConGrupo("Soy del grupo 2", 2);
        OpcionConGrupo opcion3 = new OpcionConGrupo("Soy del grupo 1", 1);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice("hola");
        pregunta.agregarOpcion(opcion1);
        pregunta.agregarOpcion(opcion2);
        pregunta.agregarOpcion(opcion3);

        RespuestaGroupChoice respuesta1 = new RespuestaGroupChoice();
        respuesta1.agregarOpcion(opcion1, 2);
        respuesta1.agregarOpcion(opcion2, 2);
        respuesta1.agregarOpcion(opcion3, 1);
        jugador1.establecerRespuesta(respuesta1);

        RespuestaGroupChoice respuesta2 = new RespuestaGroupChoice();
        respuesta2.agregarOpcion(opcion1, 1);
        respuesta2.agregarOpcion(opcion2, 1);
        respuesta2.agregarOpcion(opcion3, 1);
        jugador2.establecerRespuesta(respuesta2);

        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(0, jugador1.getPuntaje());
        assertEquals(0, jugador2.getPuntaje());
    }

}
