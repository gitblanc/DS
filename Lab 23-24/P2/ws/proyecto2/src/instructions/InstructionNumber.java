package instructions;

public class InstructionNumber implements Instruction {

	private int number;

	public InstructionNumber(String token, int posicion) {
		if (posicion == 1 && token != null && token != "")
			this.number = Integer.parseInt(token);
	}

	@Override
	public int execute(Instruction[] instruccion, int ip) {
		return number;
	}

}
