package edu.fiuba.algo3.modelo.PuntajeTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeClasicoTest {
    @Test
    public void test01PuntajeClasicoAgrega1PuntoSiUnJugadorRespondeCorrectamente(){
        OpcionCorrecta opcion = new OpcionCorrecta("true");

        Jugador unJugador = new Jugador("ASD");
        unJugador.responder(new RespuestaVF(), opcion);

        PuntajeClasico unPuntaje = new PuntajeClasico();

        assertEquals(1, unPuntaje.calcularPuntaje(unJugador, 1));
    }

    @Test
    public void test02PuntajeClasicoNoSumaPuntoNiRestaSiUnJugadorRespondeIncorrectamente(){

        Jugador unJugador = new Jugador("SFD");

        OpcionIncorrecta opcion = new OpcionIncorrecta("true");
        unJugador.responder(new RespuestaVF(), opcion);

        PuntajeClasico unPuntaje = new PuntajeClasico();

        assertEquals(0, unPuntaje.calcularPuntaje(unJugador, 1));
    }

    @Test
    public void test03PuntajeClasicoSuma1PuntoSiUnJugadorRespondeTodasCorrectamente(){
        Jugador unJugador = new Jugador("ASFD");

        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");
        OpcionCorrecta opcion3 = new OpcionCorrecta("");

        unJugador.responder(new RespuestaMultipleChoice(), opcion1, opcion2, opcion3);

        PuntajeClasico unPuntaje = new PuntajeClasico();
        unPuntaje.asignarPuntaje(unJugador);
        assertEquals(1,unPuntaje.calcularPuntaje(unJugador, 3));
    }

    @Test
    public void test04PuntajeClasicoSuma0PuntosSiUnJugadorResponde3CorrectasDe3Y1Incorrecta(){
        Jugador unJugador = new Jugador("DFFA");
        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");
        OpcionCorrecta opcion3 = new OpcionCorrecta("");
        OpcionIncorrecta opcion4 = new OpcionIncorrecta("");

        unJugador.responder(new RespuestaMultipleChoice(), opcion1, opcion2, opcion3, opcion4);
        PuntajeClasico unPuntaje = new PuntajeClasico();

        assertEquals(0,unPuntaje.calcularPuntaje(unJugador, 3));
    }

    @Test
    public void test05PuntajeClasicoSuma0PuntosSiUnJugadorResponde2CorrectasDe3Y1Incorrecta(){
        Jugador unJugador = new Jugador("AFG");

        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");
        OpcionIncorrecta opcion3 = new OpcionIncorrecta("");

        unJugador.responder(new RespuestaMultipleChoice(), opcion1 ,opcion2,opcion3);

        PuntajeClasico unPuntaje = new PuntajeClasico();
        assertEquals(0,unPuntaje.calcularPuntaje(unJugador, 3));
    }

    @Test
    public void test06PuntajeClasicoSuma0PuntosSiUnJugadorResponde2CorrectasDe3YNingunaIncorrecta(){
        Jugador unJugador = new Jugador("FAGADHSADF");
        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");

        unJugador.responder(new RespuestaMultipleChoice(), opcion1);

        PuntajeClasico unPuntaje = new PuntajeClasico();

        assertEquals(0,unPuntaje.calcularPuntaje(unJugador, 3));
    }
}
