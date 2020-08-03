package edu.fiuba.algo3.modelo.Puntajes;

public class PuntajeParcial extends Puntaje{

    @Override
    public void calcularPuntaje(int respuestasCorrectas) {
        if(cantidadIncorrectas == 0)
            puntos = cantidadCorrectas;
    }

    @Override
    public Puntaje nuevoPuntaje(int  unMulti) {
        return new PuntajeParcial();
    }

    @Override
    public void setMultiplicador(int multiplicador) {

    }
}
