/**
 * 
 */
package main;

import java.util.Scanner;

/**
 * 
 */
public class Estado {
	private int ip = 0;

	private int[] memoria = new int[1024];

	private int[] pila = new int[32];
	private int sp = 0;

	private Scanner console = new Scanner(System.in);

	// $ Métodos Auxiliares --------------------------------
	public void push(int valor) {
		pila[sp] = valor;
		sp++;
	}

	public int pop() {
		sp--;
		return pila[sp];
	}

	public int getIp() {
		return this.ip;
	}

	public void setIp(int newIp) {
		this.ip = newIp;
	}

	public void setMemoria(int direccion, int valor) {
		this.memoria[direccion] = valor;
	}

	public int getMemoria(int direccion) {
		return this.memoria[direccion];
	}

	public Scanner getConsole() {
		return this.console;
	}
}
