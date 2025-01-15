/**
 * 
 */
package form.validator;

/**
 * @author omenp
 *
 */
public class PredefinedValidator implements Validator {

	private String[] predefinedValues;
	private String message;

	public PredefinedValidator(String... values) {
		if (values == null || values.length == 0)
			throw new IllegalArgumentException("Se necesita al menos un valor posible para el campo predefinido");
		this.predefinedValues = values;
		this.message = buildMessage();
	}

	private String buildMessage() {
		StringBuilder result = new StringBuilder("Se necesita uno de los siguientes valores predefinidos: ");
		for (int i = 0; i < predefinedValues.length; i++) {
			result.append(predefinedValues[i]);
			if (i < predefinedValues.length - 2)
				result.append(", ");
			if (i == predefinedValues.length - 2)
				result.append(" o ");
		}
		return result.toString();
	}

	@Override
	public boolean isValid(String texto) {
		for (String each : predefinedValues) {
			if (each.equalsIgnoreCase(texto))
				return true;
		}
		return false;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
