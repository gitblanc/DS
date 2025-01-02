package format;

import nodes.*;

public interface Visitor {

    public void formatProgram(Program program);

    public void formatInput(Input input);

    public void formatPrint(Print print);

    public void formatVariable(Variable variable);

    public void formatArithmetic(Arithmetic arithmetic);

}
