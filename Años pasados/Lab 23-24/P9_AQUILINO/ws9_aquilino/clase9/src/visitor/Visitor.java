package visitor;

import nodos.*;

public interface Visitor {
	Object visit(Programa p, Object param);

	Object visit(Print p, Object param);

	Object visit(Read r, Object param);

	Object visit(Suma s, Object param);

	Object visit(Variable v, Object param);

	Object visit(Producto p, Object param);

	Object visit(Division d, Object param);

	Object visit(Asignacion a, Object param);

	Object visit(ConstanteInt p, Object param);
}
