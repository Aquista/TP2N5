package edu.fiuba.algo3.vista.finalScenes;

import edu.fiuba.algo3.Controladores.BotonSalir;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaFinal extends VBox {

    public VistaFinal(Jugador unJugador, Stage stage){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPrefWidth(200);
        Label nombreGanador =  new Label(unJugador.nombre());
        nombreGanador.setStyle("-fx-font-size: 20px;-fx-text-fill: #ff8080");
        Button botonSalir = new Button("Salir");
        botonSalir.setStyle("-fx-font-size: 20px");
        BotonSalir accion = new BotonSalir(stage);
        botonSalir.setOnAction(accion);
        this.getChildren().addAll(nombreGanador,botonSalir);
    }
}
