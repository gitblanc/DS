/**
 * 
 */
package instrucciones;

import main.Estado;

/**
 * 
 */
public class SubInstruction extends AumentarIpAbstract {

	@Override
	public void ejecutar(Estado estado) {
		int b = estado.pop();
		int a = estado.pop();
		estado.push(a - b);
	}

}
