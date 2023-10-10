package validators;

public class ValidadorMenorQue implements Validador {

	private int valor;

	public ValidadorMenorQue(int i) {
		this.valor = i;
	}

	@Override
	public boolean isValid(String value) {
		return Integer.parseInt(value) <= this.valor;
	}

}
