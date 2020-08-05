package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class OpcionCorrecta extends Opcion {

    public OpcionCorrecta(String unTexto) {
        super(unTexto);
    }
    
    @Override
    public void evaluar(Puntaje unPuntaje) {
        unPuntaje.sumarCorrecta();
    }
}
