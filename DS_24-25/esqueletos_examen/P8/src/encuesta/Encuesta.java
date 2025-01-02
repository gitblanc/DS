package encuesta;

import java.util.ArrayList;
import java.util.List;

public class Encuesta {

	private String pregunta;
	private int si, no;

	private List<Observer> observadores = new ArrayList<>(); // Patrón Observer

	public Encuesta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public int getVotosSi() {
		return si;
	}

	public int getVotosNo() {
		return no;
	}

	public void incrementaSi() {
		si++;
		notificaObservadores();
	}

	private void notificaObservadores() {
		for (Observer o : observadores)
			o.notificar(this);
	}

	public void incrementaNo() {
		no++;
		notificaObservadores();
	}

	public void addObservador(Observer o) {
		this.observadores.add(o);
	}

	// Parte de representar los datos
//	private void actualizaGráficoCircular() {
//		System.out.println("Aquí se dibujaría el gráfico circular.");
//	}
//
//	private void actualizaGráficoBarras() {
//		System.out.println("Aquí se dibujaría el gráfico de barras.");
//	}
//
//	private void hacerBackup() {
//		System.out.println("Aquí se guardarán los datos en disco/BD.");
//	}

}
