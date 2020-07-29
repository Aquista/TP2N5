package edu.fiuba.algo3.modelo;

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
