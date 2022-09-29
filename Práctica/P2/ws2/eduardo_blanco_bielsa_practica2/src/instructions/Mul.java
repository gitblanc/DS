package instructions;

import main.Instruction;
import main.Interpreter;

public class Mul implements Instruction {

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		Interpreter.push(Interpreter.pop() * Interpreter.pop());
		return ip+1;
	}

}
