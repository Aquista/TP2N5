package edu.fiuba.algo3.modelo.PuntajeTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeConPenalidadTest {
    @Test
    public void test03PuntajeConPenalidadAgrega1PuntoSiUnJugadorRespondeCorrectamente(){
        Jugador unJugador = new Jugador();
        PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();
        OpcionCorrecta opcion = new OpcionCorrecta("true");
        opcion.evaluar(unPuntaje);
        
        unPuntaje.calcularPuntaje(unJugador,0);
        assertEquals(1,unJugador.puntos());
    }
    @Test
    public void test04PuntajeConPenalidadSaca1PuntoSiUnJugadorRespondeIncorrectamente(){
        int puntosGanados=5;
        Jugador unJugador = new Jugador();
        unJugador.actualizarPuntaje(puntosGanados);
        PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();
        OpcionIncorrecta opcion = new OpcionIncorrecta("true");
        opcion.evaluar(unPuntaje);
        unPuntaje.calcularPuntaje(unJugador,0);
        assertEquals(puntosGanados-1,unJugador.puntos());
    }
}
