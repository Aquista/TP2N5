package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.*;


import java.util.ArrayList;

public abstract class Pregunta {
    private ArrayList<Opcion> opciones = new ArrayList<Opcion>();
    private int totalCorrectas = 0;


    public abstract void evaluarJugadores(ArrayList<Jugador> jugadores);

    public void agregarOpcionCorrecta(OpcionCorrecta opcionCorrecta){
        opciones.add(opcionCorrecta);
        totalCorrectas++;
    }

    public void agregarOpcionIncorrecta(OpcionIncorrecta opcionIncorrecta){
        opciones.add(opcionIncorrecta);
        totalCorrectas++;
    }
}
