/**
 * 
 */
package instrucciones;

import main.Estado;

/**
 * 
 */
public abstract class AumentarIpAbstract implements Instruction {
	
	protected abstract void ejecutar(Estado estado);

	@Override
	public void execute(Estado estado) {
		ejecutar(estado);
		estado.setIp(estado.getIp() + 1);
	}

}
