package editor;

import java.util.ArrayList;

public class Drawing {
	ArrayList<Herramienta> herramientas = new ArrayList<>();

	public void draw(Herramienta herramienta) {
		System.out.println("Herramienta seleccionada: " + herramienta.getType());
		if (!herramientas.isEmpty())
			mostrarHerramientasCreadas();
	}

	public void addHerramienta(Herramienta herramienta) {
		if (herramienta.infoHerramienta() != "seleccion")
			herramientas.add(herramienta);
	}

	private void mostrarHerramientasCreadas() {
		System.out.println("Figuras: ");
		for (int i = herramientas.size() - 1; i > -1; i--) {
			System.out.print(herramientas.get(i).infoHerramienta());
			if (i == herramientas.size() - 1)
				System.out.print(" (*)");
			System.out.println("");
		}
	}
}
