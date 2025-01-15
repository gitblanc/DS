package instructions;

import main.Instruction;
import main.Interpreter;

public class Load implements Instruction {

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		int address = Interpreter.pop();
		Interpreter.push(Interpreter.getMemory()[address]);
		return ip+1;
	}

}
