/**
 * 
 */
package adapters.map;

import google.maps.Coordinates;
import google.maps.MapElement;
import model.Photo;

/**
 * @author omenp
 *
 */
public class PhotoMapElement implements MapElement {

	private Photo p;

	public PhotoMapElement(Photo photo) {
		if (photo == null)
			throw new IllegalArgumentException("Photo can't be null");
		this.p = photo;
	}

	@Override
	public String getTitle() {
		return "Photo: " + p.getDescription();
	}

	@Override
	public Coordinates getCoordinates() {
		return p.getCoordinates();
	}

	@Override
	public String getHTMLInfo() {
		return "Info --> Photo: " + p.getDescription() + ", Author: " + p.getUser() + ", Coords: " + p.getCoordinates();
	}

	@Override
	public void open() {
		p.show();
	}

}
