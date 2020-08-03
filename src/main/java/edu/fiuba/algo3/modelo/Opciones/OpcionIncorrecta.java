package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class OpcionIncorrecta implements Opcion {
    private String texto;

    public OpcionIncorrecta(String unTexto) {
        this.texto = unTexto;
    }

    @Override
    public void evaluar(Puntaje unPuntaje) {
        unPuntaje.sumarIncorrecta();
    }
}
