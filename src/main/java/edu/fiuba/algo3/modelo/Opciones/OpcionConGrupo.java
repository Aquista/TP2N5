package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class OpcionConGrupo extends Opcion{
    int grupoCorrecto;
    int grupoSeleccionado = 0;

    public OpcionConGrupo(String unTexto, int grupoCorrecto) {
        super(unTexto);
        this.grupoCorrecto = grupoCorrecto;
    }

    public void evaluar(Puntaje unPuntaje) {
        if(grupoCorrecto == grupoSeleccionado)
            unPuntaje.sumarCorrecta();
        else
            unPuntaje.sumarIncorrecta();
    }
    public void seleccionarGrupo(int grupoSeleccionado){
        this.grupoSeleccionado = grupoSeleccionado;
    }

    public OpcionConGrupo duplicar() {
        return new OpcionConGrupo(texto, grupoCorrecto);
    }
}
