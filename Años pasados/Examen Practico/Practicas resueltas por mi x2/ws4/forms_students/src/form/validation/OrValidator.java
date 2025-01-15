package form.validation;

public class OrValidator extends CompoundValidator implements Validator {

	public OrValidator(Validator... validators) {
		super(validators);
	}

	public void addCondition(Validator v) {
		super.addCondition(v);
	}

	@Override
	public boolean isValid(String value) {
		for (Validator v : validators) {
			if (v.isValid(value))
				return true;
		}
		return false;
	}

	@Override
	protected String getConjuction() {
		return "o";
	}

}
