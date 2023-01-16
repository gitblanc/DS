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
public class Input implements Instruction {

	@Override
	public int executeInstruction(Instruction[] sentence, int ip) {
		System.out.println("Escriba un entero: ");
		Interpreter.push(Interpreter.readValue());
		return ip+1;
	}

}
