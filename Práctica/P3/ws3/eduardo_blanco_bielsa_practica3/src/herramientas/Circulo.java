package herramientas;

import editor.Herramienta;

public class Circulo implements Herramienta {

	private int pulsacionx;
	private int pulsaciony;
	private int moverx;
	private int movery;

	@Override
	public void pulsar(int x, int y) {
		pulsacionx = x;
		pulsaciony = y;
	}

	@Override
	public void mover(int x, int y) {
		moverx = x;
		movery = y;
	}

	@Override
	public String getType() {
		return "Círculo (herramienta de creación de)";
	}

	@Override
	public String infoHerramienta() {
		int centrox;
		int centroy;
		if (pulsacionx > moverx)
			centrox = moverx + (pulsacionx - moverx) / 2;
		else
			centrox = pulsacionx + (moverx - pulsacionx) / 2;
		if (pulsaciony > movery)
			centroy = movery + (pulsaciony - movery) / 2;
		else
			centroy = pulsaciony + (movery - pulsaciony) / 2;
		return "Círculo: (" + centrox + "," + centroy + "), radio = " + getRadius();
	}

	private int getRadius() {
		if (pulsacionx > moverx)
			return (pulsacionx - moverx)/2;
		return (moverx - pulsacionx)/2;
	}

}
