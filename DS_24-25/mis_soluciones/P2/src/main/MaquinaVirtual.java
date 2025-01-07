/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.List;

import instructions.Add;
import instructions.Input;
import instructions.Jmp;
import instructions.Jmpg;
import instructions.Load;
import instructions.Mul;
import instructions.Output;
import instructions.Push;
import instructions.Store;
import instructions.Sub;

/**
 * 
 */
public class MaquinaVirtual {
//	private List<String[]> instrucciones = new ArrayList<>();
	private List<Instruccion> instrucciones = new ArrayList<>();
	private Estado estado = new Estado();

	// $ Cargar programa --------------------------------
	public void cargaInstruccion(String linea) {
		if (linea.trim().length() == 0)
			return;

		String[] palabras = linea.split(" ");
		if (palabras[0].equals("push"))
			instrucciones.add(new Push(Integer.parseInt(palabras[1])));
		else if (palabras[0].equals("add"))
			instrucciones.add(new Add());
		else if (palabras[0].equals("sub"))
			instrucciones.add(new Sub());
		else if (palabras[0].equals("mul"))
			instrucciones.add(new Mul());
		else if (palabras[0].equals("jmp"))
			instrucciones.add(new Jmp(Integer.parseInt(palabras[1])));
		else if (palabras[0].equals("jmpg"))
			instrucciones.add(new Jmpg(Integer.parseInt(palabras[1])));
		else if (palabras[0].equals("load"))
			instrucciones.add(new Load());
		else if (palabras[0].equals("store"))
			instrucciones.add(new Store());
		else if (palabras[0].equals("input"))
			instrucciones.add(new Input());
		else if (palabras[0].equals("output"))
			instrucciones.add(new Output());
	}

	// $ Motor de Ejecución --------------------------------
	public void ejecutaPrograma() {
		while (estado.getIp() < instrucciones.size()) {
			Instruccion instruccion = instrucciones.get(estado.getIp());
			instruccion.execute(estado);
		}
	}
}
