package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Panel.Panel;
import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.vista.*;
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
        /*PreguntaGroupChoice pregunta = new PreguntaGroupChoice("1) Grandes de América 2) Hijos");
        OpcionConGrupo op1 = pregunta.agregarOpcion("Boca", 1);
        OpcionConGrupo op2 = pregunta.agregarOpcion("Racing", 2);
        OpcionConGrupo op3 = pregunta.agregarOpcion("San Lorenzo", 2);
        OpcionConGrupo op4 = pregunta.agregarOpcion("Independiente", 1);
        OpcionConGrupo op5 = pregunta.agregarOpcion("River", 2);

        Jugador jugador = new Jugador("JUGADOR");
        VistaPreguntaGroupChoice vistaPre = new VistaPreguntaGroupChoice(jugador, pregunta);
        Scene scene = new Scene(vistaPre,800,600);*/
        Panel panel = new Panel();
        VistaPrincipal pantallaPrincipal=new VistaPrincipal(stage,panel);
        Scene scene=new Scene(pantallaPrincipal,800,600);
        stage.setScene(scene);
        stage.show();
    }

}