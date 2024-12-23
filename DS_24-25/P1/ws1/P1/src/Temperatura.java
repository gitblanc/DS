/**
 * @author UO285176
 *
 */
public class Temperatura {
	
	double grados = 0;

	public Temperatura(double grados) {
		this.grados = 0;
	}

	public double getCelsius() {
		return grados;
	}

	public double getFahrenheit() {
		return this.grados * 1.8 + 32;
	}

	public void setCelsius(double celsius) {
		this.grados = celsius;
	}

	public void setFahrenheit(double fahr) {
		this.grados = (fahr - 32) / 1.8;
	}
}
