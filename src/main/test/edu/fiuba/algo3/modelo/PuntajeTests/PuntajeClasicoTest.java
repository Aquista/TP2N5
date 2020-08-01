package edu.fiuba.algo3.modelo.PuntajeTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeClasicoTest {
    @Test
    public void test01PuntajeClasicoAgrega1PuntoSiUnJugadorRespondeCorrectamente(){
        
        PuntajeClasico unPuntaje = new PuntajeClasico();
        Jugador unJugador = new Jugador();
        OpcionCorrecta opcion = new OpcionCorrecta("true");
        opcion.evaluar(unPuntaje);
        unPuntaje.calcularPuntaje(unJugador, 1);
        
        assertEquals(1,unJugador.puntos());
    }
    @Test
    public void test02PuntajeClasicoNoSumaPuntoNiRestaSiUnJugadorRespondeIncorrectamente(){
        int puntosGanados = 5;
        Jugador unJugador = new Jugador();
        PuntajeClasico unPuntaje = new PuntajeClasico();
        unJugador.actualizarPuntaje(puntosGanados);
        OpcionIncorrecta opcion = new OpcionIncorrecta("true");
        opcion.evaluar(unPuntaje);
        unPuntaje.calcularPuntaje(unJugador, 1);
        
        assertEquals(puntosGanados,unJugador.puntos());
    }

    @Test
    public void test03PuntajeClasicoSuma1PuntoSiUnJugadorRespondeTodasCorrectamente(){
        Jugador unJugador = new Jugador();
        PuntajeClasico unPuntaje = new PuntajeClasico();
        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");
        OpcionCorrecta opcion3 = new OpcionCorrecta("");
        
        opcion1.evaluar(unPuntaje);
        opcion2.evaluar(unPuntaje);
        opcion3.evaluar(unPuntaje);
        
        unPuntaje.calcularPuntaje(unJugador, 3);
        assertEquals(1,unJugador.puntos());
    }

    @Test
    public void test04PuntajeClasicoSuma0PuntosSiUnJugadorResponde3CorrectasDe3Y1Incorrecta(){
        Jugador unJugador = new Jugador();
        PuntajeClasico unPuntaje = new PuntajeClasico();
        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");
        OpcionCorrecta opcion3 = new OpcionCorrecta("");
        OpcionIncorrecta opcion4 = new OpcionIncorrecta("");

        opcion1.evaluar(unPuntaje);
        opcion2.evaluar(unPuntaje);
        opcion3.evaluar(unPuntaje);
        opcion4.evaluar(unPuntaje);
        
        unPuntaje.calcularPuntaje(unJugador, 3);
        assertEquals(0,unJugador.puntos());
    }

    @Test
    public void test05PuntajeClasicoSuma0PuntosSiUnJugadorResponde2CorrectasDe3Y1Incorrecta(){
        Jugador unJugador = new Jugador();
        PuntajeClasico unPuntaje = new PuntajeClasico();
        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");
        OpcionIncorrecta opcion3 = new OpcionIncorrecta("");

        opcion1.evaluar(unPuntaje);
        opcion2.evaluar(unPuntaje);
        opcion3.evaluar(unPuntaje);

        unPuntaje.calcularPuntaje(unJugador, 2);
        assertEquals(0,unJugador.puntos());
    }

    @Test
    public void test06PuntajeClasicoSuma0PuntosSiUnJugadorResponde1CorrectasDe2YNingunaIncorrecta(){
        Jugador unJugador = new Jugador();
        PuntajeClasico unPuntaje = new PuntajeClasico();
        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");

        opcion1.evaluar(unPuntaje);
        
        unPuntaje.calcularPuntaje(unJugador, 2);
        assertEquals(0,unJugador.puntos());
    }
}
