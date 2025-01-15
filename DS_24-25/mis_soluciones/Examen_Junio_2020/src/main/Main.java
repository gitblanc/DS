package main;

import machine.*;
import machine.codigosPromocionales.CantidadFija;
import machine.codigosPromocionales.EntradaGratis;
import machine.codigosPromocionales.Porcentaje;
import machine.model.Event;

// El main sólo debería ser modificado para crear nuevos objetos que formen
// parte de la solución.
//
public class Main 
{
	public static void main(String[] args) 
	{		
		Machine machine = new Machine();
				
		// se introducen unos eventos en la máquina expendedora
		machine.addEvent(new Event("Concierto de los Rolling Stones", 120, 5));
		machine.addEvent(new Event("Cartelera: Blade runner", 10, 100));
		machine.addEvent(new Event("Actuación de Rubén García", 60, 80));
		machine.addEvent(new Event("Concierto de la OSPA", 90, 30));
		machine.addEvent(new Event("Ópera: Nabuco", 160, 20));
		
		// AMPLIACION: códigos promocionales
		machine.addCodigoPromocional(new CantidadFija("15EURACOS", 15));
		machine.addCodigoPromocional(new Porcentaje("VERANO20", 10));
		machine.addCodigoPromocional(new EntradaGratis("FREE1"));
		
		// se cede el control de la ejecución a la máquina
		machine.run();
	}
}
