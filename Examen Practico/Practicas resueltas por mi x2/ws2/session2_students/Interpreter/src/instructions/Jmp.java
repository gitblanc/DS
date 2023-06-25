package instructions;

import main.Instruction;

public class Jmp implements Instruction {

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		return sentence[1].executeInstruction(sentence, ip);
	}

}
