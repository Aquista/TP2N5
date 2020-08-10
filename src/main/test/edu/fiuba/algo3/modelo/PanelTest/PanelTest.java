package edu.fiuba.algo3.modelo.PanelTest;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Panel.Panel;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PanelTest {
    @Test
    public void test01ElGanadorDelKahootEsElQueTieneMasPuntos(){
        Jugador primerJugador = new Jugador();
        Jugador segundoJugador = new Jugador();
        Panel panel =new Panel(primerJugador,segundoJugador);
        PreguntaVF unaPregunta = new PreguntaVF("aprobamos?", new PuntajeClasico());
        OpcionCorrecta opcionCorrecta = unaPregunta.agregarOpcionCorrecta("true");
        OpcionIncorrecta opcionIncorrecta = unaPregunta.agregarOpcionIncorrecta("false");
        primerJugador.responder(unaPregunta.tipo(),opcionCorrecta);
        segundoJugador.responder(unaPregunta.tipo(),opcionIncorrecta);
        assertEquals(primerJugador,panel.ganador());
    }
}
