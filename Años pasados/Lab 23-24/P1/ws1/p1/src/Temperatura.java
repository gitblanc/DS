/**
 * 
 */

/**
 * @author blanc
 *
 */
public class Temperatura {

	double grados = 0.0;

	public Temperatura(double grados) {
		this.grados = grados;
	}

	public double getGradosCelsius() {
		return grados;
	}

	public double getGradosFahrenheit() {
		return grados * 1.8 + 32;
	}

	public void setGradosCelsius(double grados) {
		this.grados = grados;
	}

	public void setGradosFahrenheit(double grados) {
		this.grados = (grados - 32) * 1.8;
	}
}
