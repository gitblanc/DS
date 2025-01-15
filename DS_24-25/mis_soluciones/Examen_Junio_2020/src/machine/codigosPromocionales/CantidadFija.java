/**
 * 
 */
package machine.codigosPromocionales;

import machine.CodigoPromocional;
import machine.model.Event;

/**
 * 
 */
public class CantidadFija implements CodigoPromocional {

	private String id;
	private int cantidad;

	public CantidadFija(String id, int cantidad) {
		this.id = id;
		this.cantidad = cantidad;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public double aplicarCodigoPromocional(Event selectedEvent, int numberOfTickets) {
		double amountToPay = numberOfTickets * selectedEvent.getPrice();
		double res = amountToPay - cantidad;
		if (res < 0)
			return 0;
		return res;
	}

}
