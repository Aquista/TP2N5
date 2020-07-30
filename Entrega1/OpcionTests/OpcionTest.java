package edu.fiuba.algo3.modelo.OpcionTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import org.junit.jupiter.api.Test;

public class OpcionTest {
    
    @Test
    public void test01OpcionCorrectaSumaAPuntajeClasico1OpcionCorrecta() {
        int cantidadDeOpcionesCorrectas = 1;
        OpcionCorrecta opcion = new OpcionCorrecta("correcta");
        PuntajeClasico unPuntaje = new PuntajeClasico();
        opcion.evaluar(unPuntaje);
        assertEquals(cantidadDeOpcionesCorrectas,unPuntaje.getRespuestasCorrectas());
    }
    
    @Test
    public void test02OpcionIncorrectaSumaAPuntajeClasico1OpcionIncorrecta() {
        int cantidadDeOpcionesIncorrectas = 1;
        OpcionIncorrecta opcion = new OpcionIncorrecta("incorrecta");
        PuntajeClasico unPuntaje = new PuntajeClasico();
        opcion.evaluar(unPuntaje);
        assertEquals(cantidadDeOpcionesIncorrectas,unPuntaje.getRespuestasIncorrectas());
    }
}
