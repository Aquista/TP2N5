package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionConOrden;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaOrderedChoice;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.vista.VistaPanel;
import edu.fiuba.algo3.vista.VistaPreguntaMultipleChoice;
import edu.fiuba.algo3.vista.VistaPreguntaOrderedChoice;
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
        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice("Ordenar numeros");
        OpcionConOrden op1 = pregunta.agregarOpcion("3", 3);
        OpcionConOrden op2 = pregunta.agregarOpcion("1", 1);
        OpcionConOrden op3 = pregunta.agregarOpcion("4", 4);
        OpcionConOrden op4 = pregunta.agregarOpcion("2", 2);

        Jugador jugador = new Jugador();
        VistaPreguntaOrderedChoice vistaPre = new VistaPreguntaOrderedChoice(jugador, pregunta);
        Scene scene = new Scene(vistaPre,800,600);
        //VistaPrincipal pantallaPrincipal=new VistaPrincipal(stage);
        //Scene scene=new Scene(pantallaPrincipal,800,600);
        stage.setScene(scene);
        stage.show();
    }

}