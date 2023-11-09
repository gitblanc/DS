package main;

import java.io.IOException;

import encuesta.Encuesta;
import encuesta.TextUserInterface;
import observers.GraficoCircular;
import observers.VotoMinimo;

public class Programa3 {

	public static void main(String[] args) throws IOException {
		Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");

		TextUserInterface userInterface = new TextUserInterface();

		encuesta.addObserver(new VotoMinimo(3, new GraficoCircular()));

		userInterface.rellena(encuesta);
	}

}
