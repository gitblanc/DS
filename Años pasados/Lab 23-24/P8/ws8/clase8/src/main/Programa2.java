package main;

import java.io.IOException;

import encuesta.Encuesta;
import encuesta.TextUserInterface;
import observers.GraficoCircular;
import observers.LineaEstado;

public class Programa2 {

	public static void main(String[] args) throws IOException {
		Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");

		TextUserInterface userInterface = new TextUserInterface();

		encuesta.addObserver(new GraficoCircular());
		encuesta.addObserver(new LineaEstado());

		userInterface.rellena(encuesta);
	}

}
