package edu.fiuba.algo3.modelo.PuntajeTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeConPenalidadTest {
    @Test
    public void test03PuntajeConPenalidadAgrega1PuntoSiUnJugadorRespondeCorrectamente(){
        Jugador unJugador = new Jugador();
        OpcionCorrecta opcion = new OpcionCorrecta("true");
        RespuestaVF respuesta = new RespuestaVF();
        respuesta.agregarOpcion(opcion);
        unJugador.establecerRespuesta(respuesta);

        PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();
        unPuntaje.calcularPuntaje(unJugador, 1);
        assertEquals(1,unJugador.getPuntaje());
    }
    @Test
    public void test04PuntajeConPenalidadSaca1PuntoSiUnJugadorRespondeIncorrectamente(){
        int puntosGanados = 5;
        Jugador unJugador = new Jugador();
        unJugador.actualizarPuntaje(puntosGanados);
        OpcionIncorrecta opcion = new OpcionIncorrecta("true");
        RespuestaVF respuesta = new RespuestaVF();
        respuesta.agregarOpcion(opcion);
        unJugador.establecerRespuesta(respuesta);

        PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();
        unPuntaje.calcularPuntaje(unJugador, 1);
        assertEquals(puntosGanados-1,unJugador.getPuntaje());
    }
}
