package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.vista.VistaPanel;
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
        VistaPrincipal pantallaPrincipal=new VistaPrincipal();
        Scene scene=new Scene(pantallaPrincipal,800,600);
        stage.setScene(scene);
        stage.show();
    }

}