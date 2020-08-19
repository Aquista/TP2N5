package edu.fiuba.algo3.vista;

import javafx.scene.control.Alert;

public class VistaAlertaArchivoNoSeleccionado extends Alert {

    public VistaAlertaArchivoNoSeleccionado() {
        super(AlertType.WARNING);
        this.setTitle("Archivo no seleccionado");
        this.setHeaderText("Seleccione el archivo de respuestas nuevamente.");
    }
}
