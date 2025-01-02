package model.marcadores;

import formulario.Editable;
import google.maps.Coordenadas;
import google.maps.Marcador;
import google.maps.Navegador;
import model.Monumento;

public class MonumentoMarcador implements Marcador, Editable {

	private Monumento monumento;
	private Navegador navegador = new Navegador();

	public MonumentoMarcador(Monumento m) {
		this.monumento = m;
	}

	@Override
	public Coordenadas getCoordenadas() {
		return navegador.getCoordenadas(monumento.getDirección());
	}

	@Override
	public String pulsaciónCorta() {
		return monumento.getNombre() + " - " + monumento.getAutor();
	}

	@Override
	public void pulsaciónLarga() {
		navegador.navegarHasta(monumento.getDirección());
	}

	@Override
	public String toString() {
		return "monumento";
	}

	@Override
	public void imprimeValoresModificables() {
		System.out.println("- Autor = " + getValor1());
		System.out.println("- Dirección = " + getValor2());
	}

	@Override
	public String getValor1() {
		return monumento.getAutor();
	}

	@Override
	public String getValor2() {
		return monumento.getDirección();
	}

	@Override
	public void setValor1(String newVal1) {
		monumento.setAutor(newVal1);
	}

	@Override
	public void setValor2(String newVal2) {
		monumento.setDirección(newVal2);
	}

	@Override
	public String getValor1Label() {
		return "- Autor: ";
	}

	@Override
	public String getValor2Label() {
		return "- Dirección: ";
	}

}
