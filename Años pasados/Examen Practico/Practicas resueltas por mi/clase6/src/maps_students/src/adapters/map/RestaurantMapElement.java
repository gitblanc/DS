/**
 * 
 */
package adapters.map;

import google.maps.Coordinates;
import google.maps.GPS;
import google.maps.MapElement;
import model.Restaurant;

/**
 * @author omenp
 *
 */
public class RestaurantMapElement implements MapElement {

	private Restaurant r;
	private GPS gps = new GPS();

	public RestaurantMapElement(Restaurant restaurant) {
		if (restaurant == null)
			throw new IllegalArgumentException("Restaurant can't be null");
		this.r = restaurant;
	}

	@Override
	public String getTitle() {
		return "Monumento: " + r.getName();
	}

	@Override
	public Coordinates getCoordinates() {
		return gps.getCoordinates(r.getAddress());
	}

	@Override
	public String getHTMLInfo() {
		return "Info --> Restaurant: " + r.getName() + ", Phone: " + r.getPhone() + ", Address: " + r.getAddress();
	}

	@Override
	public void open() {
		r.call();
	}

}
