package instrucciones;

import main.Estado;

public class InputInstruction extends AumentarIpAbstract{

	@Override
	public void ejecutar(Estado estado) {
		System.out.println("Escriba un entero:");
		estado.push(estado.getConsole().nextInt());
	}

}