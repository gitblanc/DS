package interpreter.ast.visitors;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;

import interpreter.ast.nodes.Assignment;
import interpreter.ast.nodes.Division;
import interpreter.ast.nodes.IntegerLiteral;
import interpreter.ast.nodes.Print;
import interpreter.ast.nodes.Product;
import interpreter.ast.nodes.Program;
import interpreter.ast.nodes.Read;
import interpreter.ast.nodes.Statement;
import interpreter.ast.nodes.Sum;
import interpreter.ast.nodes.Variable;

public class ExecutionVisitor implements Visitor {

	BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	private HashMap<String, Integer> memory = new HashMap<>();

	@Override
	public Object visit(Program program, Object param) {
		for (Statement statement : program.statements) {
			statement.accept(this, null);
		}
		return null;
	}

	@Override
	public Object accept(Assignment assignment, Object param) {
		String variable = assignment.variable.name;
		int value = (int) assignment.expression.accept(this, null);
		memory.put(variable, value);
		return null;
	}

	@Override
	public Object accept(Division division, Object param) {
		int leftValue = (int) division.left.accept(this, null);
		int rightValue = (int) division.right.accept(this, null);
		return leftValue / rightValue;
	}

	@Override
	public Object accept(IntegerLiteral integerLiteral, Object param) {
		return Integer.valueOf(integerLiteral.value);
	}

	@Override
	public Object accept(Print print, Object param) {
		System.out.println(print.expression.accept(this, null));
		return null;
	}

	@Override
	public Object accept(Product product, Object param) {
		int leftValue = (int) product.left.accept(this, null);
		int rightValue = (int) product.right.accept(this, null);
		return leftValue * rightValue;
	}

	@Override
	public Object accept(Read read, Object param) {
		while (true) {
			try {
				System.out.println(read.variable.name + ": ");
				int value = Integer.parseInt(console.readLine());
				memory.put(read.variable.name, value);
				return null;
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Object accept(Sum sum, Object param) {
		int leftValue = (int) sum.left.accept(this, null);
		int rightValue = (int) sum.right.accept(this, null);
		return leftValue + rightValue;
	}

	@Override
	public Object accept(Variable variable, Object param) {
		return memory.get(variable.name);
	}

}
