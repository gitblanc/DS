package instrucciones;

import main.Estado;

public class PushInstruction extends AumentarIpAbstract {

	private int valor;

	public PushInstruction(String string) {
		setValor(Integer.parseInt(string));
	}

	@Override
	public void ejecutar(Estado estado) {
		estado.push(valor);
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
