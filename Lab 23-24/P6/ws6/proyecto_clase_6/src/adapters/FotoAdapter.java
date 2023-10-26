package adapters;

import google.maps.Coordenadas;
import google.maps.Marcador;
import google.maps.Navegador;
import model.Foto;

public class FotoAdapter implements MarkerConAutor, Marcador {

	private Foto foto;
	private Navegador nav = new Navegador();

	public FotoAdapter(Foto foto) {
		this.foto = foto;
	}

	@Override
	public Coordenadas getCoordenadas() {
		return foto.getCoordenadas();
	}

	@Override
	public String pulsaciónCorta() {
		return "Usuario: " + foto.getUsuario() + ", Descripción: " + foto.getDescripción();
	}

	@Override
	public void pulsaciónLarga() {
		foto.descargar();
	}

	public String getAutor() {
		return foto.getUsuario();
	}

	public String getDirección() {
		return nav.getDirección(getCoordenadas());
	}

	public void setAutor(String texto) {
		this.foto.setUsuario(texto);
	}

	public void setDirección(String texto) {
		Coordenadas c = nav.getCoordenadas(texto);
		this.foto.setCoordenadas(c);
	}

}
