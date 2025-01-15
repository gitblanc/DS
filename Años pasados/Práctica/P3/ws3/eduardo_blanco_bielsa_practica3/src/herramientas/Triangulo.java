package herramientas;

import editor.Herramienta;

@SuppressWarnings("unused")
public class Triangulo implements Herramienta {
	private int[] pulsaciones = new int[6];
	private int moverx;
	private int movery;
	private int cont = 0;

	@Override
	public void pulsar(int x, int y) {
		pulsaciones[cont] = x;
		pulsaciones[cont+1] = y;
		if (cont < 4)
			cont += 2;
		else if (cont < 5)
			cont++;
		else
			cont = 0;
	}

	@Override
	public void mover(int x, int y) {
	}

	@Override
	public String getType() {
		return "Triángulo (herramienta de creación de)";
	}

	@Override
	public String infoHerramienta() {
		return "Triángulo: (" + pulsaciones[0] + "," + pulsaciones[1] + ")," + "(" + pulsaciones[2] + ","
				+ pulsaciones[3] + ")," + "(" + pulsaciones[4] + "," + pulsaciones[5] + ")";
	}

}
