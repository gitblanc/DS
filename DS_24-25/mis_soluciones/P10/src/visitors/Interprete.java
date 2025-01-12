/**
 * 
 */
package visitors;

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
public class Interprete implements Visitor {

	private static Scanner scanner = new Scanner(System.in);
	private List<Variable> variables = new ArrayList<Variable>();

	@Override
	public Object visit(Program nodo, Object param) {
		for (Statement st : nodo.statements)
			st.accept(this, param);
		return null;
	}

	@Override
	public Object visit(Arithmetic nodo, Object param) {
		Object right = nodo.right.accept(this, param);
		Object left = nodo.left.accept(this, param);

		if (nodo.operator.equals("+")) {
			return Integer.parseInt(left.toString()) + Integer.parseInt(right.toString());
		} else if (nodo.operator.equals("-")) {
			return Integer.parseInt(left.toString()) - Integer.parseInt(right.toString());
		} else if (nodo.operator.equals("*")) {
			return Integer.parseInt(left.toString()) * Integer.parseInt(right.toString());
		} else if (nodo.operator.equals("/")) {
			return Integer.parseInt(left.toString()) / Integer.parseInt(right.toString());
		}
		return null;
	}

	@Override
	public Object visit(Input nodo, Object param) {
		System.out.println(nodo.variable.name.toString() + ":");
		String value = scanner.nextLine();
		nodo.variable.setValue(value);
		nodo.variable.accept(this, param);
		variables.add(nodo.variable);
		return null;
	}

	@Override
	public Object visit(Print nodo, Object param) {
		Object val = nodo.expression.accept(this, param);
		System.out.println(val);
		return null;
	}

	@Override
	public Object visit(Variable nodo, Object param) {
		for (Variable v : variables) {
			if (nodo.name.equals(v.name))
				return v.getValue();
		}
		return null;
	}

	@Override
	public Object visit(Assignment assignment, Object param) {
		assignment.expression.accept(this, param);
		variables.add(assignment.variable);
		return null;
	}

	@Override
	public Object visit(IntLiteral intLiteral, Object param) {
		System.out.println(intLiteral.value);
		return null;
	}

}
