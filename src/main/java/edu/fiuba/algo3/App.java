package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.vista.VistaPanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        PreguntaVF pregunta = new PreguntaVF("El patron Poxi existe?",new PuntajeClasico());
        OpcionCorrecta oCorrecta= new OpcionCorrecta("True");
        OpcionIncorrecta oIncorrecta = new OpcionIncorrecta("False");
        pregunta.agregarOpcionCorrecta(oCorrecta);
        pregunta.agregarOpcionIncorrecta(oIncorrecta);
        VistaPanel panelPrincipal=new VistaPanel(pregunta);
        Scene scene=new Scene(panelPrincipal,600,600);
        stage.setScene(scene);
        stage.show();
    }

}