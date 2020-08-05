package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class OpcionIncorrecta extends Opcion {

    public OpcionIncorrecta(String unTexto) {
        super(unTexto);
    }

    @Override
    public void evaluar(Puntaje unPuntaje) {
        unPuntaje.sumarIncorrecta();
    }
}
