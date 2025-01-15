package instructions;

import main.Main;

public class Jmpg implements Instruction {

	@Override
	public String toString() {
		return "Jmpg";
	}

	@Override
	public int execute(Instruction[] instruccion, int ip) {
		int b = Main.pop();
		int a = Main.pop();
		if (a > b)
			return instruccion[1].execute(instruccion, ip);
		else
			return ip + 1;
	}
}
