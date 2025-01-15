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
public class Add implements Instruction {

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		Interpreter.push(Interpreter.pop() + Interpreter.pop());
		return ip+1;
	}

}
