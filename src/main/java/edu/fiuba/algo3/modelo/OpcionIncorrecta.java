package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Puntajes.IPuntaje;

public class OpcionIncorrecta implements Opcion{
    private String texto;

    public OpcionIncorrecta(String unTexto) {
        this.texto = unTexto;
    }

    @Override
    public void evaluar(IPuntaje unPuntaje) {
        unPuntaje.sumarIncorrecta();
    }
}
