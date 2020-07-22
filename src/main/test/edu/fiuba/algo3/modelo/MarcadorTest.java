package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarcadorTest {
    @Test
    public void test01ElMarcadorAlInicioTiene0respuestasCorrectas(){
        Marcador marcador = new Marcador(new Jugador());
        assertEquals(0,marcador.getRespuestasCorrectas());
    }
    @Test
    public void test02ElMarcadorAlInicioTiene0RespuestasIncorrectas(){
        Marcador marcador = new Marcador(new Jugador());
        assertEquals(0,marcador.getRespuestasIncorrectas());
    }
}
