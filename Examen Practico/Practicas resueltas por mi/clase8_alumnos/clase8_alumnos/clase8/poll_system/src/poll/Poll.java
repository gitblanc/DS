package poll;

import java.util.ArrayList;
import java.util.List;

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

	private void notifyObservers() {
		for (PollObserver o : observers)
			o.update(this);
	}

	public void addObserver(PollObserver o) {
		observers.add(o);
	}

	public void removeObserver(PollObserver o) {
		observers.remove(o);
	}
}
