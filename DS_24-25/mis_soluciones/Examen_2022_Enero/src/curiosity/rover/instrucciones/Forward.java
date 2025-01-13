/**
 * 
 */
package curiosity.rover.instrucciones;

import curiosity.rover.Estado;
import curiosity.rover.Instruccion;

/**
 * 
 */
public class Forward implements Instruccion {

	@Override
	public void execute(Estado estado) {
		estado.setSuccess(estado.getRover().moveForward());
	}

}
