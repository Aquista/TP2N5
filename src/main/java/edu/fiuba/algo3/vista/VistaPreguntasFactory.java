package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.modelo.Ronda;
import javafx.scene.layout.VBox;

public class VistaPreguntasFactory {

    public VBox creaVistaPregunta(Jugador jugador, Pregunta pregunta, Ronda ronda) {
        if(pregunta.getClass() == PreguntaVF.class)
            return new VistaPreguntaVF(jugador, (PreguntaVF)pregunta, ronda);
        else if(pregunta.getClass() == PreguntaMultipleChoice.class)
            return new VistaPreguntaMultipleChoice(jugador, (PreguntaMultipleChoice)pregunta, ronda);
        else if(pregunta.getClass() == PreguntaOrderedChoice.class)
            return new VistaPreguntaOrderedChoice(jugador, (PreguntaOrderedChoice)pregunta, ronda);
        else if(pregunta.getClass() == PreguntaGroupChoice.class)
            return new VistaPreguntaGroupChoice(jugador, (PreguntaGroupChoice)pregunta, ronda);
        return null;
    }
}