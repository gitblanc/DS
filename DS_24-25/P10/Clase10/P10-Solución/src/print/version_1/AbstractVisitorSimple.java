package print.version_1;

import nodos.*;

public abstract class AbstractVisitorSimple implements IdealVisitorSimple {

	public Object visit (Sentencia s, Object param)  {
		if (s instanceof Read)
			return visit ((Read) s, param);
		else if (s instanceof Print)
			return visit ((Print) s, param);
		else if (s instanceof Asignacion)
			return visit ((Asignacion) s, param);
		else
			System.out.println("La sentencia " + s.getClass().getName() + " no está tratada en AbstractVisitorSimple");
		return null;
		
	}
	
	public Object visit (Expresion e, Object param) {
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
			System.out.println("La expresión " + e.getClass().getName() + " no está tratada en AbstractVisitorSimple");
		return null;
	}

}
