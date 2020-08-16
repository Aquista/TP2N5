package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.Panel;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.*;

public class VistaPreguntasFactory {

    public VistaPregunta creaVistaPregunta(Jugador jugador, Pregunta pregunta, Panel panel) {
        if(pregunta.getClass() == PreguntaVF.class)
            return new VistaPreguntaVF(jugador, (PreguntaVF)pregunta, panel);
        else if(pregunta.getClass() == PreguntaMultipleChoice.class)
            return new VistaPreguntaMultipleChoice(jugador, (PreguntaMultipleChoice)pregunta, panel);
        else if(pregunta.getClass() == PreguntaOrderedChoice.class)
            return new VistaPreguntaOrderedChoice(jugador, (PreguntaOrderedChoice)pregunta, panel);
        else if(pregunta.getClass() == PreguntaGroupChoice.class)
            return new VistaPreguntaGroupChoice(jugador, (PreguntaGroupChoice)pregunta, panel);
        return null;
    }
}