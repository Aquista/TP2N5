package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.IRespuesta;

public class Jugador {
    private int puntaje = 0;
    private IRespuesta respuesta;

    public void actualizarPuntaje(int puntos) {
        puntaje += puntos;
        if(puntaje < 0){
            puntaje = 0;
        }
    }
    public int puntos() {
        return puntaje;
    }

    public void evaluarRespuestas(Puntaje unPuntaje) {
        this.respuesta.evaluar(unPuntaje);
    }
    
    public void establecerRespuesta(IRespuesta unaRespuesta) {
        this.respuesta = unaRespuesta;
    }
    
    public void responderPreguntaCon(Pregunta pregunta, int unMulti, Opcion ... elegidas){
        pregunta.evaluarJugador(this,unMulti,elegidas);
    }
}
