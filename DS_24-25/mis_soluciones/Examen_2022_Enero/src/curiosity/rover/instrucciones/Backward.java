/**
 * 
 */
package curiosity.rover.instrucciones;

import curiosity.rover.Estado;
import curiosity.rover.Instruccion;

/**
 * 
 */
public class Backward implements Instruccion {

	@Override
	public void execute(Estado estado) {
		// se mueve una posición hacia atrás salvo que se encuentre con un obstáculo
		estado.setSuccess(estado.getRover().moveBackward());
	}

}
