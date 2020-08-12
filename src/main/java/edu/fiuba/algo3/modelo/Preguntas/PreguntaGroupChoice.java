package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Jugadores.JugadorDeTipo;
import edu.fiuba.algo3.modelo.Jugadores.JugadorDeGroupChoice;
import edu.fiuba.algo3.modelo.Opciones.OpcionConGrupo;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.vista.VistaPreguntaGroupChoice;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class PreguntaGroupChoice extends Pregunta{

    private ArrayList<OpcionConGrupo> opciones = new ArrayList<OpcionConGrupo>();

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

    @Override
    public JugadorDeTipo tipo() {
        return new JugadorDeGroupChoice();
    }

    public ArrayList<OpcionConGrupo> opciones(){
        return opciones;
    }

    public OpcionConGrupo agregarOpcion(String unTexto, int grupoCorrecto) {
        OpcionConGrupo unaOpcion = new OpcionConGrupo(unTexto, grupoCorrecto);
        opciones.add(unaOpcion);
        return unaOpcion;
    }

    @Override
    public VBox crearVista(Jugador jugador, Ronda ronda){
        return new VistaPreguntaGroupChoice(jugador, this, ronda);
    }
}
