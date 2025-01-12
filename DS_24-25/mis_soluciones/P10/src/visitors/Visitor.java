package visitors;

import nodes.Arithmetic;
import nodes.Assignment;
import nodes.Input;
import nodes.IntLiteral;
import nodes.Print;
import nodes.Program;
import nodes.Variable;

public interface Visitor {

	public Object visit(Program nodo, Object param);

	public Object visit(Arithmetic nodo, Object param);

	public Object visit(Input nodo, Object param);

	public Object visit(Print nodo, Object param);

	public Object visit(Variable nodo, Object param);

	public Object visit(Assignment assignment, Object param);

	public Object visit(IntLiteral intLiteral, Object param);
}
