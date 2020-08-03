package edu.fiuba.algo3.modelo.PuntajeTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeConPenalidadTest {
    @Test
    public void test01PuntajeConPenalidadAgrega1PuntoSiLasOpcionesSonCorrectas(){
        PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();
        OpcionCorrecta opcion = new OpcionCorrecta("true");
        opcion.evaluar(unPuntaje);
        
        unPuntaje.calcularPuntaje(0);
        assertEquals(1, unPuntaje.getPuntos());
    }
    @Test
    public void test02PuntajeConPenalidadSaca1PuntoSiHay1OpcionIncorrecta(){

        PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad();
        OpcionIncorrecta opcion = new OpcionIncorrecta("true");
        opcion.evaluar(unPuntaje);

        unPuntaje.calcularPuntaje(0);
        assertEquals(-1, unPuntaje.getPuntos());
    }
    @Test
    public void test03PuntajeConPenalidadYMultiplicadorx2Agrega2PuntosSiHay1OpcionCorrecta(){
        PuntajeConPenalidad unPuntaje = new PuntajeConPenalidad(2);
        OpcionCorrecta opcion = new OpcionCorrecta("true");
        opcion.evaluar(unPuntaje);
   
        unPuntaje.calcularPuntaje(0);
        assertEquals(2, unPuntaje.getPuntos());
    }
}
