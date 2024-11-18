package nodes;

import java.util.*;

import format.Visitor;

public class Program implements Node {

    // NOTA: deberían ser private con getters y setters, pero se dejan públicos para agilizar la clase
    public List<Statement> statements;

    public Program(List<Statement> statements) {
        this.statements = new ArrayList<>(statements);
    }

    @Override
    public Object accept(Visitor formatter, Object param) {
        return formatter.visit(this, param);
    }

}
