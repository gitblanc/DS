package editor;

import herramientas.Seleccion;

public class Editor {
	private Drawing drawing;
	private Herramienta herramientaEnUso;

	public Editor(Drawing drawing) {
		setHerramienta(new Seleccion());
		setDrawing(drawing);
	}

	public Drawing getDrawing() {
		return drawing;
	}

	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}

	public void drawDocument() {
		drawing.draw(this.herramientaEnUso);
	}

	public void setHerramienta(Herramienta herramienta) {
		this.herramientaEnUso = herramienta;
	}

	public void pulsarHerramienta(int x, int y) {
		this.herramientaEnUso.pulsar(x, y);		
	}

	public void moverHerramienta(int x, int y) {
		this.herramientaEnUso.mover(x, y);		
	}

	public void soltarHerramienta() {
		createNewHerramienta();
		this.herramientaEnUso = new Seleccion();
	}

	private void createNewHerramienta() {
		drawing.addHerramienta(herramientaEnUso);
	}
}
