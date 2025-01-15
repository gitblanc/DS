/**
 * 
 */
package machine.codigosPromocionales;

import machine.CodigoPromocional;
import machine.model.Event;

/**
 * 
 */
public class Porcentaje implements CodigoPromocional {

	private String id;
	private int porcentaje;

	public Porcentaje(String id, int porcentaje) {
		this.id = id;
		this.porcentaje = porcentaje;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public double aplicarCodigoPromocional(Event selectedEvent, int numberOfTickets) {
		double amountToPay = numberOfTickets * selectedEvent.getPrice();
		return amountToPay - ((porcentaje * amountToPay) / 100);
	}

}
