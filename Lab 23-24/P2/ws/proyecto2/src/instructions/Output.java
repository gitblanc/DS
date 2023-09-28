package instructions;

import main.Main;

public class Output implements Instruction {

	@Override
	public String toString() {
		return "Output";
	}

	@Override
	public int execute(Instruction[] instruccion, int ip) {
		System.out.println(Main.pop());
		return ip + 1;
	}
}
