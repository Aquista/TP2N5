package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class OpcionCorrecta implements Opcion{
    private String texto;

    public OpcionCorrecta(String unTexto) {
        this.texto = unTexto;
    }
    
    @Override
    public void evaluar(Puntaje unPuntaje ) {
        unPuntaje.sumarCorrecta();
    }

    @Override
    public boolean meEligio(String unTexto) {
        return unTexto.compareTo(this.texto)==0;
    }
    
}
