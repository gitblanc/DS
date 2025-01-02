package formulario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Formulario básico para usar cuando se quieran pedir solo dos valores sobre algo */
public class MiniFormulario {

	public void editar(Editable editable) {

		System.out.println("Editando " + editable.toString() + ".");

		System.out.println("Valores actuales:");
		// imprimeMonumento(monumento);
		imprimeEditable(editable);

		System.out.println("Escriba nuevos valores (dejar en blanco para dejar el valor actual):");
		System.out.println(editable.getValor1Label());
		String texto = getLínea();
		if (texto.length() > 0)
			// monumento.setAutor(texto);
			editable.setValor1(texto);

		System.out.println(editable.getValor2Label());
		texto = getLínea();
		if (texto.length() > 0)
			// monumento.setDirección(texto);
			editable.setValor2(texto);

		System.out.println("Valores finales:");
		// imprimeMonumento(monumento);
		imprimeEditable(editable);
	}

	private void imprimeEditable(Editable editable) {
		editable.imprimeValoresModificables();
	}

//	private void imprimeMonumento(Monumento monumento) {
//		System.out.println("- Autor = " + monumento.getAutor());
//		System.out.println("- Dirección = " + monumento.getDirección());
//	}

	private String getLínea() {
		do {
			try {
				return consola.readLine();
			} catch (IOException ex) {
				System.out.println("Error de lectura. Inténtelo de nuevo.");
			}
		} while (true);
	}

	BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
}
