package nodes;

import format.Visitor;

public class Arithmetic implements Expression {

    // NOTA: deberían ser private con getters y setters, pero se dejan públicos para agilizar la clase
    public Expression left, right;
    public String operator;

    public Arithmetic(Expression left, String operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public void selectMethod(Visitor formatter) {
        formatter.formatArithmetic(this);
    }

}
