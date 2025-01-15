package interpreter.ast.visitors;

import interpreter.ast.nodes.*;

public interface Visitor {

	Object visit(Program program, Object param);

	Object accept(Assignment assignment, Object param);

	Object accept(Division division, Object param);

	Object accept(IntegerLiteral integerLiteral, Object param);

	Object accept(Print print, Object param);

	Object accept(Product product, Object param);

	Object accept(Read read, Object param);

	Object accept(Sum sum, Object param);

	Object accept(Variable variable, Object param);

}
