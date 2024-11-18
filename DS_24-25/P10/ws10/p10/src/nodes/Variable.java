package nodes;

import format.Visitor;

public class Variable implements Expression {

    // NOTA: deberían ser private con getters y setters, pero se dejan públicos para agilizar la clase
    public String name;
    private Object value;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public Object accept(Visitor formatter, Object param) {
        return formatter.visit(this, param);
    }
    
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}
}
