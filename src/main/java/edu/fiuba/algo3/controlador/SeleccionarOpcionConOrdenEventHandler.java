package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Opciones.OpcionConOrden;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class SeleccionarOpcionConOrdenEventHandler implements EventHandler<ActionEvent> {
    ArrayList<OpcionConOrden> opciones;
    Button boton;
    OpcionConOrden opcion;


    public SeleccionarOpcionConOrdenEventHandler(ArrayList<OpcionConOrden> opciones, Button boton, OpcionConOrden opcion){
        this.opciones = opciones;
        this.boton = boton;
        this.opcion = opcion.duplicar();
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        opciones.add(opcion);
        boton.setDisable(true);
    }
}
