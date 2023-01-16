package instructions;

import main.Instruction;
import main.Interpreter;

public class Push implements Instruction {

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		Interpreter.push(sentence[1].executeInstruction(sentence, ip));
		return ip+1;
	}

}
