package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeParcial;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CreadorDePreguntas {
    public static List<Pregunta> generarPreguntas(String nombreArchivo) {
        String contenidoArchivo = LectorDeArchivos.leerArchivo(nombreArchivo);
        if(contenidoArchivo == null)
            return null;

        List<Pregunta> preguntas = new ArrayList<Pregunta>();
        JSONArray json = new JSONArray(contenidoArchivo);
        Pregunta preguntaActual;

        for(int i = 0; i < json.length(); i++) {
            preguntaActual = generarPregunta(json.getJSONObject(i));
            if(preguntaActual != null)
                preguntas.add(preguntaActual);
        }
        return preguntas;
    }
    private static Pregunta generarPregunta(JSONObject preguntaJSON) {
        Puntaje puntajePregunta;
        try {
            puntajePregunta = generarPuntaje(preguntaJSON.getString("tipoPuntaje"));
        } catch (JSONException e) {
            puntajePregunta = null;
        }

        String tipoPregunta = preguntaJSON.getString("tipoPregunta");
        String textoPregunta = preguntaJSON.getString("pregunta");

        Pregunta pregunta;

        if(tipoPregunta.equals("VF"))
            pregunta = new PreguntaVF(textoPregunta, puntajePregunta);
        else if(tipoPregunta.equals("MultipleChoice"))
            pregunta = new PreguntaMultipleChoice(textoPregunta, puntajePregunta);
        else if(tipoPregunta.equals("OrderedChoice"))
            pregunta = new PreguntaOrderedChoice(textoPregunta);
        else if(tipoPregunta.equals("GroupChoice"))
            pregunta = new PreguntaGroupChoice(textoPregunta);
        else
            pregunta = null;

        return pregunta;
    }
    private static Puntaje generarPuntaje(String tipoPuntaje) {
        Puntaje puntaje;
        if(tipoPuntaje.equals("Clasico"))
            puntaje = new PuntajeClasico();
        else if(tipoPuntaje.equals("ConPenalidad"))
            puntaje = new PuntajeConPenalidad();
        else if(tipoPuntaje.equals("Parcial"))
            puntaje = new PuntajeParcial();
        else
            puntaje = null;
        return puntaje;
    }
}
