package edu.fiuba.algo3;


import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Panel {
    Stage stage;

    public Panel(Stage stage){
        this.stage = stage;
    }

    public void mostrarVista(Pregunta pregunta, Jugador jugador, Ronda ronda){
        VBox vistaPregunta = pregunta.crearVista(jugador, ronda);
        Scene scene = new Scene(vistaPregunta, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}
