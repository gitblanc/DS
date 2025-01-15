/**
 * 
 */
package instructions;

/**
 * @author blanc
 *
 */
public interface Instruction {
	int execute(Instruction[] instruccion, int ip);
}	
