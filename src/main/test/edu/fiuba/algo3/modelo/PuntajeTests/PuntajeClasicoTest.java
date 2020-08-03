package edu.fiuba.algo3.modelo.PuntajeTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeClasicoTest {
    @Test
    public void test01PuntajeClasicoAgrega1PuntoSiLaOpcionEsCorrecta(){
        
        PuntajeClasico unPuntaje = new PuntajeClasico();
        OpcionCorrecta opcion = new OpcionCorrecta("true");
        opcion.evaluar(unPuntaje);
        unPuntaje.calcularPuntaje(1);
        
        assertEquals(1,unPuntaje.getPuntos() );
    }
    @Test
    public void test02PuntajeClasicoNoSumaPuntoNiRestaSiLaOpcionEsIncorrecta(){

        int puntosesperados = 0;

        PuntajeClasico unPuntaje = new PuntajeClasico();

        OpcionIncorrecta opcion = new OpcionIncorrecta("true");
        opcion.evaluar(unPuntaje);
        unPuntaje.calcularPuntaje(1);

        assertEquals(puntosesperados,unPuntaje.getPuntos() );
    }

    @Test
    public void test03PuntajeClasicoSuma1PuntoSiTodasLasOpcionesSonCorrectas(){
        PuntajeClasico unPuntaje = new PuntajeClasico();
        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");
        OpcionCorrecta opcion3 = new OpcionCorrecta("");
        
        opcion1.evaluar(unPuntaje);
        opcion2.evaluar(unPuntaje);
        opcion3.evaluar(unPuntaje);
        
        unPuntaje.calcularPuntaje(3);
        assertEquals(1,unPuntaje.getPuntos() );
    }

    @Test
    public void test04PuntajeClasicoSuma0PuntosSiSon3OpcionesCorrectasde3Y1Incorrecta(){
        PuntajeClasico unPuntaje = new PuntajeClasico();
        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");
        OpcionCorrecta opcion3 = new OpcionCorrecta("");
        OpcionIncorrecta opcion4 = new OpcionIncorrecta("");

        opcion1.evaluar(unPuntaje);
        opcion2.evaluar(unPuntaje);
        opcion3.evaluar(unPuntaje);
        opcion4.evaluar(unPuntaje);
        
        unPuntaje.calcularPuntaje(3);
        assertEquals(0,unPuntaje.getPuntos());
    }

    @Test
    public void test05PuntajeClasicoSuma0PuntosSiSon2OpcionesCorrectasde3Y1Incorrecta(){
        PuntajeClasico unPuntaje = new PuntajeClasico();
        OpcionCorrecta opcion1 = new OpcionCorrecta("");
        OpcionCorrecta opcion2 = new OpcionCorrecta("");
        OpcionIncorrecta opcion3 = new OpcionIncorrecta("");

        opcion1.evaluar(unPuntaje);
        opcion2.evaluar(unPuntaje);
        opcion3.evaluar(unPuntaje);

        unPuntaje.calcularPuntaje(3);
        assertEquals(0,unPuntaje.getPuntos() );
    }

    @Test
    public void test06PuntajeClasicoSuma0PuntosSiEs1OpcionCorrectaDe2(){
        PuntajeClasico unPuntaje = new PuntajeClasico();
        OpcionCorrecta opcion1 = new OpcionCorrecta("");

        opcion1.evaluar(unPuntaje);
        
        unPuntaje.calcularPuntaje(2);
        assertEquals(0,unPuntaje.getPuntos() );
    }
}
