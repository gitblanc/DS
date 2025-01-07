/**
 * 
 */
package instructions;

import main.Estado;

/**
 * 
 */
public class Push extends AumentarIp {

	private int valor;

	public Push(int i) {
		this.valor = i;
	}

	@Override
	protected void doExecute(Estado estado) {
		estado.push(this.valor);
	}

}
