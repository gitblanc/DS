package instructions;

public class Jmp implements Instruction {

	@Override
	public String toString() {
		return "Jmp";
	}

	@Override
	public int execute(Instruction[] instruccion, int ip) {
		return instruccion[1].execute(instruccion, ip);
	}
}
