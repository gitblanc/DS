package nodes;

import format.Visitor;

public class Input implements Statement {

    // NOTA: deberían ser private con getters y setters, pero se dejan públicos para agilizar la clase
    public Variable variable;

    public Input(Variable variable) {
        this.variable = variable;
    }

    @Override
    public void selectMethod(Visitor formatter) {
        formatter.formatInput(this);
    }
}
