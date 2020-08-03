package edu.fiuba.algo3.modelo.Puntajes;

public abstract class Puntaje {
    protected int puntos = 0;
    protected int cantidadCorrectas = 0;
    protected int cantidadIncorrectas = 0;
    
    public void sumarCorrecta() {
        cantidadCorrectas += 1;
    }

    public void sumarIncorrecta() {
        cantidadIncorrectas += 1;
    }
    public abstract Puntaje nuevoPuntaje(int unMulti);

    public  int getPuntos(){
        return puntos;
    }
    
    public abstract void calcularPuntaje(int respuestasCorrectas);

    public abstract void setMultiplicador(int multiplicador);
}
