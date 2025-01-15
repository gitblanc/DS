/**
 * 
 */
package temperature;

/**
 * @author omenp
 *
 */
public class Temperature {

	public double value;

	public Temperature(double leeSensorCelsius) {
		this.value = leeSensorCelsius;
	}

	public double getValue() {
		return this.value;
	}

	public double asFahrenheit() {
		return getValue() * 9 / 5 + 32;
	}

}
