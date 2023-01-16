package interpreter;
/**
 * 
 */

/**
 * @author omenp
 *
 */
public interface Instruction {
	public int executeInstruction(Instruction[] sentence, int ip);
}
