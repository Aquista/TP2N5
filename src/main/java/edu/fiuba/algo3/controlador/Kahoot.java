package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.vista.finalScenes.VistaFinal;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
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
        if(!rondas.isEmpty())
            rondas.poll().avanzarTurno();
        else
            mostrarResultadosFinales();
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

    private void mostrarResultadosFinales() {
        Collections.sort(jugadores);
        VistaFinal vistaFinal = new VistaFinal(jugadores.get(0), jugadores.get(1));
        Scene escenaFinal = new Scene(vistaFinal,800,600);
        stage.setScene(escenaFinal);
    }
}
