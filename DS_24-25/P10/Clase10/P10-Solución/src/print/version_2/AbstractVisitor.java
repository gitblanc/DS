package print.version_2;

import nodos.*;

public abstract class AbstractVisitor implements IdealVisitor {
	@Override
	public Object visit (Sentencia s, Object param) throws Exception  {
		if (s instanceof Read)
			return visit ((Read) s, param);
		else if (s instanceof Print)
			return visit ((Print) s, param);
		else if (s instanceof Asignacion)
			return visit ((Asignacion) s, param);
		else
			throw new Exception();
		
	}
	
	@Override
	public Object visit (Expresion e, Object param) throws Exception {
		if (e instanceof Suma)
			return visit ((Suma) e, param);
		else if (e instanceof Producto)
			return visit ((Producto) e, param);
		else if (e instanceof Division)
			return visit ((Division) e, param);
		else if (e instanceof Variable)
			return visit ((Variable) e, param);
		else if (e instanceof ConstanteInt)
			return visit ((ConstanteInt) e, param);
		else
			throw new Exception();
	}

	@Override
	public Object visit(Programa programa, Object param) throws Exception{
		throw new Exception();
	}
	
	@Override
	public Object visit(Print print, Object param) throws Exception{
		throw new Exception();
	}

	@Override
	public Object visit(Asignacion asigna, Object param) throws Exception{
		throw new Exception();
	}

	@Override
	public Object visit(Read read, Object param) throws Exception{
		throw new Exception();
	}

	@Override
	public Object visit(Suma suma, Object param) throws Exception{
		throw new Exception();
	}

	@Override
	public Object visit(Division div, Object param) throws Exception{
		throw new Exception();
	}

	@Override
	public Object visit(Producto prod, Object param) throws Exception{
		throw new Exception();
	}

	@Override
	public Object visit(Variable var, Object param) throws Exception{
		throw new Exception();
	}

	@Override
	public Object visit(ConstanteInt cte, Object param) throws Exception{
		throw new Exception();
	}

}
