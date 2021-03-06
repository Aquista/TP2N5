package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Excepciones.CantidadInvalidaDeOpcionesException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionConOrden;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaOrderChoice;

import java.util.ArrayList;

public class PreguntaOrderedChoice extends Pregunta {

    private ArrayList<OpcionConOrden> opciones = new ArrayList<OpcionConOrden>();

    public PreguntaOrderedChoice(String texto) {
        super(texto, new PuntajeClasico());
    }

    public PreguntaOrderedChoice(String texto, int tiempo) {
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
        return new RespuestaOrderChoice();
    }

    @Override
    public int getCantidadOpciones() {
        return opciones.size();
    }

    public ArrayList<OpcionConOrden> opciones(){
        return opciones;
    }

    public OpcionConOrden agregarOpcion(String unTexto, int orden) throws CantidadInvalidaDeOpcionesException {
        if(opciones.size() >= 5)
            throw new CantidadInvalidaDeOpcionesException();

        OpcionConOrden opcion = new OpcionConOrden(unTexto, orden);
        opciones.add(opcion);
        return opcion;
    }
}
