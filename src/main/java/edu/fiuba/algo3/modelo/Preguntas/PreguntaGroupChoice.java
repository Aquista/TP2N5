package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Excepciones.CantidadInvalidaDeOpcionesException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaGroupChoice;

import java.util.ArrayList;

public class PreguntaGroupChoice extends Pregunta{

    private ArrayList<OpcionConGrupo> opciones = new ArrayList<OpcionConGrupo>();

    public PreguntaGroupChoice(String texto) {
        super(texto, new PuntajeClasico());
    }

    public PreguntaGroupChoice(String texto, int tiempo) {
        super(texto, new PuntajeClasico(), tiempo);
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

    @Override
    public Respuesta tipo() {
        return new RespuestaGroupChoice();
    }

    @Override
    public int getCantidadOpciones() {
        return opciones.size();
    }

    public ArrayList<OpcionConGrupo> opciones(){
        return opciones;
    }

    public OpcionConGrupo agregarOpcion(String unTexto, int grupoCorrecto) throws CantidadInvalidaDeOpcionesException{
        if(opciones.size() >= 6)
            throw new CantidadInvalidaDeOpcionesException();
        OpcionConGrupo unaOpcion = new OpcionConGrupo(unTexto, grupoCorrecto);
        opciones.add(unaOpcion);
        return unaOpcion;
    }

}
