package edu.fiuba.algo3.modelo;

public class RespuestaCorrecta implements IRespuesta{
    String texto;

    public RespuestaCorrecta(String texto) {
        this.texto = texto;
    }

    public void evaluar(IPuntaje unPuntaje ) {
        unPuntaje.sumarCorrecta();
    }
}
