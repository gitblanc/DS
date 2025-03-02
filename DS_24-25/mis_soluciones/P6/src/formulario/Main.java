package formulario;

import google.maps.*;
import model.*;
import model.marcadores.MarcadorFoto;
import model.marcadores.MarcadorMonumento;
import model.marcadores.MarcadorRestaurante;

public class Main {

    public static void main(String[] args) {

        Monumento monumento = new Monumento("Coliseo", "Vespasiano", "Avenida del Coliseo 1. Roma");
        Restaurante restaurante = new Restaurante("Mario", "Via della Dataria. Roma", "555 123 457");
        Foto foto = new Foto("Raúl", "Un perro mordiendo a un turista", new Coordenadas(40, 40));

        MiniFormulario formulario = new MiniFormulario();
        formulario.editar(new MarcadorMonumento(monumento));
        formulario.editar(new MarcadorRestaurante(restaurante));
        formulario.editar(new MarcadorFoto(foto));

        // Tarea 1. Editar también restaurante. Que se puedan editar el nombre y la dirección del mismo.

        // Tarea 2. Editar también foto. Que se puedan editar el usuario y la descripción de la misma.

        // NOTA: Para simplificar, suponer que siempre se van a pedir sólo dos campos en todo formulario
    }

}
