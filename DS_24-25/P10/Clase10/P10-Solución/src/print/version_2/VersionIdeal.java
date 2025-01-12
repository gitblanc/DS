package print.version_2;

import nodos.*;

/*
 * No se puede hacer: no hay doble-dispatch en Java
 */

public class VersionIdeal extends AbstractVisitor {

	@Override
	public Object visit(Programa programa, Object param) throws Exception {
		for (Sentencia sentencia:programa.sentencias)
			visit(sentencia, param);
		return null;
	}

	@Override
	public Object visit(Print print, Object param) throws Exception {
		System.out.print("print ");
		visit(print.expr, param);
		System.out.println(";");
		return null;
	}

	@Override
	public Object visit(Asignacion asigna, Object param) throws Exception {
		visit(asigna.variable, param);
		System.out.print(" = ");
		visit(asigna.expr, param);
		System.out.println(";");
		return null;
	}

	@Override
	public Object visit(Read read, Object param) throws Exception{
		System.out.print("read ");
		visit(read.var, param);
		System.out.println(";");
		return null;
	}

	@Override
	public Object visit(Suma suma, Object param) throws Exception{
		visit(suma.left, param);
		System.out.print(" + ");
		visit(suma.right, param);
		return null;
	}

	@Override
	public Object visit(Division div, Object param) throws Exception{
		visit(div.left, param);
		System.out.print(" / ");
		visit(div.right, param);
		return null;
	}

	@Override
	public Object visit(Producto prod, Object param) throws Exception{
		visit(prod.left, param);
		System.out.print(" * ");
		visit(prod.right, param);
		return null;
	}

	@Override
	public Object visit(Variable var, Object param) throws Exception{
		System.out.print(var.name);
		return null;
	}

	@Override
	public Object visit(ConstanteInt cte, Object param) throws Exception{
		System.out.print(cte.valor);
		return null;
	}

}
