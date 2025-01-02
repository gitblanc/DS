package format;

import nodes.*;

public class Formatter implements Visitor {

    public Object visit(Program program, Object param) {
        for (Statement statement : program.statements)
            statement.accept(this, param);
        return null;
    }

    public Object visit(Input input, Object param) {
        System.out.print("input ");
        input.variable.accept(this, param);
        System.out.println(";");
        return null;
    }

    public Object visit(Print print, Object param) {
        System.out.print("print ");
        print.expression.accept(this, param);
        System.out.println(";");
        return null;
    }

    public Object visit(Variable variable, Object param) {
        System.out.print(variable.name);
        return null;
    }

    public Object visit(Arithmetic arithmetic, Object param) {
        arithmetic.left.accept(this, param);
        System.out.print(" " + arithmetic.operator + " ");
        arithmetic.right.accept(this, param);
        return null;
    }

    @Override
    public Object visit(Assignment assignment, Object param) {
        assignment.variable.accept(this, param);
        System.out.print(" = ");
        assignment.expression.accept(this, param);
        System.out.println(";");
        return null;
    }

    @Override
    public Object visit(IntLiteral intLiteral, Object param) {
        System.out.print(intLiteral.value);
        return null;
    }
}
