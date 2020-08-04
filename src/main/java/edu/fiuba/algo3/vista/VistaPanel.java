package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.scene.layout.BorderPane;

public class VistaPanel extends BorderPane {
    public VistaPanel(){
        this.setStyle("-fx-background-color: #a146f1;");
        VistaPregunta vistaPre=new VistaPregunta();
        this.setCenter(vistaPre);
    }
}
