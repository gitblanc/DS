package adapters.map;

import google.maps.Coordinates;
import google.maps.GPS;
import google.maps.MapElement;
import model.Restaurant;

public class RestaurantMapElement implements MapElement {
	private Restaurant restaurant;
	private GPS gps = new GPS();

	public RestaurantMapElement(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String getTitle() {
		return restaurant.getName();
	}

	@Override
	public Coordinates getCoordinates() {
		return gps.getCoordinates(restaurant.getAddress());
	}

	@Override
	public String getHTMLInfo() {
		return String.format("Restaurant: %s, %s, %s", restaurant.getName(), restaurant.getPhone(),
				restaurant.getAddress());
	}

	@Override
	public void open() {
		restaurant.call();
	}

}
