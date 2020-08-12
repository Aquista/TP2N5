package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Kahoot {
    private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private Queue<Ronda> rondas = new LinkedList<Ronda>();

    private Stage stage;

    public Kahoot(Stage stage){
        this.stage = stage;
    }

    public void empezarPartida(){
        preguntas.addAll(CreadorDePreguntas.generarPreguntas("test02.json"));
        Panel panel = new Panel(stage);
        generarRondas(panel);
        avanzarRonda();
    }

    public void avanzarRonda() {
        rondas.poll().avanzarTurno();
    }

    public void generarRondas(Panel panel){
        for(Pregunta pregunta : preguntas){
            Ronda ronda = new Ronda(jugadores.get(0), jugadores.get(1), pregunta, this, panel);
            rondas.add(ronda);
        }
    }

    public void agregarJugadores(String nombreJugador1, String nombreJugador2) {
        Jugador jugador1 = new Jugador(nombreJugador1);
        Jugador jugador2 = new Jugador(nombreJugador2);

        jugadores.add(jugador1);
        jugadores.add(jugador2);
    }
}
