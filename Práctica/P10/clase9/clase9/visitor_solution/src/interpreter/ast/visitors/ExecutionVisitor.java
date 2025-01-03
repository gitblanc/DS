package interpreter.ast.visitors;

import java.io.*;
import java.util.HashMap;

import interpreter.ast.nodes.*;

public class ExecutionVisitor implements Visitor
{
	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	private HashMap<String, Integer> memory = new HashMap<>();

	@Override
	public Object visit(Program program, Object param) 
	{
		for (Statement statement : program.statements) {
			statement.accept(this, null);
		}
		return null;
	}

	@Override
	public Object visit(Assignment assignment, Object param) 
	{
		String variableName = assignment.variable.name;
		int value = (int) assignment.expression.accept(this, null);
		memory.put(variableName, value);
		return null;
	}

	@Override
	public Object visit(Sum sum, Object param) 
	{
		int leftValue = (int) sum.left.accept(this, null);
		int rightValue = (int) sum.right.accept(this, null);
		return leftValue + rightValue;
	}

	@Override
	public Object visit(Product product, Object param) 
	{
		int leftValue = (int) product.left.accept(this, null);
		int rightValue = (int) product.right.accept(this, null);
		return leftValue * rightValue;
	}

	@Override
	public Object visit(Division division, Object param) 
	{
		int leftValue = (int) division.left.accept(this, null);
		int rightValue = (int) division.right.accept(this, null);
		return leftValue / rightValue;
	}

	@Override
	public Object visit(Print print, Object param) 
	{
		System.out.println(print.expression.accept(this, null));
		return null;
	}

	@Override
	public Object visit(Read read, Object param) 
	{
		while (true) {
			try {
				System.out.print(read.variable.name + ": ");
				int value = Integer.parseInt(console.readLine());
				memory.put(read.variable.name, value);
				return null;
			} catch (NumberFormatException e) {
				System.out.println("El valor de la variable debe ser un número entero");
			} catch (IOException e) {
				System.out.println("Se produjo un error al leer el valor de la variable");				
			}
		}
	}

	@Override
	public Object visit(Variable variable, Object param) 
	{
		return memory.get(variable.name);
	}

	@Override
	public Object visit(IntegerLiteral literal, Object param) 
	{
		return Integer.valueOf(literal.value);
	}
}
