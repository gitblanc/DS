package form.validation;

public class TextValidator implements Validator {

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
