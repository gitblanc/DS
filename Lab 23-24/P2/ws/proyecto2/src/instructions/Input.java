package instructions;

import java.util.Scanner;

import main.Main;

public class Input implements Instruction {

	private static Scanner console = new Scanner(System.in);

	@Override
	public String toString() {
		return "Input";
	}

	@Override
	public int execute(Instruction[] instruccion, int ip) {
		System.out.println("Escriba un entero:");
		Main.push(console.nextInt());
		return ip+1;
	}
}
