package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVF implements IPregunta{
    private ArrayList<IRespuesta> respuestas;
    private int puntos;
    public PreguntaVF(ArrayList<IRespuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public void evaluarJugadores(ArrayList<Jugador> jugadores) {
        ArrayList<Marcador> marcadores = new ArrayList<Marcador>();

        for(Jugador jugador : jugadores) {
            Marcador marcador = new Marcador(jugador);
            jugador.evaluarRespuestas(marcador);
            marcadores.add(marcador);
        }

        actualizarPuntajes(marcadores);
    }

    private void actualizarPuntajes(ArrayList<Marcador> marcadores) {
        Jugador jugadorActual;

        for(Marcador marcador : marcadores) {
            jugadorActual = marcador.getJugador();
            jugadorActual.actualizarPuntaje(marcador.getRespuestasCorrectas());
        }
    }
}
