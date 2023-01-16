import form.Campo;
import form.Formulario;
import form.validator.PredefinedValidator;

public class Main {

	public static void main(String[] args) {
		Formulario formulario = new Formulario();

		formulario.addCampo(new Campo("Nombre", Campo.TEXT));
		formulario.addCampo(new Campo("Apellido", Campo.TEXT));
		formulario.addCampo(new Campo("Telefono", Campo.NUMBER));
		formulario.addCampo(new Campo("Ciudad", new PredefinedValidator("Santander", "Oviedo", "Cadiz")));

		formulario.PideDatos();
	}
}
