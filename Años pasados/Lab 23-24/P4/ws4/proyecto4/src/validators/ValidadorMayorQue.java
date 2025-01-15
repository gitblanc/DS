package validators;

public class ValidadorMayorQue implements Validador {
	
	private int valor;

	public ValidadorMayorQue(int i) {
		this.valor = i;
	}

	@Override
	public boolean isValid(String value) {
		return Integer.parseInt(value) >= this.valor;
	}

}
