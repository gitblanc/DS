package form.validation;

public class PredefinedValidator implements Validator {

	private String[] predefinedValues;

	public PredefinedValidator(String... values) {
		if (values == null || values.length == 0)
			throw new IllegalArgumentException("No hay valores predefinidos");
		this.predefinedValues = values;
	}

	@Override
	public boolean isValid(String value) {
		for (String valor : predefinedValues) {
			if (valor.toLowerCase().equals(value.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

}
