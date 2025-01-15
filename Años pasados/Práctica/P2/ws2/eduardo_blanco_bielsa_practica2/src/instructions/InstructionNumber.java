package instructions;

import main.Instruction;

public class InstructionNumber implements Instruction {

	private int number;

	public InstructionNumber(String token, int position) {
		if (position == 1)
			number = Integer.parseInt(token);
	}

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		return number;
	}

}
