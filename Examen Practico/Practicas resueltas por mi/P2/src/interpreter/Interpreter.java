package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author omenp
 *
 */
public class Interpreter {

	private static List<Instruction[]> instructions = new ArrayList<>();
	private static int ip = 0;

	private static int[] memory = new int[1024];

	private static int[] stack = new int[32];
	private static int sp = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader file = new BufferedReader(new FileReader("factorial.txt"));

		String line;
		while ((line = file.readLine()) != null)
			loadSentence(line);
		file.close();

		executeProgram();
	}

	private static void executeProgram() {
		while (ip < instructions.size()) {
			Instruction[] sentence = instructions.get(ip);
			System.out.println(ip);
			executeInstruction(sentence);
		}
	}

	private static void executeInstruction(Instruction[] sentence) {
		ip = sentence[0].executeInstruction(sentence, ip);
	}

	private static final boolean TRACE = false;

	private static void loadSentence(String line) {
		if (line.trim().length() == 0)
			return;

		String[] tokens = line.split(" ");
		if (TRACE) {
			for (String token : tokens)
				System.out.println("*" + token + "*");
		}
		instructions.add(InstructionParser.parseInstructions(tokens));
	}

	public static void push(int value) {
		stack[sp] = value;
		sp++;
	}

	public static int pop() {
		sp--;
		return stack[sp];
	}

	@SuppressWarnings("resource")
	public static int readValue() {
		return new Scanner(System.in).nextInt();
	}

	public static int[] getMemory() {
		return memory;
	}

	public static void setMemory(int address, int value) {
		memory[address] = value;
	}
}
