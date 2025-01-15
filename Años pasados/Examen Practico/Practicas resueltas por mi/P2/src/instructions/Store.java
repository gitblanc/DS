/**
 * 
 */
package instructions;

import interpreter.Instruction;
import interpreter.Interpreter;

/**
 * @author omenp
 *
 */
public class Store implements Instruction {

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		int value = Interpreter.pop();
		int address = Interpreter.pop();
		Interpreter.setMemory(address, value);
		return ip + 1;
	}

}
