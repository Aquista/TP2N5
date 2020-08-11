package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import javafx.scene.layout.BorderPane;

public class VistaPanel extends BorderPane {
    public VistaPanel(Jugador jugador){
        PreguntaVF unaPregunta= new PreguntaVF("Aprobamos?",new PuntajeClasico());
        unaPregunta.agregarOpcionCorrecta("True");
        unaPregunta.agregarOpcionIncorrecta("False");
        VistaJugador vistaJu=new VistaJugador(jugador);
        VistaPreguntaVF vistaPre=new VistaPreguntaVF(jugador, unaPregunta);
        this.setCenter(vistaPre);
        this.setLeft(vistaJu);
    }
}
