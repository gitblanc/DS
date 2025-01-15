package form.validation;

public class LessThanValidator implements Validator {

	private int value;

	public LessThanValidator(int i) {
		this.value = i;
	}

	@Override
	public boolean isValid(String value) {
		try {
			int number = Integer.parseInt(value);
			return number < this.value;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
