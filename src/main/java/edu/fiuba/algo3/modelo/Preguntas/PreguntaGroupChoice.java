package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Opciones.OpcionConOrden;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;

import java.util.ArrayList;

public class PreguntaGroupChoice extends Pregunta{

    public PreguntaGroupChoice(String texto) {
        super(texto, new PuntajeClasico());
    }

    @Override
    public void evaluarJugadores(ArrayList<Jugador> jugadores) {
        for(Jugador jugador : jugadores) {
            PuntajeClasico puntajeJugador = new PuntajeClasico();
            puntajeJugador.calcularPuntaje(jugador, opciones.size());
        }
    }

    public void agregarOpcion(OpcionConGrupo opcionConGrupo){
        opciones.add(opcionConGrupo);
    }
}
