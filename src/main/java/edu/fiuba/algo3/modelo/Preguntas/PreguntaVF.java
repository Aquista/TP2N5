package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.*;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;

public class PreguntaVF extends PreguntaClasica {

    public PreguntaVF(String texto, Puntaje puntaje){
        super(texto, puntaje);
    }

    public PreguntaVF(String texto, Puntaje puntaje, int tiempo){
        super(texto, puntaje, tiempo);
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
    public Respuesta tipo() {
        return new RespuestaVF();
    }

    @Override
    public int getCantidadOpciones() {
        return 2;
    }

}
