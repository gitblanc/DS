package herramientas;

import editor.Herramienta;

@SuppressWarnings("unused")
public class Rectangulo implements Herramienta {
	private int pulsacionx;
	private int pulsaciony;
	private int moverx;
	private int movery;

	@Override
	public void pulsar(int x, int y) {
		this.pulsacionx = x;
		this.pulsaciony = y;

	}

	@Override
	public void mover(int x, int y) {
		this.moverx = x;
		this.movery = y;
	}

	public int getWeight() {
		if (pulsacionx > moverx)
			return pulsacionx - moverx;
		return moverx - pulsacionx;
	}

	public int getHeight() {
		if (pulsaciony > movery)
			return pulsaciony - movery;
		return movery - pulsaciony;
	}

	@Override
	public String infoHerramienta() {
		int menorx;
		int menory;
		if (pulsacionx > moverx)
			menorx = moverx;
		else
			menorx = pulsacionx;
		if (pulsaciony > movery)
			menory = movery;
		else
			menory = pulsaciony;
		return "Rectángulo: (" + menorx + "," + menory + "), ancho = " + getWeight() + ", alto = " + getHeight();
	}
	
	@Override
	public String getType() {
		return "Rectángulo (herramienta de creación de)";
	}

}
