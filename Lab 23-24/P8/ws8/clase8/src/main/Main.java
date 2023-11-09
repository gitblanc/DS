package main;

import java.io.*;

import encuesta.*;
import observers.GraficoBarras;
import observers.GraficoCircular;
import observers.HacerBackup;

public class Main {

    public static void main(String[] args) throws IOException {
        Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");

        TextUserInterface userInterface = new TextUserInterface();
        
        encuesta.addObserver(new GraficoCircular());
        encuesta.addObserver(new GraficoBarras());
        encuesta.addObserver(new HacerBackup());
        
        userInterface.rellena(encuesta);
    }

}
