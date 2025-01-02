package model.marcadores;

import formulario.Editable;
import google.maps.Coordenadas;
import google.maps.Marcador;
import model.Foto;

public class FotoMarcador implements Marcador, Editable {

	private Foto foto;

	public FotoMarcador(Foto f) {
		this.foto = f;
	}

	@Override
	public Coordenadas getCoordenadas() {
		return foto.getCoordenadas();
	}

	@Override
	public String pulsaciónCorta() {
		return foto.getUsuario() + " - " + foto.getDescripción();
	}

	@Override
	public void pulsaciónLarga() {
		foto.descargar();
	}

	@Override
	public String toString() {
		return "foto";
	}

	@Override
	public String getValor1() {
		return foto.getUsuario();
	}

	@Override
	public String getValor2() {
		return foto.getDescripción();
	}

	@Override
	public String getValor1Label() {
		return "- Usuario: ";
	}

	@Override
	public String getValor2Label() {
		return "- Descripción: ";
	}

	@Override
	public void setValor1(String newVal1) {
		foto.setUsuario(newVal1);
	}

	@Override
	public void setValor2(String newVal2) {
		foto.setDescripción(newVal2);
	}

	@Override
	public void imprimeValoresModificables() {
		System.out.println("- Usuario = " + getValor1());
		System.out.println("- Descripción = " + getValor2());
	}

}
