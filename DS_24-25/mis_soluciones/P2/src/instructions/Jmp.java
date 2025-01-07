/**
 * 
 */
package instructions;

import main.Estado;
import main.Instruccion;

/**
 * 
 */
public class Jmp implements Instruccion {

	private int valor;

	public Jmp(int i) {
		this.valor = i;
	}

	@Override
	public void execute(Estado estado) {
		estado.setIp(valor);
	}

}
