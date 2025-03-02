package main;

import java.util.ArrayList;
import java.util.List;

import instrucciones.AddInstruction;
import instrucciones.InputInstruction;
import instrucciones.Instruction;
import instrucciones.JmpInstruction;
import instrucciones.JmpgInstruction;
import instrucciones.LoadInstruction;
import instrucciones.MulInstruction;
import instrucciones.OutputInstruction;
import instrucciones.PushInstruction;
import instrucciones.StoreInstruction;
import instrucciones.SubInstruction;

public class VirtualMachine {

	private static List<Instruction> instrucciones = new ArrayList<>();
	private Estado estado = new Estado();

	// $ Cargar programa --------------------------------
	public void cargaInstruccion(String linea) {
		if (linea.trim().length() == 0)
			return;

		String[] palabras = linea.split(" ");
		
		for (int i = 0; i < palabras.length; i++) {
			if (palabras[i].equals("push")) {
				instrucciones.add(new PushInstruction(palabras[1]));
			} else if (palabras[i].equals("add")) {
				instrucciones.add(new AddInstruction());
			} else if (palabras[i].equals("sub")) {
				instrucciones.add(new SubInstruction());
			} else if (palabras[i].equals("mul")) {
				instrucciones.add(new MulInstruction());
			} else if (palabras[i].equals("jmp")) {
				instrucciones.add(new JmpInstruction(palabras[1]));
			} else if (palabras[i].equals("jmpg")) {
				instrucciones.add(new JmpgInstruction(palabras[1]));
			} else if (palabras[i].equals("load")) {
				instrucciones.add(new LoadInstruction());
			} else if (palabras[i].equals("store")) {
				instrucciones.add(new StoreInstruction());
			} else if (palabras[i].equals("input")) {
				instrucciones.add(new InputInstruction());
			} else if (palabras[i].equals("output")) {
				instrucciones.add(new OutputInstruction());
			}
		}
	}

	// $ Motor de Ejecución --------------------------------
	public void ejecutaPrograma() {
		while (estado.getIp() < instrucciones.size()) {
			Instruction instruccion = instrucciones.get(estado.getIp());

			instruccion.execute(estado);
		}
	}
}
