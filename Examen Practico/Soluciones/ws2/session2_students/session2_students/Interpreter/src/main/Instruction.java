package main;
/**
 * 
 */

/**
 * @author UO285176
 *
 */
public interface Instruction {
	int executeInstruction(Instruction[] sentence, int ip);
	@Override
	String toString();
}
