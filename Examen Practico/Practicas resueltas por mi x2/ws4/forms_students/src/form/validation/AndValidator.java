package form.validation;

public class AndValidator extends CompoundValidator implements Validator {

	public AndValidator(Validator... validators) {
		super(validators);
	}

	public void addCondition(Validator v) {
		super.addCondition(v);
	}

	@Override
	public boolean isValid(String value) {
		for (Validator v : validators) {
			if (!v.isValid(value))
				return false;
		}
		return true;
	}

	@Override
	protected String getConjuction() {
		return "y";
	}

}
