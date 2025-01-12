/**
 * 
 */
package visitors;

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
public class Formateador implements Visitor {

	@Override
	public Object visit(Program nodo, Object param) {
		for (Statement st : nodo.statements) {
			st.accept(this, param);
		}
		return null;
	}

	@Override
	public Object visit(Arithmetic nodo, Object param) {
		nodo.left.accept(this, param);
		System.out.print(" " + nodo.operator.toString() + " ");
		nodo.right.accept(this, param);
		return null;
	}

	@Override
	public Object visit(Input nodo, Object param) {
		System.out.print("input ");
		nodo.variable.accept(this, param);
		System.out.println(";");
		return null;
	}

	@Override
	public Object visit(Print nodo, Object param) {
		System.out.print("print ");
		nodo.expression.accept(this, param);
		System.out.println(";");
		return null;
	}

	@Override
	public Object visit(Variable nodo, Object param) {
		System.out.print(nodo.name);
		return null;
	}

	@Override
	public Object visit(Assignment nodo, Object param) {
		nodo.variable.accept(this, param);
		System.out.println(" = ");
		nodo.expression.accept(this, param);
		System.out.println(";");
		return null;
	}

	@Override
	public Object visit(IntLiteral nodo, Object param) {
		System.out.print(nodo.value);
		return null;
	}

}
