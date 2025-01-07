/**
 * 
 */
package instructions;

import main.Estado;

/**
 * 
 */
public class Load extends AumentarIp {

	@Override
	protected void doExecute(Estado estado) {
		int direccion = estado.pop();
		estado.push(estado.getMemoria(direccion));
	}

}
