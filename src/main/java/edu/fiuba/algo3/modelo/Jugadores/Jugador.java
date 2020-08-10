package edu.fiuba.algo3.modelo.Jugadores;

import edu.fiuba.algo3.modelo.Modificadores.*;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.*;

import java.util.ArrayList;

public class Jugador {
    private int puntaje = 0;
    private JugadorDeTipo tipoDeJugador = null;
    private ArrayList<Multiplicador> multiplicadores = new ArrayList<Multiplicador>();
    private ArrayList<Exclusividad> exclusividades = new ArrayList<Exclusividad>();

    private Multiplicador multiplicadorActivo = new MultiplicadorX1();
    private Exclusividad exclusividadActiva = new ExclusividadNula();


    public Jugador() {
        multiplicadores.add(new MultiplicadorX2());
        multiplicadores.add(new MultiplicadorX3());
        exclusividades.add(new ExclusividadSimple());
        exclusividades.add(new ExclusividadSimple());
    }
    public void actualizarPuntaje(int puntos) {
        puntaje += puntos;
        if(puntaje < 0) {
            puntaje = 0;
        }
    }
    public int getPuntaje() {
        return puntaje;
    }
    public void evaluarRespuestas(Puntaje unPuntaje) {
        if (tipoDeJugador != null){
            this.tipoDeJugador.evaluar(unPuntaje);
        }
    }

    public void aplicarMultiplicador(Puntaje puntaje) {
        multiplicadorActivo.multiplicar(puntaje);
        multiplicadorActivo = new MultiplicadorX1();
    }
    public void aplicarExclusividad(Puntaje puntaje1, Puntaje puntaje2) {
        exclusividadActiva.aplicar(puntaje1, puntaje2);
        exclusividadActiva = new ExclusividadNula();
    }
    public void seleccionarMultiplicador(int codigoMultiplicador) {
        if(multiplicadores.get(codigoMultiplicador) != null) {
            multiplicadorActivo = multiplicadores.get(codigoMultiplicador);
            multiplicadores.remove(codigoMultiplicador);
        }
    }
    public void seleccionarExclusividad(int codigoExclusividad) {
        if(exclusividades.get(codigoExclusividad) != null) {
            exclusividadActiva = exclusividades.get(codigoExclusividad);
            exclusividades.remove(codigoExclusividad);
        }
    }

    public Respuesta responder(JugadorDeTipo tipo, Opcion... opciones){
        this.tipoDeJugador = tipo;
        return tipoDeJugador.responder(opciones);
    }

    public Jugador ganador(Jugador segundoJugador) {
        if(segundoJugador.tengoMasPuntaje(this.puntaje)){
            return segundoJugador;
        }else{
            return this;
        }
    }

    private boolean tengoMasPuntaje(int unPuntaje) {
        return this.puntaje>unPuntaje;
    }
}
