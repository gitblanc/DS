package instructions;

import main.Main;

public class Add implements Instruction {

	@Override
	public String toString() {
		return "Add";
	}

	@Override
	public int execute(Instruction[] instruccion, int ip) {
		Main.push(Main.pop() + Main.pop());
		return ip++;
	}

}
