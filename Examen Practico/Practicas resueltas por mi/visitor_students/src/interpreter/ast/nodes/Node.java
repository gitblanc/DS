package interpreter.ast.nodes;

import interpreter.visitors.Visitor;

public interface Node
{
	Object accept(Visitor v, Object param);
}
