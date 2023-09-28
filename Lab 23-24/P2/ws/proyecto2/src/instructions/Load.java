package instructions;

import main.Main;

public class Load implements Instruction {

	@Override
	public String toString() {
		return "Load";
	}

	@Override
	public int execute(Instruction[] instruccion, int ip) {
		int direccion = Main.pop();
		Main.push(Main.getMemoria()[direccion]);
		return ip+1;
	}
}
