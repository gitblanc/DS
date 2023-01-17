/**
 * 
 */
package poll.observers;

import poll.Poll;
import poll.PollObserver;

/**
 * @author omenp
 *
 */
public class PieChart implements PollObserver {

	@Override
	public void update(Poll poll) {
		System.out.println("Dibujando un gráfico circular...");
	}

}
