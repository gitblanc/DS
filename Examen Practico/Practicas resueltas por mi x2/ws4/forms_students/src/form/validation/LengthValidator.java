package form.validation;

public class LengthValidator implements Validator {

	private int length;

	public LengthValidator(int i) {
		this.length = i;
	}

	@Override
	public boolean isValid(String value) {
		return value.length() == this.length;
	}

}
