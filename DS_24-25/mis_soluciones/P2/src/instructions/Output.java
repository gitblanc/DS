/**
 * 
 */
package instructions;

import main.Estado;

/**
 * 
 */
public class Output extends AumentarIp {

	@Override
	protected void doExecute(Estado estado) {
		System.out.println(estado.pop());
	}

}
