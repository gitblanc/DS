package machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import machine.hardware.BillAcceptor;
import machine.hardware.CardReader;
import machine.hardware.Display;
import machine.hardware.Keyboard;
import machine.hardware.Printer;
import machine.metodosPago.PagoEfectivo;
import machine.metodosPago.PagoPaypal;
import machine.metodosPago.PagoTarjetaDeCredito;
import machine.model.Event;
import machine.model.Ticket;

public class Machine {

	private List<Event> events = new ArrayList<>();

	// los distintos componentes físicos con los que interactúa la máquina
	// expendedora
	private Display display = new Display();
	private Keyboard keyboard = new Keyboard();
	private Printer printer = new Printer();
	private CardReader cardReader = new CardReader();
	private BillAcceptor billAcceptor = new BillAcceptor();

	// Ampliación códigos de descuento
	private Map<String, CodigoPromocional> codigosPromocionales = new HashMap<>();

	// -- Métodos públicos
	// -------------------------------------------------------------------------

	public void addEvent(Event event) {
		events.add(event);
	}

	public void run() {
		while (true) {
			Event selectedEvent = selectEvent();

			display.show("\n¿Cuántas entradas desea comprar? ");
			int numberOfTickets = howManyTickets(selectedEvent.getAvailableTickets());

			// se calcula el importe a pagar
//			double amountToPay = numberOfTickets * selectedEvent.getPrice();

			// AMPLIACIÓN: introducción de código promocional
			CodigoPromocional promotionalCode = introducirCodigoPromocional();
			
			// modifica el amountToPay
			double amountToPay = calcularPrecioTotal(selectedEvent, numberOfTickets, promotionalCode);
			
			display.show(String.format("Importe a pagar: %.2f €%n", amountToPay));

			MetodoPago metodoPago = selectPaymentMode();

			// se realiza el pago
			boolean isValidPayment;

			// Adapter -> ampliación del promotional code
			isValidPayment = metodoPago.pagar(amountToPay);

			if (!isValidPayment) {
				display.show("No se ha podido completar el pago\n\n");
				continue;
			}

			// se generan las entradas
			List<Ticket> tickets = selectedEvent.generateTickets(numberOfTickets);

			// por último, la máquina imprime las entradas generadas
			display.show("\nSus entradas se están imprimiendo...\n");
			for (Ticket ticket : tickets) {
				printer.printTicket(ticket);
			}

			display.show("Gracias por su compra, que disfrute del evento.\n\n");
		}
	}

	// Aquí se aplica la Estrategia
	private double calcularPrecioTotal(Event selectedEvent, int numberOfTickets, CodigoPromocional promotionalCode) {
		if(promotionalCode != null)
			return promotionalCode.aplicarCodigoPromocional(selectedEvent, numberOfTickets);
		return numberOfTickets * selectedEvent.getPrice();
	}

	private CodigoPromocional introducirCodigoPromocional() {
		// Pedimos el código
		display.show("Introduce un código promocional (en blanco si no tienes ninguno): ");
		String code = keyboard.readString();
		return codigosPromocionales.get(code);
	}

	// -- Pago
	// -------------------------------------------------------------------------

	private MetodoPago selectPaymentMode() {
		display.show("\nEscoja un método de pago:\n");
		display.show("  1. Pago con tarjeta\n");
		display.show("  2. Pago en efectivo\n");
		display.show("  3. Pago con Paypal\n");
		int option = keyboard.readOption(3);
		switch (option) {
		case 1:
			return new PagoTarjetaDeCredito(this);
		case 2:
			return new PagoEfectivo(this);
		case 3:
			return new PagoPaypal(this);
		default:
			throw new AssertionError("Método de pago inválido");
		}
	}

	// -- Seleccionar evento
	// -------------------------------------------------------------------------

	private Event selectEvent() {
		showEvents();
		int option = keyboard.readOption(events.size());
		Event event = events.get(option - 1);
		showEvent(event);
		return event;
	}

	private void showEvents() {
		display.show("Seleccione un evento:\n");
		int i = 1;
		for (Event each : events) {
			System.out.printf("%d. %s%n", i, each.getName());
			i++;
		}
	}

	private void showEvent(Event event) {
		display.show("Evento seleccionado:\n");
		display.show("  " + event.getName() + "\n");
		display.show(String.format("  Quedan %d entradas disponibles a %.2f euros%n", event.getAvailableTickets(),
				event.getPrice()));
	}

	// -- Pedir el número de entradas
	// -------------------------------------------------------------------------

	private int howManyTickets(int availableTickets) {
		do {
			int numberOfTickets = keyboard.readInt();
			if (numberOfTickets <= availableTickets)
				return numberOfTickets;
			display.show(String.format("Sólo quedan %d entradas disponibles, seleccione un número menor: ",
					availableTickets));
		} while (true);
	}

	public CardReader getCardReader() {
		return this.cardReader;
	}

	public Display getDisplay() {
		return this.display;
	}

	public BillAcceptor getBillAcceptor() {
		return this.billAcceptor;
	}

	public Keyboard getKeyboard() {
		return this.keyboard;
	}

	public void addCodigoPromocional(CodigoPromocional code) {
		this.codigosPromocionales.put(code.getId(), code);
	}
}
