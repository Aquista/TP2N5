package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void creoUnJugadorYLeSumoUnPunto() {
        Jugador j1 = new Jugador();
        int cantidadASumar = 1;
        j1.sumarPuntos(cantidadASumar);

        assertEquals(j1.getPuntos(), cantidadASumar);
    }
}
