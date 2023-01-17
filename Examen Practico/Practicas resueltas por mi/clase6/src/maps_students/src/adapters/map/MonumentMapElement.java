/**
 * 
 */
package adapters.map;

import google.maps.Coordinates;
import google.maps.GPS;
import google.maps.MapElement;
import model.Monument;

/**
 * @author omenp
 *
 */
public class MonumentMapElement implements MapElement {

	private Monument m;
	private GPS gps = new GPS();

	public MonumentMapElement(Monument monument) {
		if (monument == null)
			throw new IllegalArgumentException("Monument can't be null");
		this.m = monument;
	}

	@Override
	public String getTitle() {
		return "Monumento: " + m.getName();
	}

	@Override
	public Coordinates getCoordinates() {
		return gps.getCoordinates(m.getAddress());
	}

	@Override
	public String getHTMLInfo() {
		return "Info --> Monument: " + m.getName() + ", Author: " + m.getAuthor() + ", Address: " + m.getAddress();
	}

	@Override
	public void open() {
		gps.getDirectionsTo(m.getAddress());
	}

}
