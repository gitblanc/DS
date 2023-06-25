package instructions;

import main.Instruction;
import main.Interpreter;

public class Store implements Instruction {

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		int value = Interpreter.pop();
		int address = Interpreter.pop();
		Interpreter.setMemory(address, value);
		return ip + 1;
	}

}
