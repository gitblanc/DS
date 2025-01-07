/**
 * 
 */
package instructions;

import main.Estado;

/**
 * 
 */
public class Mul extends AumentarIp {

	@Override
	protected void doExecute(Estado estado) {
		estado.push(estado.pop() * estado.pop());
	}

}
