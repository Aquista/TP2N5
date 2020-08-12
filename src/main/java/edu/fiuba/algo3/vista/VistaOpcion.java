package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.Controladores.AsignarRespuestaVFEventHandler;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Panel.Panel;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVF;
import javafx.scene.control.Button;

public class VistaOpcion extends Button {
    private Opcion opcion;
    private Jugador jugador;
    private PreguntaVF pregunta;
    public VistaOpcion(Opcion unaOpcion, PreguntaVF unaPregunta, Jugador unJugador, VistaPanel vPanel, Panel panel){
        this.opcion=unaOpcion;
        this.jugador=unJugador;
        this.pregunta=unaPregunta;
        this.setText(this.opcion.texto());
        this.setStyle("-fx-font-size: 20px");
        AsignarRespuestaVFEventHandler accion = new AsignarRespuestaVFEventHandler(this.jugador,this.pregunta,this.opcion,vPanel,panel);
        this.setOnAction(accion);
    }
}
