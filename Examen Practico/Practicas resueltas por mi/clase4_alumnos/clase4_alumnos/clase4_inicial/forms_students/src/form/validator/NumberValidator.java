/**
 * 
 */
package form.validator;

/**
 * @author omenp
 *
 */
public class NumberValidator implements Validator {

	@Override
	public boolean isValid(String texto) {
		for (char ch : texto.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getMessage() {
		return "Se necesita un valor numérico";
	}

}
