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
public class Output implements Instruction {

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		System.out.println(Interpreter.pop());
		return ip+1;
	}

}
