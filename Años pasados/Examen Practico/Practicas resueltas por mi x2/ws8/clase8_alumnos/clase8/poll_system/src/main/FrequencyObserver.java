package main;

import poll.Poll;
import poll.PollObserver;

public class FrequencyObserver implements PollObserver {

	private int counter, frequency;
	private PollObserver po;

	public FrequencyObserver(int i, PollObserver o) {
		this.po = o;
		this.frequency = this.counter = i;
	}

	@Override
	public void update(Poll poll) {
		if (counter == frequency) {
			po.update(poll);
			counter = 1;
		} else {
			counter++;
		}
	}

}
