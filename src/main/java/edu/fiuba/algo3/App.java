package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.vista.VistaPanel;
import edu.fiuba.algo3.vista.VistaPreguntaMultipleChoice;
import edu.fiuba.algo3.vista.VistaPreguntaVF;
import edu.fiuba.algo3.vista.inicioScenes.VistaPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice("Que lenguajes de programación vimos en Algoritmos 3?", new PuntajeClasico());
        OpcionCorrecta op1 = pregunta.agregarOpcionCorrecta("Smalltalk");
        OpcionCorrecta op2 = pregunta.agregarOpcionCorrecta("Java");
        OpcionIncorrecta op3 = pregunta.agregarOpcionIncorrecta("Python");
        OpcionIncorrecta op4 = pregunta.agregarOpcionIncorrecta("C");

        Jugador jugador = new Jugador();

        //VistaPanel panel = new VistaPanel(jugador, pregunta);
        VistaPreguntaMultipleChoice vistaPre = new VistaPreguntaMultipleChoice(jugador, pregunta);
        Scene scene = new Scene(vistaPre,800,600);
        stage.setScene(scene);
        stage.show();
    }

}