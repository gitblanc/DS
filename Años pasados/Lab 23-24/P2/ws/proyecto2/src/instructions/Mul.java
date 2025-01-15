package instructions;

import main.Main;

public class Mul implements Instruction {

	@Override
	public String toString() {
		return "Mul";
	}

	@Override
	public int execute(Instruction[] instruccion, int ip) {
		Main.push(Main.pop() * Main.pop());
		return ip + 1;
	}
}
