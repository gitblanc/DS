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
public class Sub implements Instruction {

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		int b = Interpreter.pop();
		int a = Interpreter.pop();
		Interpreter.push(a - b);
		return ip+1;
	}

}
