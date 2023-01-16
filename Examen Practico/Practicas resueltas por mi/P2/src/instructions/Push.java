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
public class Push implements Instruction {

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		Interpreter.push(sentence[1].executeInstruction(sentence, ip));
		return ip+1;
	}

}
