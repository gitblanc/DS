/**
 * 
 */
package model.marcadores;

import formulario.Editable;
import google.maps.Coordenadas;
import google.maps.Marcador;
import google.maps.Navegador;
import model.Restaurante;

/**
 * 
 */
public class MarcadorRestaurante implements Marcador, Editable {

	private Restaurante restaurante;
	private Navegador navegador;

	public MarcadorRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
		this.navegador = new Navegador();
	}

	@Override
	public Coordenadas getCoordenadas() {
		return navegador.getCoordenadas(restaurante.getDirección());
	}

	@Override
	// Nombre y teléfono de reservas
	public String pulsaciónCorta() {
		return restaurante.getNombre() + " " + restaurante.getTeléfono();
	}

	@Override
	// Llamar al restaurante
	public void pulsaciónLarga() {
		restaurante.llamar();
	}

	@Override
	public void imprimeEditable() {
		System.out.println("- Nombre = " + restaurante.getNombre());
		System.out.println("- Dirección = " + restaurante.getDirección());
	}

	@Override
	public void setValor1(String texto) {
		this.restaurante.setNombre(texto);
	}

	@Override
	public void setValor2(String texto) {
		this.restaurante.setDirección(texto);
	}

	@Override
	public String getInfo() {
		return "Restaurante";
	}
}
