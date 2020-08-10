package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreadorDePreguntasTest {
    @Test
    public void test01Creo1PreguntaAPartirDeUnArchivoCon1Pregunta() {
        int cantidadDePreguntasEsperada = 1;

        List<Pregunta> preguntas = CreadorDePreguntas.generarPreguntas("test01.json");

        assertEquals(cantidadDePreguntasEsperada, preguntas.size());
    }
    @Test
    public void test02Creo4PreguntasAPartirDeUnArchivoCon4Preguntas() {
        int cantidadDePreguntasEsperada = 4;

        List<Pregunta> preguntas = CreadorDePreguntas.generarPreguntas("test02.json");

        assertEquals(cantidadDePreguntasEsperada, preguntas.size());
    }

}
