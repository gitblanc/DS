/**
 * # IMPORTANTE: El código entregado para esta práctica es el mínimo necesario para entender
 * el ejercicio y NUNCA debería ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que debería hacerse en un programa real, se ha omitido
 * a propósito para simplificar el planteamiento del ejercicio.
 */

package main;

import java.io.*;
import java.util.*;

import loader.*;
import loader.creators.*;
import vm.*;

public class Main {

	public static void main(String[] args) throws Exception {
		AdvancedProgramLoader loader = createLoader();
		List<Instruction> program = loader.loadProgram(new FileReader("programa.txt"));

		VirtualMachine vm = new VirtualMachine(program);
		vm.run();
	}

	private static AdvancedProgramLoader createLoader() {
		AdvancedProgramLoader loader = new AdvancedProgramLoader();

		loader.registerLoader("push", new PushCreator());
		loader.registerLoader("add", new AddCreator());
		loader.registerLoader("sub", new SubCreator());
		loader.registerLoader("mul", new MulCreator());
		loader.registerLoader("jmp", new JumpCreator());
		loader.registerLoader("jmpg", new JumpGreaterCreator());
		loader.registerLoader("load", new LoadCreator());
		loader.registerLoader("store", new StoreCreator());
		loader.registerLoader("input", new InputCreator());
		loader.registerLoader("output", new OutputCreator());

		return loader;
	}
}
