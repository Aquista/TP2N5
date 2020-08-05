package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public abstract class Opcion {
    protected String texto;
    public Opcion(String unTexto){
        this.texto=unTexto;
        }
    public abstract void evaluar(Puntaje unPuntaje);
    public String texto(){
        return this.texto;
    }
}
