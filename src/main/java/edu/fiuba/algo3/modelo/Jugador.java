package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

public class Jugador {
    private int puntaje = 0;
    private Respuesta respuesta;

    public void actualizarPuntaje(int puntos) {
        puntaje += puntos;
        if(puntaje < 0){
            puntaje = 0;
        }
    }
    public int getPuntaje() {
        return puntaje;
    }

    public void evaluarRespuestas(Puntaje unPuntaje) {
        this.respuesta.evaluar(unPuntaje);
    }
    
    public void establecerRespuesta(Respuesta unaRespuesta) {
        this.respuesta = unaRespuesta;
    }
}
