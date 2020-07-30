package edu.fiuba.algo3.modelo.PreguntaTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaMultipleChoice;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PreguntaMultipleChoiceClasicoTest {
    
    @Test
    public void test01JugadorCon0PuntosResponde1SolaOpcionCorrectaDe2YSigueTeniendo0puntos(){
        int puntajeEsperado = 0;

        Jugador jugador = new Jugador();
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionIncorrecta op3 = new OpcionIncorrecta("texto opcion 3");
        PreguntaMultipleChoiceClasico pregunta = new PreguntaMultipleChoiceClasico("texto");
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionIncorrecta(op3);

        RespuestaMultipleChoice resp = new RespuestaMultipleChoice();
        resp.agregarOpcion(op1);
        jugador.establecerRespuesta(resp);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }

    @Test
    public void test02JugadorCon0PuntosResponde3OpcionCorrectasDe3YSuma1punto(){
        int puntajeEsperado = 1;

        Jugador jugador = new Jugador();
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = new OpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = new OpcionIncorrecta("texto opcion 4");
        PreguntaMultipleChoiceClasico pregunta = new PreguntaMultipleChoiceClasico("texto");
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionCorrecta(op3);
        pregunta.agregarOpcionIncorrecta(op4);

        RespuestaMultipleChoice resp = new RespuestaMultipleChoice();
        resp.agregarOpcion(op1);
        resp.agregarOpcion(op2);
        resp.agregarOpcion(op3);
        jugador.establecerRespuesta(resp);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntajeEsperado, jugador.getPuntaje());
    }
    
    @Test
    public void test03JugadorCon5PuntosResponde1OpcionIncorrectasDe1YNoSumaPuntos(){
        int puntosGanados = 5;

        Jugador jugador = new Jugador();
        jugador.actualizarPuntaje(puntosGanados);
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = new OpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = new OpcionIncorrecta("texto opcion 4");
        PreguntaMultipleChoiceClasico pregunta = new PreguntaMultipleChoiceClasico("texto");
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionCorrecta(op3);
        pregunta.agregarOpcionIncorrecta(op4);

        RespuestaMultipleChoice resp = new RespuestaMultipleChoice();
        resp.agregarOpcion(op4);
        jugador.establecerRespuesta(resp);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntosGanados, jugador.getPuntaje());
    }
    
    @Test
    public void test04JugadoresCon5PuntosRespondenConOpcionesCorrectasCompletasYConOpcionIncorrectaGanan1Y0Puntos(){
        int puntosGanados = 5;

        Jugador primerJugador = new Jugador();
        Jugador segundoJugador = new Jugador();
        primerJugador.actualizarPuntaje(puntosGanados);
        segundoJugador.actualizarPuntaje(puntosGanados);
        
        OpcionCorrecta op1 = new OpcionCorrecta("texto opcion 1");
        OpcionCorrecta op2 = new OpcionCorrecta("texto opcion 2");
        OpcionCorrecta op3 = new OpcionCorrecta("texto opcion 3");
        OpcionIncorrecta op4 = new OpcionIncorrecta("texto opcion 4");
        PreguntaMultipleChoiceClasico pregunta = new PreguntaMultipleChoiceClasico("texto");
        pregunta.agregarOpcionCorrecta(op1);
        pregunta.agregarOpcionCorrecta(op2);
        pregunta.agregarOpcionCorrecta(op3);
        pregunta.agregarOpcionIncorrecta(op4);

        RespuestaMultipleChoice resp1 = new RespuestaMultipleChoice();
        resp1.agregarOpcion(op1);
        resp1.agregarOpcion(op2);
        resp1.agregarOpcion(op3);
        primerJugador.establecerRespuesta(resp1);

        RespuestaMultipleChoice resp2 = new RespuestaMultipleChoice();
        resp2.agregarOpcion(op4);
        segundoJugador.establecerRespuesta(resp2);
        
        
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(primerJugador);
        jugadores.add(segundoJugador);

        pregunta.evaluarJugadores(jugadores);

        assertEquals(puntosGanados+1, primerJugador.getPuntaje());
        assertEquals(puntosGanados, segundoJugador.getPuntaje());
    }
}
