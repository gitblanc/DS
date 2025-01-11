package encuesta;

import java.util.ArrayList;
import java.util.List;

public class Encuesta {

	private String pregunta;
	private int si, no;
	private List<Observer> observers = new ArrayList<Observer>();

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

	// $---- Para los observers

	public void addObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	private void notifyObservers() {
		for (Observer o : observers) {
			o.update(this);
		}
	}

	public void incrementaSi() {
		si++;
		notifyObservers();
	}

	public void incrementaNo() {
		no++;
		notifyObservers();
	}

}
