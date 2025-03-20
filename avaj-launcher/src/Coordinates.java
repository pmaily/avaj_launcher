public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}

	public void increaseLongitude(int value) {
		this.longitude += value;
	}

	public void increaseLatitude(int value) {
		this.latitude += value;
	}

	public void increaseHeight(int value) {
		this.height += value;
		if (height > 100) {
			height = 100;
		} else if (height < 0) {
			height = 0;
		}
	}
}
