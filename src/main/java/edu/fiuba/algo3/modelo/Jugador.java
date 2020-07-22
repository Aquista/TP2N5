package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private int puntaje = 0;
    private ArrayList<IRespuesta> respuestas = new ArrayList<IRespuesta>();

    public void actualizarPuntaje(int puntos) {
        puntaje += puntos;
    }
    public int getPuntaje() {
        return puntaje;
    }

    public void evaluarRespuestas(Marcador marcador) {

        for(IRespuesta respuesta : respuestas) {
            respuesta.evaluar(marcador);
        }
    }
    public void establecerRespuestas(ArrayList<IRespuesta> respuestas) {
        this.respuestas = respuestas;
    }
}
