package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import javafx.scene.layout.VBox;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class PreguntaClasica extends Pregunta {
    protected ArrayList<Opcion> opciones = new ArrayList<Opcion>();

    protected int totalCorrectas = 0;

    public PreguntaClasica(String texto, Puntaje puntaje){
        super(texto, puntaje);
    }

    public void agregarOpcionCorrecta(OpcionCorrecta opcionCorrecta){
        opciones.add(opcionCorrecta);
        totalCorrectas++;
    }

    public ArrayList<Opcion> opciones(){
        return opciones;
    }

    public void agregarOpcionIncorrecta(OpcionIncorrecta opcionIncorrecta){
        opciones.add(opcionIncorrecta);
    }

}
