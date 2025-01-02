package nodes;

import format.Visitor;

public class Variable implements Expression {

    // NOTA: deberían ser private con getters y setters, pero se dejan públicos para agilizar la clase
    public String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public void selectMethod(Visitor formatter) {
        formatter.formatVariable(this);
    }
}
