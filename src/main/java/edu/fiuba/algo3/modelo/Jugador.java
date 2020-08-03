package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;

public class Jugador {
    private int puntaje = 0;
    private Respuesta respuesta;

    public void actualizarPuntaje(int puntos) {
        puntaje += puntos;
        if(puntaje < 0){
            puntaje = 0;
        }
    }
    public int puntos() {
        return puntaje;
    }

    public void evaluarRespuestas(Puntaje unPuntaje, int totalCorrectas) {
        respuesta.agregarMultiplicador(unPuntaje);
        this.respuesta.evaluar(unPuntaje);
        unPuntaje.calcularPuntaje(totalCorrectas);

    }

    public void responderConRespuesta(int multiplicador, Respuesta unaRespuesta) {

        respuesta = unaRespuesta;
        respuesta.setMultiplicador(multiplicador);
    }
}
