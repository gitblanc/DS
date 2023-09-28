package instructions;

import main.Main;

public class Sub implements Instruction {

	@Override
	public String toString() {
		return "Sub";
	}

	@Override
	public int execute(Instruction[] instruccion, int ip) {
		int b = Main.pop();
		int a = Main.pop();
		Main.push(a - b);
		return ip + 1;
	}
}
