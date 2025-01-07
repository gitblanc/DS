/**
 * 
 */
package instructions;

import main.Estado;

/**
 * 
 */
public class Store extends AumentarIp {

	@Override
	protected void doExecute(Estado estado) {
		int valor = estado.pop();
		int direccion = estado.pop();
		estado.setMemoria(direccion, valor);
	}

}
