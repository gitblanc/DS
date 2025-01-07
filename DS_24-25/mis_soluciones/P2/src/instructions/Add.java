/**
 * 
 */
package instructions;

import main.Estado;

/**
 * 
 */
public class Add extends AumentarIp {

	@Override
	protected void doExecute(Estado estado) {
		estado.push(estado.pop() + estado.pop());
	}

}
