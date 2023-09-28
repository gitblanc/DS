/**
 * 
 */
package parser;

import instructions.*;

/**
 * @author blanc
 *
 */
public class InstructionParser {

	public static Instruction[] parse(String[] palabras) {
//		Instruction[] instructions = new Instruction[1];
//		if (palabras[0].equals("push")) {
//			instructions[0] = new Push();
//			instructions[1] = new InstructionNumber(palabras[1]);
//		} else if (palabras[0].equals("add")) {
//			instructions[0] = new Add();
//		} else if (palabras[0].equals("sub")) {
//			instructions[0] = new Sub();
//		} else if (palabras[0].equals("mul")) {
//			instructions[0] = new Mul();
//		} else if (palabras[0].equals("jmp")) {
//			instructions[0] = new Jmp();
//			instructions[1] = new InstructionNumber(palabras[1]);
//		} else if (palabras[0].equals("jmpg")) {
//			instructions[0] = new Jmpg();
//			instructions[1] = new InstructionNumber(palabras[1]);
//		} else if (palabras[0].equals("load")) {
//			instructions[0] = new Load();
//		} else if (palabras[0].equals("store")) {
//			instructions[0] = new Store();
//		} else if (palabras[0].equals("input")) {
//			instructions[0] = new Input();
//		} else if (palabras[0].equals("output")) {
//			instructions[0] = new Output();
//		}
//		return instructions;
		Instruction[] instructions = new Instruction[palabras.length];
		int i = 0;
		for (String token : palabras) {
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
