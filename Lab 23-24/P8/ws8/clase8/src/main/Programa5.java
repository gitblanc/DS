package main;

import java.io.IOException;

import encuesta.Encuesta;
import encuesta.TextUserInterface;
import observers.GraficoBarras;
import observers.GraficoCircular;
import observers.LineaEstado;
import observers.ObserverFrecuencia;
import observers.VotoMinimo;

public class Programa5 {

	public static void main(String[] args) throws IOException {
		Encuesta encuesta = new Encuesta("¿Está a favor de la energia nuclear?");

		TextUserInterface userInterface = new TextUserInterface();

		encuesta.addObserver(new VotoMinimo(3, new GraficoCircular()));
		encuesta.addObserver(new ObserverFrecuencia(3, new GraficoBarras()));
		encuesta.addObserver(new VotoMinimo(4, new ObserverFrecuencia(2, new LineaEstado())));

		userInterface.rellena(encuesta);
	}

}
