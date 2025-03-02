package interpreter;
/**
 * 
 */

import instructions.*;

/**
 * @author omenp
 *
 */
public class InstructionParser {
	
	public static Instruction[] parseInstructions(String[] tokens) {
		Instruction[] instructions = new Instruction[tokens.length];
		int i = 0;
		for (String token : tokens) {
			switch (token) {
			case "push":
				instructions[i] = new Push();
				break;
			case "add":
				instructions[i] = new Add();
				break;
			case "sub":
				instructions[i] = new Sub();
				break;
			case "mul":
				instructions[i] = new Mul();
				break;
			case "jmp":
				instructions[i] = new Jmp();
				break;
			case "jmpg":
				instructions[i] = new Jmpg();
				break;
			case "load":
				instructions[i] = new Load();
				break;
			case "store":
				instructions[i] = new Store();
				break;
			case "input":
				instructions[i] = new Input();
				break;
			case "output":
				instructions[i] = new Output();
				break;
			default:
				instructions[i] = new InstructionNumber(token, i);
				break;
			}
			i++;
		}
		return instructions;
	}
}
