public class Baloon extends Aircraft {


	protected Baloon(final long p_id, final String p_name, final Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String message = "Baloon#" + name + "(" + id + "): ";
		switch (weather) {
			case "SUN":
				coordinates.increaseLongitude(2);
				coordinates.increaseHeight(4);
				message += "Let's enjoy the good weather and take some pics.";
				break;
			case "RAIN":
				coordinates.increaseHeight(-5);
				message += "Damn you rain! You messed up my baloon.";
				break;
			case "FOG":
				coordinates.increaseHeight(-3);
				message += "Where am I ?!";
				break;
			case "SNOW":
				coordinates.increaseHeight(-15);
				message += "It's snowing. We're gonna crash.";
				break;
		}
		System.out.println(message);
		if (coordinates.getHeight() == 0) {
			System.out.println("Baloon#" + name + "(" + id + ") landing.");
			System.out.println("Tower says: Baloon#" + name + "(" + id + ") unregistered from weather tower.");
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: Baloon#" + name + "(" + id + ") registered to weather tower.");
	}

}
