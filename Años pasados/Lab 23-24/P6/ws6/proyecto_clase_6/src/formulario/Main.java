package formulario;

import adapters.*;
import google.maps.*;
import model.*;

public class Main {

	public static void main(String[] args) {

		Monumento monumento = new Monumento("Coliseo", "Vespasiano", "Avenida del Coliseo 1. Roma");
		Restaurante restaurante = new Restaurante("Mario", "Via della Dataria. Roma", "555 123 457");
		Foto foto = new Foto("Raúl", "Un perro mordiendo a un txurista", new Coordenadas(40, 40));

		MiniFormulario formulario = new MiniFormulario();
		formulario.editar(new MonumentoAdapter(monumento));

		// Tarea 1. Editar también restaurante. Que se puedan editar el nombre y la
		// dirección del mismo.

		MiniFormulario formulario2 = new MiniFormulario();
		formulario2.editar(new RestauranteAdapter(restaurante));

		// Tarea 2. Editar también foto. Que se puedan editar el usuario y la
		// descripción de la misma.

		MiniFormulario formulario3 = new MiniFormulario();
		formulario3.editar(new FotoAdapter(foto));

		// NOTA: Para simplificar, suponer que siempre se van a pedir sólo dos campos en
		// todo formulario

	}

}
