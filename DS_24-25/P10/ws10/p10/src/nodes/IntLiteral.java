package nodes;

import format.Visitor;

public class IntLiteral implements Expression {

    public int value;

    public IntLiteral(int value) {
        this.value = value;
    }

    @Override
    public Object accept(Visitor formatter, Object param) {
        return formatter.visit(this, param);
    }

}
