package edu.fiuba.algo3.modelo;

public class RespuestaIncorrecta implements IRespuesta{
    String texto;

    public RespuestaIncorrecta(String texto) {
        this.texto = texto;
    }

    public void evaluar(Marcador marcador) {
        marcador.sumarRespuestasIncorrectas();
    }
}
