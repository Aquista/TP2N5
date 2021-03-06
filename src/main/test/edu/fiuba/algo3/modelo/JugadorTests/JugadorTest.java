package edu.fiuba.algo3.modelo.JugadorTests;

import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test01JugadorNuevoTiene0Puntos() {
        Jugador primerJugador = new Jugador("DFASFAS");
        assertEquals(0,primerJugador.getPuntaje());
    }
    @Test
    public void test02CreoUnJugadorYLeSumo3Puntos() {
        Jugador primerJugador = new Jugador("ASGDF");
        int puntos = 3;
        primerJugador.actualizarPuntaje(puntos);

        assertEquals(puntos, primerJugador.getPuntaje());
    }
    @Test
    public void test03AUnJugadorCon0PuntosLeResto1PuntoYSigueTeniendo0Puntos() {
        Jugador primerJugador = new Jugador("FDASG");
        int puntos = -1;
        int puntosEsperados = 0;
        primerJugador.actualizarPuntaje(puntos);

        assertEquals(puntosEsperados, primerJugador.getPuntaje());
    }
    @Test
    public void test04AUnJugadorCon6PuntosLeResto4PuntosYTiene2Puntos() {
        Jugador primerJugador = new Jugador("FSDASG");
        int puntosIniciales = 6;
        int puntosARestar = -4;
        int puntosEsperados = 2;
        primerJugador.actualizarPuntaje(puntosIniciales);
        primerJugador.actualizarPuntaje(puntosARestar);
        assertEquals(puntosEsperados, primerJugador.getPuntaje());
    }

}
