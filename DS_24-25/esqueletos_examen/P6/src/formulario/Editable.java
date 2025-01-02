package formulario;

public interface Editable {
	String getValor1();

	String getValor2();
	
	String getValor1Label();

	String getValor2Label();
	
	void setValor1(String newVal1);

	void setValor2(String newVal2);

	void imprimeValoresModificables();
}
