package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import javafx.scene.layout.BorderPane;

public class VistaPanel extends BorderPane {
    public VistaPanel(Jugador jugador, PreguntaVF unaPregunta){
        this.setStyle("-fx-background-color: #a146f1;");
        VistaPreguntaVF vistaPre=new VistaPreguntaVF(jugador, unaPregunta);
        this.setCenter(vistaPre);
    }
}
