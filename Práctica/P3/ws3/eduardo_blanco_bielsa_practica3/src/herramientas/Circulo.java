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
		int centrox = (pulsacionx - moverx) / 2;
		int centroy = (pulsaciony - movery) / 2;
		if (pulsacionx > moverx)
			centrox = (pulsacionx - moverx) / 2;
		centrox = (moverx - pulsacionx) / 2;
		if (pulsaciony > movery)
			centroy = (pulsaciony - movery) / 2;
		centroy = (movery - pulsaciony) / 2;
		return "Círculo: (" + centrox + "," + centroy + "), radio = " + getRadius();
	}

	private int getRadius() {
		return Math.max(pulsacionx - moverx, pulsaciony - movery) / 2;
	}

}
