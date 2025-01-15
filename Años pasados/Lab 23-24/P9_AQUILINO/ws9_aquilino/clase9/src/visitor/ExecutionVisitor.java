package visitor;

import java.io.*;
import java.util.HashMap;

import nodos.*;

public class ExecutionVisitor implements Visitor {
	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	private HashMap<String, Integer> memoria = new HashMap<>();

	@Override
	public Object visit(Programa program, Object param) {
		for (Sentencia statement : program.sentencias) {
			statement.accept(this, null);
		}
		return null;
	}

	@Override
	public Object visit(Asignacion assignment, Object param) {
		String variableName = assignment.variable.name;
		int value = (int) assignment.expr.accept(this, null);
		memoria.put(variableName, value);
		return null;
	}

	@Override
	public Object visit(Suma sum, Object param) {
		int leftValue = (int) sum.left.accept(this, null);
		int rightValue = (int) sum.right.accept(this, null);
		return leftValue + rightValue;
	}

	@Override
	public Object visit(Producto product, Object param) {
		int leftValue = (int) product.left.accept(this, null);
		int rightValue = (int) product.right.accept(this, null);
		return leftValue * rightValue;
	}

	@Override
	public Object visit(Division division, Object param) {
		int leftValue = (int) division.left.accept(this, null);
		int rightValue = (int) division.right.accept(this, null);
		return leftValue / rightValue;
	}

	@Override
	public Object visit(Print print, Object param) {
		System.out.println(print.expr.accept(this, null));
		return null;
	}

	@Override
	public Object visit(Read read, Object param) {
		while (true) {
			try {
				System.out.print(read.var.name + ": ");
				int value = Integer.parseInt(console.readLine());
				memoria.put(read.var.name, value);
				return null;
			} catch (NumberFormatException e) {
				System.out.println("El valor de la variable debe ser un número entero");
			} catch (IOException e) {
				System.out.println("Se produjo un error al leer el valor de la variable");
			}
		}
	}

	@Override
	public Object visit(Variable variable, Object param) {
		return memoria.get(variable.name);
	}

	@Override
	public Object visit(ConstanteInt literal, Object param) {
		return Integer.valueOf(literal.valor);
	}
}