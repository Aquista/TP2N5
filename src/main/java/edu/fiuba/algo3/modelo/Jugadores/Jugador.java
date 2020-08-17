package edu.fiuba.algo3.modelo.Jugadores;

import edu.fiuba.algo3.modelo.Modificadores.*;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Jugador implements Comparable<Jugador>{
    private String nombre;
    private int puntaje = 0;
    private JugadorDeTipo tipoDeJugador = null;
    private ArrayList<Multiplicador> multiplicadores = new ArrayList<Multiplicador>();
    private ArrayList<Exclusividad> exclusividades = new ArrayList<Exclusividad>();

    private Multiplicador multiplicadorActivo = new MultiplicadorX1();
    private Exclusividad exclusividadActiva = new ExclusividadNula();

    public Jugador(String unNombre) {
        this.nombre = unNombre;
        multiplicadores.add(new MultiplicadorX2());
        multiplicadores.add(new MultiplicadorX3());
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

    public void seleccionarMultiplicador(Multiplicador multiplicador) {
        Multiplicador seleccionado = multiplicadores
                .stream()
                .filter(m -> m.getClass() == multiplicador.getClass())
                .findFirst()
                .get();
        if(seleccionado != null) {
            multiplicadorActivo = multiplicador;
            multiplicadores.remove(seleccionado);
        }
    }
    
    public void seleccionarExclusividad(Exclusividad exclusividad) {
        Exclusividad seleccionado = exclusividades.stream()
                .filter(e -> e.getClass() == exclusividad.getClass())
                .findFirst()
                .get();
        if(seleccionado != null) {
            exclusividadActiva = seleccionado;
            exclusividades.remove(seleccionado);
        }
    }

    public void responder(JugadorDeTipo tipo, Opcion... opciones){
        tipoDeJugador = tipo;
        tipoDeJugador.responder(opciones);
    }

    public String nombre(){
        return this.nombre;
    }

    @Override
    public int compareTo(Jugador otroJugador) {
        return otroJugador.getPuntaje() - puntaje;
    }

    public ArrayList<Multiplicador> getMultiplicadores() {
        return multiplicadores;
    }

    public ArrayList<Exclusividad> getExclusividades() {
        return exclusividades;
    }
}
