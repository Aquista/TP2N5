package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.CantidadInvalidaDeOpcionesException;
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
            try {
                preguntaActual = generarPregunta(json.getJSONObject(i));
                preguntas.add(preguntaActual);
            } catch(CantidadInvalidaDeOpcionesException | NullPointerException e ) {

            }
        }

        return preguntas;
    }

    private static Pregunta generarPregunta(JSONObject preguntaJSON) throws CantidadInvalidaDeOpcionesException{
        Puntaje puntajePregunta;
        try {
            puntajePregunta = generarPuntaje(preguntaJSON.getString("tipoPuntaje"));
        } catch (JSONException e) {
            puntajePregunta = null;
        }

        String tipoPregunta = preguntaJSON.getString("tipoPregunta");
        String textoPregunta = preguntaJSON.getString("pregunta");
        int tiempoPregunta = obtenerTiempoPregunta(preguntaJSON);

        Pregunta pregunta;

        if(tipoPregunta.equals("VF")) {
            PreguntaVF preguntaVF = new PreguntaVF(textoPregunta, puntajePregunta, tiempoPregunta);
            generarOpcionesVF(preguntaVF, preguntaJSON);
            pregunta = preguntaVF;
        }
        else if(tipoPregunta.equals("MultipleChoice")) {
            PreguntaMultipleChoice preguntaMC = new PreguntaMultipleChoice(textoPregunta, puntajePregunta, tiempoPregunta);
            generarOpcionesMultipleChoice(preguntaMC, preguntaJSON);
            pregunta = preguntaMC;
        }
        else if(tipoPregunta.equals("OrderedChoice")) {
            PreguntaOrderedChoice preguntaOC = new PreguntaOrderedChoice(textoPregunta, tiempoPregunta);
            generarOpcionesOrderedChoice(preguntaOC, preguntaJSON);
            pregunta = preguntaOC;
        }
        else if(tipoPregunta.equals("GroupChoice")) {
            PreguntaGroupChoice preguntaGP = new PreguntaGroupChoice(textoPregunta, tiempoPregunta);
            generarOpcionesGroupChoice(preguntaGP, preguntaJSON);
            pregunta = preguntaGP;
        }
        else
            pregunta = null;

        if(pregunta.getCantidadOpciones() < 2)
            throw new CantidadInvalidaDeOpcionesException();

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
            String opcionTexto = preguntaJSON.get("opcionCorrecta").toString();
            if(opcionTexto != "true" && opcionTexto != "false")
                return;

            boolean opcionCorrecta = (boolean)preguntaJSON.get("opcionCorrecta");
            pregunta.agregarOpcionCorrecta(String.valueOf(opcionCorrecta));
            pregunta.agregarOpcionIncorrecta(String.valueOf(!opcionCorrecta));

        } catch (JSONException e) {}
    }

    private static void generarOpcionesMultipleChoice(PreguntaMultipleChoice pregunta, JSONObject preguntaJSON) throws CantidadInvalidaDeOpcionesException {
        try {
            for(Object opcionCorrecta : preguntaJSON.getJSONArray("opcionesCorrectas"))
                pregunta.agregarOpcionCorrecta((String)opcionCorrecta);

            for(Object opcionIncorrecta : preguntaJSON.getJSONArray("opcionesIncorrectas"))
                pregunta.agregarOpcionIncorrecta((String)opcionIncorrecta);
        } catch (JSONException e) {}
    }

    private static void generarOpcionesOrderedChoice(PreguntaOrderedChoice pregunta, JSONObject preguntaJSON) throws CantidadInvalidaDeOpcionesException {
        try {
            JSONArray opciones = preguntaJSON.getJSONArray("opciones");
            for(int i = 0; i < opciones.length(); i++)
                pregunta.agregarOpcion((String)opciones.get(i), i + 1);

        } catch (JSONException e) {}
    }

    private static void generarOpcionesGroupChoice(PreguntaGroupChoice pregunta, JSONObject preguntaJSON) throws CantidadInvalidaDeOpcionesException {
        try {
            for(Object opcionG1 : preguntaJSON.getJSONArray("grupo1"))
                pregunta.agregarOpcion((String)opcionG1, 1);

            for(Object opcionG2 : preguntaJSON.getJSONArray("grupo2"))
                pregunta.agregarOpcion((String)opcionG2, 2);
        } catch (JSONException e) {}
    }

    private static int obtenerTiempoPregunta(JSONObject preguntaJSON) {
        int tiempo = 15;

        try {
            tiempo = preguntaJSON.getInt("tiempo");
        } catch (JSONException e) { }

        return tiempo;
    }
}
