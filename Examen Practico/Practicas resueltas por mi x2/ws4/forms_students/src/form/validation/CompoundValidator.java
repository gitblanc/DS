package form.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CompoundValidator implements Validator {

	protected List<Validator> validators = new ArrayList<>();

	public CompoundValidator(Validator... validators) {
		if (validators == null || validators.length == 0)
			throw new IllegalArgumentException("Ha de haber al menos un validador");
		this.validators = Arrays.asList(validators);
	}

	public void addCondition(Validator v) {
		if (v == null)
			throw new IllegalArgumentException("El validador no puede ser nulo");
		validators.add(v);
	}

	protected abstract String getConjuction();

}
