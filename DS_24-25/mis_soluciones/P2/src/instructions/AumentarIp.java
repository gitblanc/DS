/**
 * 
 */
package instructions;

import main.Estado;
import main.Instruccion;

/**
 * 
 */
public abstract class AumentarIp implements Instruccion {

	// Template method
	@Override
	public void execute(Estado estado) {
		doExecute(estado);
		estado.setIp(estado.getIp() + 1);
	}

	protected abstract void doExecute(Estado estado);

}
