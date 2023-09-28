package instructions;

import main.Main;

public class Push implements Instruction {
	@Override
	public String toString() {
		return "Push";
	}

	@Override
	public int execute(Instruction[] instruccion, int ip) {
		Main.push(instruccion[1].execute(instruccion, ip));
		return ip + 1;
	}

}
