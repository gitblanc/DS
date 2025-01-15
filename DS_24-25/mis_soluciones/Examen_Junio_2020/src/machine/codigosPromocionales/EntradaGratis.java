/**
 * 
 */
package machine.codigosPromocionales;

import machine.CodigoPromocional;
import machine.model.Event;

/**
 * 
 */
public class EntradaGratis implements CodigoPromocional {

	private String id;

	public EntradaGratis(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public double aplicarCodigoPromocional(Event selectedEvent, int numberOfTickets) {
		return (numberOfTickets - 1) * selectedEvent.getPrice();
	}

}
