package main;

import java.io.*;

import encuesta.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");

        TextUserInterface userInterface = new TextUserInterface();
        userInterface.rellena(encuesta);
    }

}
