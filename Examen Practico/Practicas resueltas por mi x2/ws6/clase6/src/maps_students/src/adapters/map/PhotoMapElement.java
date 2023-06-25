package adapters.map;

import google.maps.Coordinates;
import google.maps.MapElement;
import model.Photo;

public class PhotoMapElement implements MapElement {

	private Photo photo;

	public PhotoMapElement(Photo photo) {
		this.photo = photo;
	}

	@Override
	public String getTitle() {
		return photo.getDescription();
	}

	@Override
	public Coordinates getCoordinates() {
		return photo.getCoordinates();
	}

	@Override
	public String getHTMLInfo() {
		return String.format("Photo: %s, %s, %s", photo.getDescription(), photo.getUser(), photo.getCoordinates());
	}

	@Override
	public void open() {
		photo.show();
	}

}
