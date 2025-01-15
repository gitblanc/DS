package validators;

public class OrValidator extends ValidadorCompuesto {

	public OrValidator(Validador... validadores) {
		super(validadores);
	}

	@Override
	public boolean isValid(String value) {
		for (Validador v : super.getValidadores()) {
			if (v.isValid(value))
				return true;
		}
		return false;
	}

}
