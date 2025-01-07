/**
 * 
 */
package instructions;

import main.Estado;
import main.Instruccion;

/**
 * 
 */
public class Jmpg implements Instruccion {

	private int valor;

	public Jmpg(int i) {
		this.valor = i;
	}

	@Override
	public void execute(Estado estado) {
		int b = estado.pop();
		int a = estado.pop();
		if (a > b)
			estado.setIp(this.valor);
		else
			estado.setIp(estado.getIp() + 1);
	}

}
