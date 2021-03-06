package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Modificadores.*;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Respuestas.*;

import java.util.ArrayList;

public class Jugador implements Comparable<Jugador>{
    private String nombre;
    private int puntaje = 0;
    private ArrayList<Multiplicador> multiplicadores = new ArrayList<Multiplicador>();
    private ArrayList<Exclusividad> exclusividades = new ArrayList<Exclusividad>();

    private Multiplicador multiplicadorActivo = new MultiplicadorX1();
    private Exclusividad exclusividadActiva = new ExclusividadNula();
    private Respuesta respuestaActual = null;

    public Jugador(String unNombre) {
        this.nombre = unNombre;
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
        if(respuestaActual != null){
            this.respuestaActual.evaluar(unPuntaje);
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

    public void responder(Respuesta respuesta, Opcion ... opciones){
        respuesta.agregarOpciones(opciones);
        this.respuestaActual = respuesta;
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
