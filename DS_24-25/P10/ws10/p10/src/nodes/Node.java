package nodes;

import format.Visitor;

public interface Node {
    Object accept(Visitor visitor, Object param);
}
