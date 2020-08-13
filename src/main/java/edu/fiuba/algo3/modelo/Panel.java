package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.vista.VistaPreguntasFactory;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Panel {
    Stage stage;

    public Panel(Stage stage){
        this.stage = stage;
    }

    public void mostrarVista(Pregunta pregunta, Jugador jugador, Ronda ronda){
        VistaPreguntasFactory factory = new VistaPreguntasFactory();
        VBox vistaPregunta = factory.creaVistaPregunta(jugador, pregunta, ronda);
        Scene scene = new Scene(vistaPregunta, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}
