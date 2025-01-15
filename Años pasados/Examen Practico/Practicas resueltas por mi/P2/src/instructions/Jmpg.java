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
public class Jmpg implements Instruction {

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		int b = Interpreter.pop();
		int a = Interpreter.pop();
		if (a > b)
			return sentence[1].executeInstruction(sentence, ip);
		else
			return ip+1;
	}

}
