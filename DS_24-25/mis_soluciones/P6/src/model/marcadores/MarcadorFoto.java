/**
 * 
 */
package model.marcadores;

import formulario.Editable;
import google.maps.Coordenadas;
import google.maps.Marcador;
import model.Foto;

/**
 * 
 */
public class MarcadorFoto implements Marcador, Editable {

	private Foto foto;

	public MarcadorFoto(Foto foto) {
		this.foto = foto;
	}

	@Override
	public Coordenadas getCoordenadas() {
		return foto.getCoordenadas();
	}

	@Override
	// Usuario que la ha subido y descripción de la foto
	public String pulsaciónCorta() {
		return foto.getUsuario() + " " + foto.getDescripción();
	}

	@Override
	// Bajarse foto
	public void pulsaciónLarga() {
		foto.descargar();
	}
	
	@Override
	public void imprimeEditable() {
		System.out.println("- Usuario = " + foto.getUsuario());
		System.out.println("- Descripción = " + foto.getDescripción());
	}

	@Override
	public void setValor1(String texto) {
		this.foto.setUsuario(texto);
	}

	@Override
	public void setValor2(String texto) {
		this.foto.setDescripción(texto);
	}

	@Override
	public String getInfo() {
		return "foto";
	}

}
