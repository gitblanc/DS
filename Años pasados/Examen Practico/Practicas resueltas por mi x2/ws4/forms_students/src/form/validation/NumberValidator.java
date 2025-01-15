package form.validation;

public class NumberValidator implements Validator {

	@Override
	public boolean isValid(String value) {
		for (char ch : value.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}

}
