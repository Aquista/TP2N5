package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class RespuestaTest {
    
    @Test
    public void test01RespuestaVFConOpcionCorrectaSumaAPuntajeClasico1OpcionCorrecta(){
        OpcionCorrecta opcion = new OpcionCorrecta("texto");
        PuntajeClasico puntaje = new PuntajeClasico();
        RespuestaVF respuesta=new RespuestaVF();
        respuesta.agregarOpcion(opcion);
        respuesta.evaluar(puntaje);
        assertEquals(1,puntaje.getRespuestasCorrectas());
    }
    
    @Test
    public void test02RespuestaVFConOpcionIncorrectaSumaAPuntajeClasico1OpcionIncorrecta(){
        OpcionIncorrecta opcion = new OpcionIncorrecta("texto");
        PuntajeClasico puntaje = new PuntajeClasico();
        RespuestaVF respuesta=new RespuestaVF();
        respuesta.agregarOpcion(opcion);
        respuesta.evaluar(puntaje);
        assertEquals(1,puntaje.getRespuestasIncorrectas());
    }
}
