package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.Ronda;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Jugadores.JugadorDeTipo;
import edu.fiuba.algo3.modelo.Jugadores.JugadorDeOrderChoice;
import edu.fiuba.algo3.modelo.Opciones.OpcionConOrden;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.vista.VistaPreguntaOrderedChoice;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class PreguntaOrderedChoice extends Pregunta {

    private ArrayList<OpcionConOrden> opciones = new ArrayList<OpcionConOrden>();

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

    @Override
    public JugadorDeTipo tipo() {
        return new JugadorDeOrderChoice();
    }

    public ArrayList<OpcionConOrden> opciones(){
        return opciones;
    }

    public OpcionConOrden agregarOpcion(String unTexto, int orden) {
        OpcionConOrden opcion = new OpcionConOrden(unTexto, orden);
        opciones.add(opcion);
        return opcion;
    }

    @Override
    public VBox crearVista(Jugador jugador, Ronda ronda){
        return new VistaPreguntaOrderedChoice(jugador, this, ronda);
    }
}
