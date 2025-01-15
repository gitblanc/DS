package validators;

public class ValidadorLongitud implements Validador {
	
	private int longitud;

	public ValidadorLongitud(int i) {
		this.longitud = i;
	}

	@Override
	public boolean isValid(String value) {
		return value.length() == this.longitud;
	}

}
