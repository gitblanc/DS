/**
 * 
 */
package form.validator;

/**
 * @author omenp
 *
 */
public class TextValidator implements Validator {

	@Override
	public boolean isValid(String texto) {
		for (char ch : texto.toCharArray()) {
			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getMessage() {
		return "Se necesita un valor de texto";
	}

}
