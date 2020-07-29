package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Puntajes.IPuntaje;
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
    public int getPuntaje() {
        return puntaje;
    }

    public void evaluarRespuestas(IPuntaje unPuntaje) {
        this.respuesta.evaluar(unPuntaje);
    }
    
    public void establecerRespuestas(IRespuesta unaRespuesta) {
        this.respuesta = unaRespuesta;
    }
}
