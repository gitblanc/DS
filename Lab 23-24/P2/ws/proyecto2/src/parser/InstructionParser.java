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
		Instruction[] instructions = new Instruction[1];
		if (palabras[0].equals("push")) {
			instructions[0] = new Push(palabras[1]);
		} else if (palabras[0].equals("add")) {
			instructions[0] = new Add();
		} else if (palabras[0].equals("sub")) {
			instructions[0] = new Sub();
		} else if (palabras[0].equals("mul")) {
			instructions[0] = new Mul();
		} else if (palabras[0].equals("jmp")) {
			instructions[0] = new Jmp();
		} else if (palabras[0].equals("jmpg")) {
			instructions[0] = new Jmpg();
		} else if (palabras[0].equals("load")) {
			instructions[0] = new Load();
		} else if (palabras[0].equals("store")) {
			instructions[0] = new Store();
		} else if (palabras[0].equals("input")) {
			instructions[0] = new Input();
		} else if (palabras[0].equals("output")) {
			instructions[0] = new Output();
		}
		return instructions;
	}

}
