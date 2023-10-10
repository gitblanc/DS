package validators;

public class ValidadorPredefinido implements Validador {

	private String[] campos;

	public ValidadorPredefinido(String... strings) {
		this.campos = strings;
	}

	@Override
	public boolean isValid(String value) {
		for (String campo : campos) {
			if (campo.toLowerCase().equals(value.toLowerCase()))
				return true;
		}
		return false;
	}

}
