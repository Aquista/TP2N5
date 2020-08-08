package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;

public class PreguntaGroupChoice extends Pregunta{

    public PreguntaGroupChoice(String texto) {
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

    public void agregarOpcion(OpcionConGrupo opcionConGrupo){
        opciones.add(opcionConGrupo);
    }

    public OpcionConGrupo agregarOpcion(String unTexto, int grupoCorrecto) {
        OpcionConGrupo unaOpcion = new OpcionConGrupo(unTexto, grupoCorrecto);
        agregarOpcion(unaOpcion);
        return unaOpcion;
    }
}
