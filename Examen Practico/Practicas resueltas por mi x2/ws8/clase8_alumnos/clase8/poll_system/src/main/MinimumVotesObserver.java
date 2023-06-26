package main;

import poll.Poll;
import poll.PollObserver;

public class MinimumVotesObserver implements PollObserver {

	private int minValue;
	private PollObserver po;

	public MinimumVotesObserver(int i, PollObserver o) {
		this.minValue = i;
		this.po = o;
	}

	@Override
	public void update(Poll poll) {
		if (poll.getYeses() + poll.getNos() >= minValue)
			po.update(poll);
	}

}
