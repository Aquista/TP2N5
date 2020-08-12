package edu.fiuba.algo3.Controladores;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Panel.Panel;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.vista.VistaPanel;
import edu.fiuba.algo3.vista.finalScenes.VistaFinal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AsignarRespuestaVFEventHandler implements EventHandler<ActionEvent> {
    private Jugador jugador;
    private Pregunta pregunta;
    private Opcion opcionSeleccionada;
    private VistaPanel vPanel;
    private Panel panel;
    private Stage stage;

    public AsignarRespuestaVFEventHandler(Stage stage,Jugador jugador, Pregunta pregunta, Opcion seleccionada, VistaPanel vPanel,Panel panel) {
        this.jugador = jugador;
        this.pregunta = pregunta;
        this.opcionSeleccionada = seleccionada;
        this.vPanel=vPanel;
        this.panel=panel;
        this.stage=stage;
    }

    @Override
    public void handle(ActionEvent event) {
        jugador.responder(pregunta.tipo(), this.opcionSeleccionada);
        boolean fin = this.panel.pasarTurno();
        if(!fin){
            this.vPanel.actulizarVistaPanel();
        }else{
            Jugador ganador=this.panel.ganador();
            System.out.println(ganador.nombre());
            VistaFinal vFinal = new VistaFinal(ganador,this.stage);
            Scene scene = new Scene(vFinal,800,600);
            this.stage.setScene(scene);
        }
    }
}
