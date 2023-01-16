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
public class Load implements Instruction {

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		Interpreter.push(Interpreter.getMemory()[Interpreter.pop()]);
		return ip + 1;
	}

}
