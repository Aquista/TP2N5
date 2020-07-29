package edu.fiuba.algo3.modelo.PuntajeTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;


public class PuntajeTest {
    
    @Test
    public void test01PuntajeClasicoAgrega1PuntoSiUnJugadorRespondeCorrectamente(){
        Jugador unJugador = new Jugador();

        OpcionCorrecta opcion = new OpcionCorrecta("true");
        RespuestaVF respuesta = new RespuestaVF();
        respuesta.agregarOpcion(opcion);
        unJugador.establecerRespuestas(respuesta);

        PuntajeClasico unPuntaje = new PuntajeClasico();
        unPuntaje.calcularPuntaje(unJugador);
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
        unPuntaje.calcularPuntaje(unJugador);
        assertEquals(puntosGanados,unJugador.getPuntaje());
    }
    @Test
    public void test03PuntajeConPenalidadAgrega1PuntoSiUnJugadorRespondeCorrectamente(){
        Jugador unJugador = new Jugador(); 
        OpcionCorrecta opcion = new OpcionCorrecta("true");
        RespuestaVF respuesta = new RespuestaVF();
        respuesta.agregarOpcion(opcion);
        unJugador.establecerRespuestas(respuesta);
        
        PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();
        unPuntaje.calcularPuntaje(unJugador);
        assertEquals(1,unJugador.getPuntaje()); 
    }
    @Test
    public void test04PuntajeConPenalidadSaca1PuntoSiUnJugadorRespondeIncorrectamente(){
        int puntosGanados=5;
        Jugador unJugador = new Jugador();
        unJugador.actualizarPuntaje(puntosGanados);
        OpcionIncorrecta opcion = new OpcionIncorrecta("true");
        RespuestaVF respuesta = new RespuestaVF();
        respuesta.agregarOpcion(opcion);
        unJugador.establecerRespuestas(respuesta);
        
        PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();
        unPuntaje.calcularPuntaje(unJugador);
        assertEquals(puntosGanados-1,unJugador.getPuntaje()); 
    }
    
}
