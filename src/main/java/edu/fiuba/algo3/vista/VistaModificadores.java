package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ElegirExclusividadEventHandler;
import edu.fiuba.algo3.controlador.ElegirMultiplicadorEventHandler;
import edu.fiuba.algo3.modelo.Jugadores.Jugador;
import edu.fiuba.algo3.modelo.Modificadores.Exclusividad;
import edu.fiuba.algo3.modelo.Modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeConPenalidad;
import edu.fiuba.algo3.modelo.Ronda;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class VistaModificadores extends VBox {
    private Ronda ronda;

    public VistaModificadores(Ronda ronda) {
        this.ronda = ronda;
        this.getStyleClass().add("contenedor-modificadores");
        this.setSpacing(10);
        agregarInfo();
    }

    public void agregarInfo() {
        Puntaje puntajePregunta = ronda.getPregunta().getPuntaje();
        if(puntajePregunta.getClass() == PuntajeConPenalidad.class)
            mostrarMultiplicadores();
        else
            mostrarExclusividad();
    }

    private void mostrarMultiplicadores() {
        Jugador jugador = ronda.getJugador();
        ArrayList<Multiplicador> multiplicadores = jugador.getMultiplicadores();

        for(Multiplicador multiplicador : multiplicadores) {
            Button boton = new Button(multiplicador.texto());
            boton.getStyleClass().add("modificador");
            ElegirMultiplicadorEventHandler eventoBoton = new ElegirMultiplicadorEventHandler(jugador, multiplicador, this, boton);
            boton.setOnAction(eventoBoton);
            this.getChildren().add(boton);
        }
    }

    private void mostrarExclusividad() {
        Jugador jugador = ronda.getJugador();
        ArrayList<Exclusividad> exclusividades = jugador.getExclusividades();

        for(Exclusividad exclusividad : exclusividades) {
            Button boton = new Button(exclusividad.texto());
            boton.getStyleClass().add("modificador");
            ElegirExclusividadEventHandler eventoBoton = new ElegirExclusividadEventHandler(jugador, exclusividad, this, boton);
            boton.setOnAction(eventoBoton);
            this.getChildren().add(boton);
        }
    }
    public void deshabilitarBotones(Button bottonSeleccionado) {
        for(Node boton : this.getChildren()) {
            boton.setDisable(true);
            boton.getStyleClass().add("modificador-deshabilitado");
        }
        bottonSeleccionado.getStyleClass().add("modificador-seleccionado");
    }
}
