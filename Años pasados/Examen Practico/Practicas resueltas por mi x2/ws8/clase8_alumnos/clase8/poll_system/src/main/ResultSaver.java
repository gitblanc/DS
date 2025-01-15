package main;

import poll.Poll;
import poll.PollObserver;

public class ResultSaver implements PollObserver {

	@Override
	public void update(Poll poll) {
		System.out.println("Guardando los resultados...");
	}

}
