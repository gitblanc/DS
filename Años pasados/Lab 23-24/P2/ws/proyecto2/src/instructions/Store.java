package instructions;

import main.Main;

public class Store implements Instruction {

	@Override
	public String toString() {
		return "Store";
	}

	@Override
	public int execute(Instruction[] instruccion, int ip) {
		int valor = Main.pop();
		int direccion = Main.pop();
		Main.getMemoria()[direccion] = valor;
		return ip + 1;
	}
}
