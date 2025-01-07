/**
 * 
 */
package instructions;

import main.Estado;

/**
 * 
 */
public class Input extends AumentarIp {

	@Override
	protected void doExecute(Estado estado) {
		System.out.println("Escriba un entero:");
		estado.push(estado.getConsole().nextInt());
	}

}
