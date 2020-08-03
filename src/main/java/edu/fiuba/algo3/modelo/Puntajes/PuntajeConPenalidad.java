package edu.fiuba.algo3.modelo.Puntajes;


import edu.fiuba.algo3.modelo.Jugador;

public class PuntajeConPenalidad extends Puntaje {
    private int puntos = 0;
    private int multiplicador;
    public PuntajeConPenalidad(){
        this.multiplicador=1;
    }
    public PuntajeConPenalidad(int nuevoMulti){
        this.multiplicador=nuevoMulti;
    }
    @Override
    public void calcularPuntaje(Jugador unJugador, int respuestasCorrectas) {
        //unJugador.actualizarPuntaje((this.cantidadCorrectas-this.cantidadIncorrectas)*this.multiplicador);
        puntos = ((this.cantidadCorrectas - this.cantidadIncorrectas) * multiplicador);
    }

    @Override
    public int getPuntos() {
        return puntos;
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
