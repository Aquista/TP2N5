package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionConOrden;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import java.util.ArrayList;

public class PreguntaOrderedChoice extends Pregunta {

    public PreguntaOrderedChoice(String texto) {
        super(texto, new PuntajeClasico());
    }

    @Override
    public void evaluarJugadores(Jugador jugador1, Jugador jugador2) {
        PuntajeClasico puntaje1 = new PuntajeClasico();
        puntaje1.calcularPuntaje(jugador1, opciones.size());

        PuntajeClasico puntaje2 = new PuntajeClasico();
        puntaje2.calcularPuntaje(jugador2, opciones.size());

        jugador1.aplicarExclusividad(puntaje1, puntaje2);
        jugador2.aplicarExclusividad(puntaje2, puntaje1);

        puntaje1.asignarPuntaje(jugador1);
        puntaje2.asignarPuntaje(jugador2);
    }

    public void agregarOpcion(OpcionConOrden opcionConOrden){
        opciones.add(opcionConOrden);
    }

    public OpcionConOrden agregarOpcion(String unTexto, int orden) {
        OpcionConOrden opcion = new OpcionConOrden(unTexto, orden);
        agregarOpcion(opcion);
        return opcion;
    }
}
