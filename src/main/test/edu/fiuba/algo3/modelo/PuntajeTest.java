package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PuntajeTest {
    
    @Test
    public void test01PuntajeAgrega1PuntoAUnJugador(){
        Jugador unJugador = new Jugador();
        Puntaje unPuntaje = new Puntaje(1);
        unPuntaje.agregarPuntos(unJugador);
        assertEquals(1,unJugador.getPuntaje());
    }
    
}
