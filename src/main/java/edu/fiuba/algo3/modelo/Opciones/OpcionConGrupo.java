package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class OpcionConGrupo implements Opcion{
    private String texto;
    int grupoCorrecto;
    int grupoSeleccionado = 0;

    public OpcionConGrupo(String unTexto, int grupoCorrecto) {
        this.texto = unTexto;
        this.grupoCorrecto = grupoCorrecto;
    }

    public void evaluar(Puntaje unPuntaje) {
        if(grupoCorrecto == grupoSeleccionado)
            unPuntaje.sumarCorrecta();
        else
            unPuntaje.sumarIncorrecta();
    }
}
