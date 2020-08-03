package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class OpcionConOrden implements Opcion{
    private String texto;
    int ordenCorrecto;
    int ordenSeleccionado = 0;

    public OpcionConOrden(String unTexto, int ordenCorrecto) {
        this.texto = unTexto;
        this.ordenCorrecto = ordenCorrecto;
    }

    public void evaluar(Puntaje unPuntaje) {
        if(ordenCorrecto == ordenSeleccionado)
            unPuntaje.sumarCorrecta();
        else
            unPuntaje.sumarIncorrecta();
    }

    public void seleccionarOrden(int ordenSeleccionado) {
        this.ordenSeleccionado = ordenSeleccionado;
    }

    public OpcionConOrden duplicar() {
        return new OpcionConOrden(texto, ordenCorrecto);
    }
}
