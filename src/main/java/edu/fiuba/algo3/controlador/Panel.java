package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.finalScenes.VistaFinal;
import edu.fiuba.algo3.vista.VistaCambioTurno;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Panel extends BorderPane {
    private Scene scene;
    private Stage stage;
    private VistaModificadores vistaModificadores;
    private VBox vistaPregunta;
    private VistaPuntajes vistaPuntajes;
    private Kahoot kahoot;
    private Ronda ronda;

    public Panel(Kahoot kahoot, Stage stage) {
        this.kahoot = kahoot;
        this.stage = stage;
        scene = new Scene(this,1000,600);
        String pathCSS = this.getClass().getResource("/style.css").toExternalForm();
        scene.getStylesheets().add(pathCSS);
        scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Cabin:wght@700&display=swap");
        scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Viga&display=swap");
        scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Anton&display=swap");
        scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Lalezar&display=swap");

    }
    public void empezarPartida() {
        String nombreArchivo = elegirArchivo();

        if(nombreArchivo != null) {
            kahoot.empezarPartida(nombreArchivo);
            stage.setScene(scene);
            ArrayList<Jugador> jugadores = kahoot.getJugadores();
            vistaPuntajes = new VistaPuntajes(jugadores.get(0), jugadores.get(1));
            avanzarRonda();
        }
    }

    private String elegirArchivo(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir archivo de respuestas");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos JSON", "*.json"));

        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath + "/JSON"));
        File file = fileChooser.showOpenDialog(stage);

        if(file == null){
            VistaAlertaArchivoNoSeleccionado alerta = new VistaAlertaArchivoNoSeleccionado();
            alerta.showAndWait();
            return null;
        }
        return file.toString();
    }

    public void avanzarRonda() {
        ronda = kahoot.avanzarRonda();
        if(ronda == null)
            mostrarResultadosFinales();
        else
            mostrarCambioRonda();
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

    public void mostrarCambioTurno() {
        VistaCambioTurno vistaCambioTurno = new VistaCambioTurno(ronda.getJugador(),this);
        setCenter(vistaCambioTurno);
        setBottom(null);
        setLeft(null);
    }

    public void mostrarCambioRonda() {
        ArrayList<Jugador> jugadores = kahoot.getJugadores();
        VistaCambioRonda vistaCambioRonda = new VistaCambioRonda(jugadores.get(0), jugadores.get(1), this);
        setCenter(vistaCambioRonda);
        setBottom(null);
        setLeft(null);
    }

    private void mostrarResultadosFinales() {
        ArrayList<Jugador> jugadores = kahoot.getJugadores();
        Collections.sort(jugadores);
        VistaFinal vistaFinal = new VistaFinal(jugadores.get(0), jugadores.get(1));
        Scene escenaFinal = new Scene(vistaFinal,800,600);
        stage.setScene(escenaFinal);
        actualizar();
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void avanzarTurno() {
        VistaPreguntasFactory factory = new VistaPreguntasFactory();
        vistaPregunta = factory.creaVistaPregunta(ronda.getJugador(), ronda.getPregunta(), this);
        vistaModificadores = new VistaModificadores(ronda);
        actualizar();
    }
}
