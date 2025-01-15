/**
 * 
 */
package machine.metodosPago;

import machine.Machine;
import machine.MetodoPago;

/**
 * 
 */
public class PagoEfectivo implements MetodoPago {

	private Machine machine;

	public PagoEfectivo(Machine machine) {
		this.machine = machine;
	}

	@Override
	public boolean pagar(double amount) {
		int insertedAmount = 0;
		boolean cancel = false;
		machine.getBillAcceptor().reset();
		do {
			machine.getDisplay().show(String.format("Quedan por pagar %.2f €%n", amount - insertedAmount));
			double inserted = machine.getBillAcceptor().insertBill();
			insertedAmount = machine.getBillAcceptor().getTotalAmount();
			if (inserted == 0)
				cancel = true;
		} while (insertedAmount < amount && !cancel);

		if (cancel) {
			machine.getDisplay().show("Operación cancelada por el usuario\n");
			// si antes de cancelar había introducido dinero, se le devuelve
			if (insertedAmount > 0)
				machine.getBillAcceptor().returnChange(insertedAmount);
			return false;
		}
		machine.getDisplay().show("Pago completado\n");
		// se devuelve el cambio
		if (insertedAmount > amount) {
			machine.getBillAcceptor().returnChange(insertedAmount - amount);
		}
		return true;
	}

}
