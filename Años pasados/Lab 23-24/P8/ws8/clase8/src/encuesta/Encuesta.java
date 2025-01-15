package encuesta;

import java.util.ArrayList;
import java.util.List;

import main.Observer;

public class Encuesta {

	private int si, no;
	private String pregunta;
	private List<Observer> observers = new ArrayList<>();

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
		notificarObservers();
	}

	public void incrementaNo() {
		no++;
		notificarObservers();
	}

	public void addObserver(Observer o1) {
		observers.add(o1);
	}

	public void removeObserver(Observer o1) {
		observers.remove(o1);
	}

	private void notificarObservers() {
		for (Observer o : observers)
			o.actualizar(this);
	}

}
