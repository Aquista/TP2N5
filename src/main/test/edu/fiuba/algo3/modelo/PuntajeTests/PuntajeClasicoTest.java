package edu.fiuba.algo3.modelo.PuntajeTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeClasicoTest {
    @Test
    public void test01PuntajeClasicoAgrega1PuntoSiUnJugadorRespondeCorrectamente(){
        Jugador unJugador = new Jugador();

        OpcionCorrecta opcion = new OpcionCorrecta("true");
        RespuestaVF respuesta = new RespuestaVF();
        respuesta.agregarOpcion(opcion);
        unJugador.establecerRespuestas(respuesta);

        PuntajeClasico unPuntaje = new PuntajeClasico();
        unPuntaje.calcularPuntaje(unJugador, 1);
        assertEquals(1,unJugador.getPuntaje());
    }
    @Test
    public void test02PuntajeClasicoNoSaca1PuntoSiUnJugadorRespondeIncorrectamente(){
        int puntosGanados=5;
        Jugador unJugador = new Jugador();
        unJugador.actualizarPuntaje(puntosGanados);
        OpcionIncorrecta opcion = new OpcionIncorrecta("true");
        RespuestaVF respuesta = new RespuestaVF();
        respuesta.agregarOpcion(opcion);
        unJugador.establecerRespuestas(respuesta);

        PuntajeClasico unPuntaje = new PuntajeClasico();
        unPuntaje.calcularPuntaje(unJugador, 1);
        assertEquals(puntosGanados,unJugador.getPuntaje());
    }
    /*@Test
    public void test01PuntajeConTodasCorrectasYNingunaIncorrectaAgrega1PuntoAUnJugador(){
        Jugador unJugador = new Jugador();
        int totalRespuestasCorrectas = 3;
        PuntajeClasico puntaje = new PuntajeClasico();

        puntaje.sumarCorrecta();
        puntaje.sumarCorrecta();
        puntaje.sumarCorrecta();

        puntaje.calcularPuntaje(unJugador, totalRespuestasCorrectas);
        assertEquals(1,unJugador.getPuntaje());
    }

    @Test
    public void test02PuntajeCon2CorrectasY1IncorrectaAgrega0PuntosAUnJugador() {
        int totalRespuestasCorrectas = 3;
        Jugador unJugador = new Jugador();

        PuntajeClasico puntaje = new PuntajeClasico();

        puntaje.sumarCorrecta();
        puntaje.sumarCorrecta();
        puntaje.sumarCorrecta();
        puntaje.sumarIncorrecta();

        puntaje.calcularPuntaje(unJugador, totalRespuestasCorrectas);

        assertEquals(0,unJugador.getPuntaje());
    }

    @Test
    public void test03PuntajeConTodasCorrectasY1IncorrectaAgrega0PuntosAUnJugador(){
        Jugador unJugador = new Jugador();
        int totalRespuestasCorrectas = 3;
        PuntajeClasico puntaje = new PuntajeClasico();

        puntaje.sumarCorrecta();
        puntaje.sumarCorrecta();
        puntaje.sumarCorrecta();
        puntaje.sumarIncorrecta();

        puntaje.calcularPuntaje(unJugador, totalRespuestasCorrectas);
        assertEquals(0,unJugador.getPuntaje());
    }

    @Test
    public void test04PuntajeCon2De3CorrectasAgrega0PuntosAUnJugador(){
        Jugador unJugador = new Jugador();
        int totalRespuestasCorrectas = 3;
        PuntajeClasico puntaje = new PuntajeClasico(totalRespuestasCorrectas);

        puntaje.sumarCorrecta();
        puntaje.sumarCorrecta();

        puntaje.calcularPuntaje(unJugador);
        assertEquals(0,unJugador.getPuntaje());
    }*/
}
