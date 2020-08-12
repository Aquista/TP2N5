package edu.fiuba.algo3.modelo.Panel;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;

import java.util.ArrayList;

public class Panel {
    private Jugador primerJugador;
    private Jugador segundoJugador;
    private ControlTurnos turnos;
    private ArrayList<Jugador> jugadores;
    private ArrayList<PreguntaVF> preguntas;

    public Panel (){
        this.jugadores=new ArrayList<>();
        this.preguntas=this.preguntas();
    }
    public Panel(ArrayList<Jugador> jugadores) {
        this.primerJugador=jugadores.get(0);
        this.segundoJugador=jugadores.get(1);
    }
    public Jugador ganador(){
        return this.primerJugador.ganador(this.segundoJugador);
    }
    public int cantJugadores(){
        return this.jugadores.size();
    }
    public void agregarJugador(Jugador unJugador){
        this.jugadores.add(unJugador);
    }
    public void iniciarJuego(){
        this.primerJugador=this.jugadores.get(0);
        this.segundoJugador=this.jugadores.get(1);
        this.turnos=new ControlTurnos(this.preguntas,this.primerJugador,this.segundoJugador);
        this.turnos.iniciarJuego();
    }
    public Jugador jugadorActual(){
        return this.turnos.jugadorActual();
    }
    public boolean pasarTurno(){
        this.turnos.cambiarTurno();
        return this.turnos.cambiarPregunta();
    }
    public ArrayList<PreguntaVF> preguntas(){
        PreguntaVF pregunta1=new PreguntaVF("A",new PuntajeClasico());
        pregunta1.agregarOpcionCorrecta("True");
        pregunta1.agregarOpcionIncorrecta("False");
        PreguntaVF pregunta2=new PreguntaVF("B",new PuntajeClasico());
        pregunta2.agregarOpcionCorrecta("True");
        pregunta2.agregarOpcionIncorrecta("False");
        PreguntaVF pregunta3=new PreguntaVF("C",new PuntajeClasico());
        pregunta3.agregarOpcionCorrecta("True");
        pregunta3.agregarOpcionIncorrecta("False");
        PreguntaVF pregunta4=new PreguntaVF("D",new PuntajeClasico());
        pregunta4.agregarOpcionCorrecta("True");
        pregunta4.agregarOpcionIncorrecta("False");
        PreguntaVF pregunta5=new PreguntaVF("E",new PuntajeClasico());
        pregunta5.agregarOpcionCorrecta("True");
        pregunta5.agregarOpcionIncorrecta("False");
        ArrayList<PreguntaVF> lista=new ArrayList<>();
        lista.add(pregunta1);
        lista.add(pregunta2);
        lista.add(pregunta3);
        lista.add(pregunta4);
        lista.add(pregunta5);
        return lista;
    }
    public PreguntaVF preguntaActual(){
        return this.turnos.preguntaActual();
    }
}
