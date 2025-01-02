package nodes;

import format.Visitor;

public interface Node {
    void selectMethod(Visitor visitor);
}
