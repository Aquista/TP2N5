package edu.fiuba.algo3.modelo.JugadorTests;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test01JugadorNuevoTiene0Puntos() {
        Jugador primerJugador = new Jugador();
        assertEquals(0,primerJugador.getPuntaje());
    }
    @Test
    public void test02CreoUnJugadorYLeSumo3Puntos() {
        Jugador primerJugador = new Jugador();
        int puntos = 3;
        primerJugador.actualizarPuntaje(puntos);

        assertEquals(puntos, primerJugador.getPuntaje());
    }
    @Test
    public void test03AUnJugadorCon0PuntosLeResto1PuntoYSigueTeniendo0Puntos() {
        Jugador primerJugador = new Jugador();
        int puntos = -1;
        int puntosEsperados = 0;
        primerJugador.actualizarPuntaje(puntos);

        assertEquals(puntosEsperados, primerJugador.getPuntaje());
    }
    @Test
    public void test04AUnJugadorCon6PuntosLeResto4PuntosYTiene2Puntos() {
        Jugador primerJugador = new Jugador();
        int puntosIniciales = 6;
        int puntosARestar = -4;
        int puntosEsperados = 2;
        primerJugador.actualizarPuntaje(puntosIniciales);
        primerJugador.actualizarPuntaje(puntosARestar);


        assertEquals(puntosEsperados, primerJugador.getPuntaje());
    }

}
