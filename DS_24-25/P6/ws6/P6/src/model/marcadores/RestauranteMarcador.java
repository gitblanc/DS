package model.marcadores;

import formulario.Editable;
import google.maps.Coordenadas;
import google.maps.Marcador;
import google.maps.Navegador;
import model.Restaurante;

public class RestauranteMarcador implements Marcador, Editable {

	private Restaurante restaurante;
	private Navegador navegador = new Navegador();

	public RestauranteMarcador(Restaurante r) {
		this.restaurante = r;
	}

	@Override
	public Coordenadas getCoordenadas() {
		return navegador.getCoordenadas(restaurante.getDirección());
	}

	@Override
	public String pulsaciónCorta() {
		return restaurante.getNombre() + " " + restaurante.getTeléfono();
	}

	@Override
	public void pulsaciónLarga() {
		restaurante.llamar();
	}

	@Override
	public String toString() {
		return "restaurante";
	}

	@Override
	public String getValor1() {
		return restaurante.getNombre();
	}

	@Override
	public String getValor2() {
		return restaurante.getDirección();
	}

	@Override
	public String getValor1Label() {
		return "- Nombre: ";
	}

	@Override
	public String getValor2Label() {
		return "- Dirección: ";
	}

	@Override
	public void setValor1(String newVal1) {
		restaurante.setNombre(newVal1);
	}

	@Override
	public void setValor2(String newVal2) {
		restaurante.setDirección(newVal2);
	}

	@Override
	public void imprimeValoresModificables() {
		System.out.println("- Nombre = " + getValor1());
		System.out.println("- Dirección = " + getValor2());
	}
}
