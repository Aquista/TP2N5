package edu.fiuba.algo3.modelo.Puntajes;

public class PuntajeClasico extends Puntaje {
    
    @Override
    public void calcularPuntaje(int cantidadRespCorrectasPregunta) {
        if(cantidadCorrectas == cantidadRespCorrectasPregunta && cantidadIncorrectas == 0) {
            puntos = 1;
        } else puntos = 0;
    }


    @Override
    public Puntaje nuevoPuntaje(int unMulti) {
        return new PuntajeClasico();
    }

    @Override
    public void setMultiplicador(int multiplicador) {

    }
}