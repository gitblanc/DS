package instructions;

import main.Instruction;
import main.Interpreter;

public class Output implements Instruction {

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		System.out.println(Interpreter.pop());
		return ip+1;
	}

}
