package edu.fiuba.algo3.modelo.PuntajeTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Respuestas.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeClasicoTest {
    @Test
    public void test01PuntajeClasicoAgrega1PuntoSiUnJugadorRespondeCorrectamente(){
        Jugador unJugador = new Jugador();

        OpcionCorrecta opcion = new OpcionCorrecta("true");
        RespuestaVF respuesta = new RespuestaVF();
        respuesta.agregarOpcion(opcion);
        unJugador.establecerRespuesta(respuesta);

        PuntajeClasico unPuntaje = new PuntajeClasico();
        unPuntaje.calcularPuntaje(unJugador, 1);
        unPuntaje.asignarPuntaje(unJugador);
        assertEquals(1,unJugador.getPuntaje());
    }
    @Test
    public void test02PuntajeClasicoNoSumaPuntoNiRestaSiUnJugadorRespondeIncorrectamente(){
        int puntosGanados = 5;
        Jugador unJugador = new Jugador();
        unJugador.actualizarPuntaje(puntosGanados);
        OpcionIncorrecta opcion = new OpcionIncorrecta("true");
        RespuestaVF respuesta = new RespuestaVF();
        respuesta.agregarOpcion(opcion);
        unJugador.establecerRespuesta(respuesta);

        PuntajeClasico unPuntaje = new PuntajeClasico();
        unPuntaje.calcularPuntaje(unJugador, 1);
        unPuntaje.asignarPuntaje(unJugador);
        assertEquals(puntosGanados,unJugador.getPuntaje());
    }

    @Test
    public void test03PuntajeClasicoSuma1PuntoSiUnJugadorRespondeTodasCorrectamente(){
        Jugador unJugador = new Jugador();
        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");
        OpcionCorrecta opcion3 = new OpcionCorrecta("");

        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice();
        respuesta.agregarOpcion(opcion1);
        respuesta.agregarOpcion(opcion2);
        respuesta.agregarOpcion(opcion3);
        unJugador.establecerRespuesta(respuesta);

        PuntajeClasico unPuntaje = new PuntajeClasico();
        unPuntaje.calcularPuntaje(unJugador, 3);
        unPuntaje.asignarPuntaje(unJugador);
        assertEquals(1,unJugador.getPuntaje());
    }

    @Test
    public void test04PuntajeClasicoSuma0PuntosSiUnJugadorResponde3CorrectasDe3Y1Incorrecta(){
        Jugador unJugador = new Jugador();
        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");
        OpcionCorrecta opcion3 = new OpcionCorrecta("");
        OpcionIncorrecta opcion4 = new OpcionIncorrecta("");

        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice();
        respuesta.agregarOpcion(opcion1);
        respuesta.agregarOpcion(opcion2);
        respuesta.agregarOpcion(opcion3);
        respuesta.agregarOpcion(opcion4);
        unJugador.establecerRespuesta(respuesta);

        PuntajeClasico unPuntaje = new PuntajeClasico();
        unPuntaje.calcularPuntaje(unJugador, 3);
        unPuntaje.asignarPuntaje(unJugador);
        assertEquals(0,unJugador.getPuntaje());
    }

    @Test
    public void test05PuntajeClasicoSuma0PuntosSiUnJugadorResponde2CorrectasDe3Y1Incorrecta(){
        Jugador unJugador = new Jugador();
        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");
        OpcionIncorrecta opcion3 = new OpcionIncorrecta("");

        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice();
        respuesta.agregarOpcion(opcion1);
        respuesta.agregarOpcion(opcion2);
        respuesta.agregarOpcion(opcion3);
        unJugador.establecerRespuesta(respuesta);

        PuntajeClasico unPuntaje = new PuntajeClasico();
        unPuntaje.calcularPuntaje(unJugador, 3);
        unPuntaje.asignarPuntaje(unJugador);
        assertEquals(0,unJugador.getPuntaje());
    }

    @Test
    public void test06PuntajeClasicoSuma0PuntosSiUnJugadorResponde2CorrectasDe3YNingunaIncorrecta(){
        Jugador unJugador = new Jugador();
        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");

        RespuestaMultipleChoice respuesta = new RespuestaMultipleChoice();
        respuesta.agregarOpcion(opcion1);
        unJugador.establecerRespuesta(respuesta);

        PuntajeClasico unPuntaje = new PuntajeClasico();
        unPuntaje.calcularPuntaje(unJugador, 3);
        unPuntaje.asignarPuntaje(unJugador);
        assertEquals(0,unJugador.getPuntaje());
    }
}
