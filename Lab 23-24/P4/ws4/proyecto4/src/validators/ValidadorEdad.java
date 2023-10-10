package validators;

public class ValidadorEdad implements Validador {

	private int edadMinima;

	public ValidadorEdad(int i) {
		this.edadMinima = i;
	}

	@Override
	public boolean isValid(String value) {
		return Integer.parseInt(value) >= this.edadMinima;
	}

}
