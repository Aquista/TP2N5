package edu.fiuba.algo3.modelo.RespuestaTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaVF;
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
