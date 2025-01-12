package nodes;

import visitors.Visitor;

public interface Node {
    Object accept(Visitor visitor, Object param);
}
