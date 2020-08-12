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

        if(tipoPregunta.equals("VF")) {
            PreguntaVF preguntaVF = new PreguntaVF(textoPregunta, puntajePregunta);
            generarOpcionesVF(preguntaVF, preguntaJSON);
            pregunta = preguntaVF;
        }
        else if(tipoPregunta.equals("MultipleChoice")) {
            PreguntaMultipleChoice preguntaMC = new PreguntaMultipleChoice(textoPregunta, puntajePregunta);
            generarOpcionesMultipleChoice(preguntaMC, preguntaJSON);
            pregunta = preguntaMC;
        }
        else if(tipoPregunta.equals("OrderedChoice")) {
            PreguntaOrderedChoice preguntaOC = new PreguntaOrderedChoice(textoPregunta);
            generarOpcionesOrderedChoice(preguntaOC, preguntaJSON);
            pregunta = preguntaOC;
        }
        else if(tipoPregunta.equals("GroupChoice")) {
            PreguntaGroupChoice preguntaGP = new PreguntaGroupChoice(textoPregunta);
            generarOpcionesGroupChoice(preguntaGP, preguntaJSON);
            pregunta = preguntaGP;
        }
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

    private static void generarOpcionesVF(PreguntaVF pregunta, JSONObject preguntaJSON) {
        try {
            pregunta.agregarOpcionCorrecta((String)preguntaJSON.get("opcionCorrecta"));
            pregunta.agregarOpcionIncorrecta((String)preguntaJSON.get("opcionIncorreta"));
        } catch (JSONException e) {}
    }

    private static void generarOpcionesMultipleChoice(PreguntaMultipleChoice pregunta, JSONObject preguntaJSON) {
        try {
            for(Object opcionCorrecta : preguntaJSON.getJSONArray("opcionesCorrectas"))
                pregunta.agregarOpcionCorrecta((String)opcionCorrecta);

            for(Object opcionIncorrecta : preguntaJSON.getJSONArray("opcionesIncorrectas"))
                pregunta.agregarOpcionCorrecta((String)opcionIncorrecta);
        } catch (JSONException e) {}
    }

    private static void generarOpcionesOrderedChoice(PreguntaOrderedChoice pregunta, JSONObject preguntaJSON) {
        try {
            JSONArray opciones = preguntaJSON.getJSONArray("opciones");
            for(int i = 0; i < opciones.length(); i++)
                pregunta.agregarOpcion((String)opciones.get(i), i + 1);

        } catch (JSONException e) {}
    }

    private static void generarOpcionesGroupChoice(PreguntaGroupChoice pregunta, JSONObject preguntaJSON) {
        try {
            for(Object opcionG1 : preguntaJSON.getJSONArray("grupo1"))
                pregunta.agregarOpcion((String)opcionG1, 1);

            for(Object opcionG2 : preguntaJSON.getJSONArray("grupo2"))
                pregunta.agregarOpcion((String)opcionG2, 2);
        } catch (JSONException e) {}
    }
}
