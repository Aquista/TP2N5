package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private int puntaje = 0;
    private ArrayList<IRespuesta> respuestas = new ArrayList<>();

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

        for(IRespuesta respuesta : respuestas) {
            respuesta.evaluar(unPuntaje);
        }
    }
    public void establecerRespuestas(ArrayList<IRespuesta> respuestas) {
        this.respuestas = respuestas;
    }
}
