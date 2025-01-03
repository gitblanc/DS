package instrucciones;

import main.Estado;

public class JmpInstruction implements Instruction {
	private int valor;

	public JmpInstruction(String string) {
		setValor(Integer.parseInt(string));
	}

	@Override
	public void execute(Estado estado) {
		estado.setIp(getValor());
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
