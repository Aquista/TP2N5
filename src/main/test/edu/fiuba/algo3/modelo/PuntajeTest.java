package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PuntajeTest {
    
    @Test
    public void test01PuntajeAgrega1PuntoAUnJugador(){
        Jugador unJugador = new Jugador();

        RespuestaCorrecta resCorrecta = new RespuestaCorrecta("true");
        ArrayList<IRespuesta> respuestas = new ArrayList<IRespuesta>();
        respuestas.add(resCorrecta);
        unJugador.establecerRespuestas(respuestas);

        PuntajeClasico unPuntaje = new PuntajeClasico();
        unPuntaje.calcularPuntaje(unJugador);
        assertEquals(1,unJugador.getPuntaje());
    }
    
}
