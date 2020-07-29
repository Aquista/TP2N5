package edu.fiuba.algo3.modelo;

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
