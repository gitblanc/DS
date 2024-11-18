/**
 * 
 */
package format;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import nodes.Arithmetic;
import nodes.Assignment;
import nodes.Input;
import nodes.IntLiteral;
import nodes.Print;
import nodes.Program;
import nodes.Statement;
import nodes.Variable;

/**
 * 
 */
public class Interpreter implements Visitor {

	private static Scanner scanner = new Scanner(System.in);
	private List<Variable> variables = new ArrayList<Variable>();

	@Override
	public Object visit(Program program, Object param) {
		for (Statement statement : program.statements)
			statement.accept(this, param);
		return null;
	}

	@Override
	public Object visit(Input input, Object param) {
		System.out.print(input.variable.name.toString() + ": ");
		String nombre = scanner.nextLine();
		input.variable.setValue(nombre);
		input.variable.accept(this, param);
		variables.add(input.variable);
		return null;
	}

	@Override
	public Object visit(Print print, Object param) {
		Object val = print.expression.accept(this, param);
		System.out.println(val);
		return null;
	}

	@Override
	public Object visit(Variable variable, Object param) {
		for (Variable var : variables) {
			if (var.name.equals(variable.name)) {
				return var.getValue();
			}
		}
		return null;
	}

	@Override
	public Object visit(Arithmetic arithmetic, Object param) {
		Object der = arithmetic.right.accept(this, param);
		Object izq = arithmetic.left.accept(this, param);
		if (arithmetic.operator.equals("+"))
			return Integer.parseInt((String) izq) + Integer.parseInt((String) der);
		if (arithmetic.operator.equals("-"))
			return Integer.parseInt((String) izq) - Integer.parseInt((String) der);
		if (arithmetic.operator.equals("*"))
			return Integer.parseInt((String) izq) * Integer.parseInt((String) der);
		if (arithmetic.operator.equals("/"))
			return Integer.parseInt((String) izq) / Integer.parseInt((String) der);
		return null;
	}

	@Override
	public Object visit(Assignment assignment, Object param) {
		assignment.expression.accept(this, null);
		variables.add(assignment.variable);
		return null;
	}

	@Override
	public Object visit(IntLiteral intLiteral, Object param) {
		System.out.print(intLiteral.value);
		return null;
	}

}
