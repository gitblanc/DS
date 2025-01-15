package validators;

public class ValidadorTexto implements Validador {

	@Override
	public boolean isValid(String value) {
		for (char ch : value.toCharArray()) {
			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
	}

}
