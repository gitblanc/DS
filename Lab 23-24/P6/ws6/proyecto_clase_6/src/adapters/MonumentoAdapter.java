package adapters;

import google.maps.Coordenadas;
import google.maps.Marcador;
import google.maps.Navegador;
import model.Monumento;

public class MonumentoAdapter implements Marcador, MarkerConAutor {

	private Monumento monumento;
	private Navegador nav = new Navegador();

	public MonumentoAdapter(Monumento m) {
		this.monumento = m;
	}

	@Override
	public Coordenadas getCoordenadas() {
		return nav.getCoordenadas(this.monumento.getDirección());
	}

	@Override
	public String pulsaciónCorta() {
		return "Monumento: " + monumento.getNombre() + ", Autor: " + monumento.getAutor();
	}

	@Override
	public void pulsaciónLarga() {
		nav.navegarHasta(monumento.getDirección());
	}

	@Override
	public String getAutor() {
		return monumento.getAutor();
	}

	@Override
	public String getDirección() {
		return monumento.getDirección();
	}

	@Override
	public void setAutor(String texto) {
		monumento.setAutor(texto);
	}

	@Override
	public void setDirección(String texto) {
		monumento.setDirección(texto);
	}

}
