package nodes;

import format.Visitor;

public class Print implements Statement {

    // NOTA: deberían ser private con getters y setters, pero se dejan públicos para agilizar la clase
    public Expression expression;

    public Print(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Object accept(Visitor formatter, Object param) {
        return formatter.visit(this, param);
    }

}
