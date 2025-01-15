package validators;

public abstract class ValidadorCompuesto implements Validador {

	private Validador[] validadores;

	public ValidadorCompuesto(Validador... validadores) {
		this.validadores = validadores;
	}

	protected Validador[] getValidadores() {
		return this.validadores;
	}

}
