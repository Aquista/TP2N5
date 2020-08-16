package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.vista.VistaModificadores;
import edu.fiuba.algo3.vista.VistaPregunta;
import edu.fiuba.algo3.vista.VistaPreguntasFactory;
import edu.fiuba.algo3.vista.VistaPuntajes;
import edu.fiuba.algo3.vista.finalScenes.VistaFinal;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class Panel extends BorderPane {
    private Stage stage;
    private VistaModificadores vistaModificadores;
    private VistaPregunta vistaPregunta;
    private VistaPuntajes vistaPuntajes;
    private Kahoot kahoot;
    private Ronda ronda;

    public Panel(Kahoot kahoot, Stage stage) {
        this.kahoot = kahoot;
        this.stage = stage;
    }
    public void empezarPartida() {
        kahoot.empezarPartida();
        Scene scene = new Scene(this,800,600);
        stage.setScene(scene);
        ArrayList<Jugador> jugadores = kahoot.getJugadores();
        vistaPuntajes = new VistaPuntajes(jugadores.get(0), jugadores.get(1));

        avanzarRonda();

    }

    public void avanzarRonda() {
        ronda = kahoot.avanzarRonda();
        if(ronda == null)
            mostrarResultadosFinales();
        else
            avanzarTurno();


        actualizar();
    }

    public void actualizar() {
        setCenter(vistaPregunta);
        vistaPuntajes.actualizar();
        setBottom(vistaPuntajes);
        setLeft(vistaModificadores);
        /*vistaModificadores.actualizar();
        vistaPregunta.actualizar();
        vistaPuntajes.actualizar();*/
    }

    private void mostrarResultadosFinales() {
        ArrayList<Jugador> jugadores = kahoot.getJugadores();

        Collections.sort(jugadores);
        VistaFinal vistaFinal = new VistaFinal(jugadores.get(0), jugadores.get(1));
        Scene escenaFinal = new Scene(vistaFinal,800,600);
        stage.setScene(escenaFinal);
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void avanzarTurno() {
        ronda.avanzarTurno();

        VistaPreguntasFactory factory = new VistaPreguntasFactory();
        vistaPregunta = factory.creaVistaPregunta(ronda.getJugador(), ronda.getPregunta(), this);

        vistaModificadores = new VistaModificadores(ronda);

        actualizar();
    }
}
