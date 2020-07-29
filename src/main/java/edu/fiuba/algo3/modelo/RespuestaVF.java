package edu.fiuba.algo3.modelo;

public class RespuestaVF implements IRespuesta{
    private Opcion opcion;
    public RespuestaVF(){
    }
    public void agregarOpcion(Opcion unaOpcion){
        this.opcion=unaOpcion;
    }
    
    public void evaluar(IPuntaje unPuntaje){
        this.opcion.evaluar(unPuntaje);
    }
}
