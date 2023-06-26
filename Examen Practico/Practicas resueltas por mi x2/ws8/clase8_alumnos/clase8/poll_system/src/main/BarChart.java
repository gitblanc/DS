package main;

import poll.Poll;
import poll.PollObserver;

public class BarChart implements PollObserver {

	@Override
	public void update(Poll poll) {
		System.out.println("Dibujando un gráfico de barras...");
	}

}
