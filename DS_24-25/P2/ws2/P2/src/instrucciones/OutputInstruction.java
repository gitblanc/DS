package instrucciones;

import main.Estado;

public class OutputInstruction extends AumentarIpAbstract {

	@Override
	public void ejecutar(Estado estado) {
		System.out.println(estado.pop());
	}

}
