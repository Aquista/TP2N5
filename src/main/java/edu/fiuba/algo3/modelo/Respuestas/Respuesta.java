package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public abstract class Respuesta {
    private int multiplicador;

    public abstract void evaluar(Puntaje unPuntaje);

    public abstract void agregarOpcion(Opcion unaOpcion);

    public void setMultiplicador(int unMultiplicador){
        multiplicador = unMultiplicador;
    }

    public void agregarMultiplicador(Puntaje unPuntaje){
        unPuntaje.setMultiplicador(this.multiplicador);
    }
}
