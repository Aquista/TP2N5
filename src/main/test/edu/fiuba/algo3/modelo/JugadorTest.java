package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test01creoUnJugadorYLeSumoUnPunto() {
        Jugador primerJugador = new Jugador();
        int cantidadASumar = 1;
        primerJugador.sumarPuntos(cantidadASumar);

        assertEquals(cantidadASumar,primerJugador.misPuntos());
    }
}
