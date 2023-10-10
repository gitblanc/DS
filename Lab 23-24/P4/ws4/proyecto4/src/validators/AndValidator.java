package validators;

public class AndValidator extends ValidadorCompuesto {

	public AndValidator(Validador v1, Validador v2) {
		super(v1, v2);
	}

	@Override
	public boolean isValid(String value) {
		for (Validador v : super.getValidadores()) {
			if (!v.isValid(value))
				return false;
		}
		return true;
	}

}
