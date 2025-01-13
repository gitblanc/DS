/**
 * 
 */
package curiosity.rover.instrucciones;

import curiosity.rover.Estado;
import curiosity.rover.Instruccion;

/**
 * 
 */
public class Right implements Instruccion {

	@Override
	public void execute(Estado estado) {
		estado.getRover().turnRight();
	}

}
