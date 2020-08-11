package edu.fiuba.algo3.vista;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Panel.Panel;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class VistaPanel extends BorderPane {
    private Panel panel;
    public VistaPanel(Panel panel){
        this.panel=panel;
        PreguntaVF unaPregunta= new PreguntaVF("Aprobamos?",new PuntajeClasico());
        unaPregunta.agregarOpcionCorrecta("True");
        unaPregunta.agregarOpcionIncorrecta("False");
        VistaJugador vistaJu=new VistaJugador(this.panel.jugadorActual());
        VistaPreguntaVF vistaPre=new VistaPreguntaVF(this.panel.jugadorActual(), unaPregunta);
        this.setCenter(vistaPre);
        this.setLeft(vistaJu);
    }
}
