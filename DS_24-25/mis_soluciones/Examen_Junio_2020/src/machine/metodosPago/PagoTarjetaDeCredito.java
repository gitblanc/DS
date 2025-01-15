/**
 * 
 */
package machine.metodosPago;

import machine.Machine;
import machine.MetodoPago;
import ruralvia.BankGateway;

/**
 * 
 */
public class PagoTarjetaDeCredito implements MetodoPago {

	private Machine machine;
	// pasarela de pagos (para los pagos con tarjeta)
	private BankGateway bankGateway = new BankGateway();

	public PagoTarjetaDeCredito(Machine machine) {
		this.machine = machine;
	}

	@Override
	public boolean pagar(double amount) {
		String cardNumber = machine.getCardReader().readCardNumber();
		boolean isValid = bankGateway.pay(cardNumber, amount);
		if (!isValid) {
			machine.getDisplay().show("Tarjeta rechazada\n");
			return false;
		}
		// pago correcto
		machine.getDisplay().show("Tarjeta aceptada: pago realizado con éxito\n");
		return true;
	}

}
