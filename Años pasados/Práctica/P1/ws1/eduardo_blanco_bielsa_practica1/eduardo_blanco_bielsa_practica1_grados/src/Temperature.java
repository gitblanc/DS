
public class Temperature {

	private double celsius;
	private double fahrenheit;

	public Temperature(double value) {
		setCelsius(value);
	}

	public void setCelsius(double value) {
		this.celsius = value;
		this.fahrenheit = celsius * 9 / 5 + 32;
	}

	public void setFahrenheit(double value) {
		this.celsius = (value - 32) * 5 / 9;
		this.fahrenheit = value;
	}

	public double asCelsius() {
		return celsius;
	}

	public double asFahrenheit() {
		return fahrenheit;
	}
}
