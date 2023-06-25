package form.validation;

public class GreaterThanValidator implements Validator {

	private int value;

	public GreaterThanValidator(int i) {
		this.value = i;
	}

	@Override
	public boolean isValid(String value) {
		try {
			int number = Integer.parseInt(value);
			return number > this.value;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
