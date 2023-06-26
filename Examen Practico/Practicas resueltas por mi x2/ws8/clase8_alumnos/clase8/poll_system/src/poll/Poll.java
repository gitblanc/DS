package poll;

import java.util.List;
import java.util.ArrayList;

public class Poll {
	private int yeses, nos;
	private String question;
	private List<PollObserver> observers = new ArrayList<>();

	public Poll(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public int getYeses() {
		return yeses;
	}

	public int getNos() {
		return nos;
	}

	public void incrementYeses() {
		yeses++;
		notifyObservers();
	}

	public void incrementNos() {
		nos++;
		notifyObservers();
	}

	public void addObserver(PollObserver o) {
		observers.add(o);
	}

	public void removeObserver(PollObserver o) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		for(PollObserver po : observers)
			po.update(this);
	}

//	private void updateBarChart() {
//		System.out.println("Dibujando un gráfico de barras...");
//	}
//
//	private void updatePieChart() {
//		System.out.println("Dibujando un gráfico circular...");
//	}
//
//	private void saveResults() {
//		System.out.println("Guardando los resultados...");
//	}
}
