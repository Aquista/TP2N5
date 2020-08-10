package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LectorDeArchivos {
    public static String leerArchivo(String nombreArchivo) {
        Path base = Paths.get(".").resolve("JSON").normalize().toAbsolutePath();
        Path rutaArchivo = base.resolve(nombreArchivo);
        String contenido;

        try {
            contenido = Files.readString(rutaArchivo);
        } catch (IOException e) {
            contenido = null;
        }

        return contenido;
    }
}
