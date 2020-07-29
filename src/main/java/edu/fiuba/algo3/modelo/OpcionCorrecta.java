package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Puntajes.IPuntaje;

public class OpcionCorrecta implements Opcion{
    private String texto;

    public OpcionCorrecta(String unTexto) {
        this.texto = unTexto;
    }
    
    @Override
    public void evaluar(IPuntaje unPuntaje ) {
        unPuntaje.sumarCorrecta();
    }
}
