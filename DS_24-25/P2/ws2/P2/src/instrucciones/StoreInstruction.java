package instrucciones;

import main.Estado;

public class StoreInstruction extends AumentarIpAbstract {

	@Override
	public void ejecutar(Estado estado) {
		int valor = estado.pop();
		int direccion = estado.pop();
		estado.setMemoria(direccion, valor);
	}

}
