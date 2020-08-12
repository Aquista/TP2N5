package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Jugadores.JugadorDeTipo;
import edu.fiuba.algo3.modelo.Jugadores.JugadorDeVerdadoroFalso;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.*;
import edu.fiuba.algo3.vista.VistaPreguntaVF;
import javafx.scene.layout.VBox;

public class PreguntaVF extends PreguntaClasica {
    public PreguntaVF(String texto, Puntaje puntaje){
        super(texto, puntaje);
    }

    public OpcionCorrecta agregarOpcionCorrecta(String texto) {
        OpcionCorrecta opcion = new OpcionCorrecta(texto);
        agregarOpcionCorrecta(opcion);
        return opcion;
    }

    public OpcionIncorrecta agregarOpcionIncorrecta(String texto) {
        OpcionIncorrecta opcion = new OpcionIncorrecta(texto);
        agregarOpcionIncorrecta(opcion);
        return opcion;
    }

    @Override
    public void evaluarJugadores(Jugador jugador1, Jugador jugador2) {
        Puntaje puntaje1 = puntaje.duplicar();
        puntaje1.calcularPuntaje(jugador1, this.totalCorrectas);

        Puntaje puntaje2 = puntaje.duplicar();
        puntaje2.calcularPuntaje(jugador2, this.totalCorrectas);

        jugador1.aplicarExclusividad(puntaje1, puntaje2);
        jugador2.aplicarExclusividad(puntaje2, puntaje1);

        puntaje1.asignarPuntaje(jugador1);
        puntaje2.asignarPuntaje(jugador2);
    }

    @Override
    public JugadorDeTipo tipo() {
        return new JugadorDeVerdadoroFalso();
    }

    @Override
    public VBox crearVista(Jugador jugador, Ronda ronda){
        return new VistaPreguntaVF(jugador, this, ronda);
    }
}
