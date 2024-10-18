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

	public int getIp() {
		return ip;
	}

	public void setIp(int ip) {
		this.ip = ip;
	}

	public int[] getMemoria() {
		return memoria;
	}

	public void setMemoria(int direccion, int valor) {
		this.memoria[direccion] = valor;
	}

	public int[] getPila() {
		return pila;
	}

	public void setPila(int[] pila) {
		this.pila = pila;
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	public Scanner getConsole() {
		return console;
	}

	// $ Métodos Auxiliares --------------------------------
	public void push(int valor) {
		pila[sp] = valor;
		sp++;
	}

	public int pop() {
		sp--;
		return pila[sp];
	}
}
