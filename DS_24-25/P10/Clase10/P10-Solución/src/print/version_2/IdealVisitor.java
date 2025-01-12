package print.version_2;

import nodos.*;

public interface IdealVisitor {
	Object visit (Sentencia s, Object param) throws Exception;
	
	Object visit (Expresion e, Object param) throws Exception;
	
	Object visit(Programa p, Object param) throws Exception;

	Object visit(Read r, Object param) throws Exception;

	Object visit(Asignacion r, Object param) throws Exception;

	Object visit(Print p, Object param)throws Exception;

	Object visit(Variable r, Object param) throws Exception;

	Object visit(ConstanteInt s, Object param) throws Exception;

	Object visit(Suma s, Object param) throws Exception;

	Object visit(Producto s, Object param) throws Exception;

	Object visit(Division s, Object param) throws Exception;
}
