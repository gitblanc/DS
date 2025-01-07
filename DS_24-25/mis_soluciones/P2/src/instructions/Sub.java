/**
 * 
 */
package instructions;

import main.Estado;

/**
 * 
 */
public class Sub extends AumentarIp {

	@Override
	protected void doExecute(Estado estado) {
		int b = estado.pop();
		int a = estado.pop();
		estado.push(a - b);
	}

}
