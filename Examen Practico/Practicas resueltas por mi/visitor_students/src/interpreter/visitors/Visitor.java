/**
 * 
 */
package interpreter.visitors;

import interpreter.ast.nodes.*;

/**
 * @author omenp
 *
 */
public interface Visitor {
	Object visit(Program p, Object param);

	Object visit(Assignment p, Object param);

	Object visit(Division p, Object param);

	Object visit(Print p, Object param);

	Object visit(IntegerLiteral p, Object param);

	Object visit(Product p, Object param);

	Object visit(Read p, Object param);

	Object visit(Sum p, Object param);

	Object visit(Variable p, Object param);
}
