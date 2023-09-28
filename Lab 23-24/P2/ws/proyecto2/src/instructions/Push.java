package instructions;

public class Push implements Instruction {

	private int number;

	public Push(String number) {
		this.number = Integer.parseInt(number);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return "Push " + number;
	}

}
