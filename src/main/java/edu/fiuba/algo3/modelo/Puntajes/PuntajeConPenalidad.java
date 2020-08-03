package edu.fiuba.algo3.modelo.Puntajes;


public class PuntajeConPenalidad extends Puntaje {
    private int multiplicador;
    public PuntajeConPenalidad(){
        this.multiplicador=1;
    }
    public PuntajeConPenalidad(int nuevoMulti){
        this.multiplicador=nuevoMulti;
    }

    @Override
    public void calcularPuntaje(int respuestasCorrectas) {
        puntos = ((this.cantidadCorrectas - this.cantidadIncorrectas) * multiplicador);
    }


    @Override
    public Puntaje nuevoPuntaje(int unMulti) {
        return new PuntajeConPenalidad(unMulti);
    }
    @Override
    public void setMultiplicador(int unMultiplicador) {
        this.multiplicador = unMultiplicador;
    }


 
}
