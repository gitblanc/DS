package main;

/**
 * # IMPORTANTE: El c�digo entregado para esta pr�ctica es el m�nimo necesario para entender
 * el ejercicio y NUNCA deber�a ser tomado como un ejemplo del uso adecuado de excepciones,
 * asertos y tests. Todo lo anterior, que deber�a hacerse en un programa real, se ha omitido
 * a prop�sito para simplificar el planteamiento del ejercicio.
 */

import java.io.*;
import java.util.*;

import instructions.Instruction;
import parser.InstructionParser;

public class Main {
	private static List<Instruction[]> instrucciones = new ArrayList<>();
	private static int ip = 0;

	private static int[] memoria = new int[1024];

	private static int[] pila = new int[32];
	private static int sp = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader fichero = new BufferedReader(new FileReader("factorial.txt"));
//		BufferedReader fichero = new BufferedReader(new FileReader("fibonacci.txt"));

		String linea;
		while ((linea = fichero.readLine()) != null)
			cargaInstruccion(linea);
		fichero.close();

		ejecutaPrograma();
	}

	// $ Cargar programa --------------------------------
	private static void cargaInstruccion(String linea) {
		if (linea.trim().length() == 0)
			return;

		String[] palabras = linea.split(" ");
		Instruction[] instructions = InstructionParser.parse(palabras);
		instrucciones.add(instructions);
	}

	// $ M�todos Auxiliares --------------------------------
	public static void push(int valor) {
		pila[sp] = valor;
		sp++;
	}

	public static int pop() {
		sp--;
		return pila[sp];
	}

	// $ Motor de Ejecuci�n --------------------------------
	private static void ejecutaPrograma() {
//		int i = 0;
		while (ip < instrucciones.size()) {
			Instruction[] instruccion = instrucciones.get(ip);
			ejecutaInstruccion(instruccion);
//			String[] instruccion = instrucciones.get(ip);
//
//			if (instruccion[0].equals("push")) {
//				push(Integer.parseInt(instruccion[1]));
//				ip++;
//			} else if (instruccion[0].equals("add")) {
//				push(pop() + pop());
//				ip++;
//			} else if (instruccion[0].equals("sub")) {
//				int b = pop();
//				int a = pop();
//				push(a - b);
//				ip++;
//			} else if (instruccion[0].equals("mul")) {
//				push(pop() * pop());
//				ip++;
//			} else if (instruccion[0].equals("jmp")) {
//				ip = Integer.parseInt(instruccion[1]);
//			} else if (instruccion[0].equals("jmpg")) {
//				int b = pop();
//				int a = pop();
//				if (a > b)
//					ip = Integer.parseInt(instruccion[1]);
//				else
//					ip++;
//			} else if (instruccion[0].equals("load")) {
//				int direccion = pop();
//				push(memoria[direccion]);
//				ip++;
//			} else if (instruccion[0].equals("store")) {
//				int valor = pop();
//				int direccion = pop();
//				memoria[direccion] = valor;
//				ip++;
//			} else if (instruccion[0].equals("input")) {
//				System.out.println("Escriba un entero:");
//				push(console.nextInt());
//				ip++;
//			} else if (instruccion[0].equals("output")) {
//				System.out.println(pop());
//				ip++;
//			}
		}
	}

	private static void ejecutaInstruccion(Instruction[] instruccion) {
		ip = instruccion[0].execute(instruccion, ip);
	}

	public static int[] getMemoria() {
		return memoria;
	}
}
