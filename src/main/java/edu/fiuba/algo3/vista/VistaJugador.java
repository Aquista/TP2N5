package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaJugador extends VBox {
    private Jugador jugador;
    public VistaJugador (Jugador unJugador){
        this.jugador=unJugador;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPrefWidth(200);
        this.agregarInfo();
    }
    public void agregarInfo(){
        Label nombre = new Label(this.jugador.nombre());
        nombre.setStyle("-fx-font-size: 30px");
        Label puntos= new Label(Integer.toString(this.jugador.getPuntaje()));
        puntos.setStyle("-fx-font-size: 30px");
        this.getChildren().addAll(nombre,puntos);
    }
}
