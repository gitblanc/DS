package instrucciones;

import main.Estado;

public class MulInstruction extends AumentarIpAbstract {

	@Override
	public void ejecutar(Estado estado) {
		estado.push(estado.pop() * estado.pop());
	}

}