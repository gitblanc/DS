package machine;

import machine.model.Event;

public interface CodigoPromocional {

	String getId();

	double aplicarCodigoPromocional(Event selectedEvent, int numberOfTickets);

}
