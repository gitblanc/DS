/**
 * 
 */
package model.marcadores;

import formulario.Editable;
import google.maps.Coordenadas;
import google.maps.Marcador;
import google.maps.Navegador;
import model.Monumento;

/**
 * 
 */
public class MarcadorMonumento implements Marcador, Editable {

	private Monumento monumento;
	private Navegador navegador;

	public MarcadorMonumento(Monumento monumento) {
		this.monumento = monumento;
		this.navegador = new Navegador();
	}

	@Override
	public Coordenadas getCoordenadas() {
		return this.navegador.getCoordenadas(monumento.getDirección());
	}

	@Override
	// Nombre y autor del monumento
	public String pulsaciónCorta() {
		return monumento.getNombre() + " " + monumento.getAutor();
	}

	@Override
	// Navegar hasta el coliseo con el GPS
	public void pulsaciónLarga() {
		navegador.navegarHasta(monumento.getDirección());
	}

	@Override
	public void imprimeEditable() {
		System.out.println("- Autor = " + monumento.getAutor());
		System.out.println("- Dirección = " + monumento.getDirección());
	}

	@Override
	public void setValor1(String texto) {
		this.monumento.setAutor(texto);
	}

	@Override
	public void setValor2(String texto) {
		this.monumento.setDirección(texto);
	}

	@Override
	public String getInfo() {
		return "Monumento";
	}

}
