package visitor;

import nodos.*;

public class PrintVisitor implements Visitor {

	@Override
	public Object visit(Programa p, Object param) {
		for (Sentencia s : p.sentencias)
			s.accept(this, null);
		return null;
	}

	@Override
	public Object visit(Print p, Object param) {
		System.out.print("print ");
		p.expr.accept(this, param);
		System.out.println(";");
		return null;
	}

	@Override
	public Object visit(Read r, Object param) {
		System.out.print("read ");
		r.var.accept(this, param);
		System.out.println(";");
		return null;
	}

	@Override
	public Object visit(Suma s, Object param) {
		s.left.accept(this, param);
		System.out.print(" + ");
		s.right.accept(this, param);
		return null;
	}

	@Override
	public Object visit(Variable v, Object param) {
		System.out.print(v.name);
		return null;
	}

	@Override
	public Object visit(Producto p, Object param) {
		p.left.accept(this, param);
		System.out.print(" * ");
		p.right.accept(this, param);
		return null;
	}

	@Override
	public Object visit(Division d, Object param) {
		d.left.accept(this, param);
		System.out.print(" / ");
		d.right.accept(this, param);
		return null;
	}

	@Override
	public Object visit(Asignacion a, Object param) {
		a.variable.accept(this, param);
		System.out.print(" = ");
		a.expr.accept(this, param);
		System.out.println(";");
		return null;
	}

	@Override
	public Object visit(ConstanteInt p, Object param) {
		System.out.print(p.valor);
		return null;
	}
}
