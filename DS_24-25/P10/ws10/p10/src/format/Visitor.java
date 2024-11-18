package format;

import nodes.*;

public interface Visitor {

    public Object visit(Program program, Object param);

    public Object visit(Input input, Object param);

    public Object visit(Print print, Object param);

    public Object visit(Variable variable, Object param);

    public Object visit(Arithmetic arithmetic, Object param);

    public Object visit(Assignment assignment, Object param);

    public Object visit(IntLiteral intLiteral, Object param);

}
