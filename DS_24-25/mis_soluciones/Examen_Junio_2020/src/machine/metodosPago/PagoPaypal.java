/**
 * 
 */
package machine.metodosPago;

import machine.Machine;
import machine.MetodoPago;
import paypal.PayPalAPI;

/**
 * 
 */
public class PagoPaypal implements MetodoPago {

	private Machine machine;
	private PayPalAPI payPal = new PayPalAPI();

	public PagoPaypal(Machine machine) {
		this.machine = machine;
	}

	@Override
	public boolean pagar(double amount) {
		machine.getDisplay().show("Iniciando sesión en Paypal...\n");
		machine.getDisplay().show("Usuario: ");
		String username = machine.getKeyboard().readString();
		machine.getDisplay().show("Contraseña: ");
		String password = machine.getKeyboard().readString();
		String token = payPal.logIn(username, password);
		if (!payPal.isLogged(token)) {
			machine.getDisplay().show("Nombre de usuario o contraseña incorrect@\n");
			return false;
		} else {
			return payPal.checkout(token, amount);
		}
	}
}
