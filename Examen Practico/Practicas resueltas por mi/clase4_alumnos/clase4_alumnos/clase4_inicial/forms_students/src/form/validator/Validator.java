/**
 * 
 */
package form.validator;

/**
 * @author omenp
 *
 */
public interface Validator {
	boolean isValid(String value);
	String getMessage();
}
