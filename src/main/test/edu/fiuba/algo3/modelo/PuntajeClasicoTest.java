package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeClasicoTest {
    @Test
    public void test01PuntajeConTodasCorrectasYNingunaIncorrectaAgrega1PuntoAUnJugador(){
        Jugador unJugador = new Jugador();
        int totalRespuestasCorrectas = 3;
        PuntajeClasico puntaje = new PuntajeClasico(totalRespuestasCorrectas);

        puntaje.sumarCorrecta();
        puntaje.sumarCorrecta();
        puntaje.sumarCorrecta();

        puntaje.calcularPuntaje(unJugador);
        assertEquals(1,unJugador.getPuntaje());
    }

    @Test
    public void test02PuntajeCon2CorrectasY1IncorrectaAgrega0PuntosAUnJugador() {
        int totalRespuestasCorrectas = 3;
        Jugador unJugador = new Jugador();
        PuntajeClasico puntaje = new PuntajeClasico(totalRespuestasCorrectas);

        puntaje.sumarCorrecta();
        puntaje.sumarCorrecta();
        puntaje.sumarCorrecta();
        puntaje.sumarIncorrecta();

        puntaje.calcularPuntaje(unJugador);

        assertEquals(0,unJugador.getPuntaje());
    }

    @Test
    public void test03PuntajeConTodasCorrectasY1IncorrectaAgrega0PuntosAUnJugador(){
        Jugador unJugador = new Jugador();
        int totalRespuestasCorrectas = 3;
        PuntajeClasico puntaje = new PuntajeClasico(totalRespuestasCorrectas);

        puntaje.sumarCorrecta();
        puntaje.sumarCorrecta();
        puntaje.sumarCorrecta();
        puntaje.sumarIncorrecta();

        puntaje.calcularPuntaje(unJugador);
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
    }
}
