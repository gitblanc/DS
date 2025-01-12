package print.version_1;

import nodos.*;

public interface IdealVisitorSimple {
	
	Object visit(Programa p, Object param);

	Object visit(Read r, Object param);

	Object visit(Asignacion r, Object param);

	Object visit(Print p, Object param);

	Object visit(Variable r, Object param);

	Object visit(ConstanteInt s, Object param);

	Object visit(Suma s, Object param);

	Object visit(Producto s, Object param);

	Object visit(Division s, Object param);
}
