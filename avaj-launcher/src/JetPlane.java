public class JetPlane extends Aircraft {

	JetPlane(final long p_id, final String p_name, final Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String message = "JetPlane#" + name + "(" + id + "): ";
		switch (weather) {
			case "SUN":
				coordinates.increaseLatitude(10);
				coordinates.increaseHeight(2);
				message += "This is hot.";
				break;
			case "RAIN":
				coordinates.increaseLatitude(5);
				message += "It's raining. Better watch out for lightings.";
				break;
			case "FOG":
				coordinates.increaseLatitude(1);
				message += "I can't see anything.";
				break;
			case "SNOW":
				coordinates.increaseHeight(-7);
				message += "My rotor is going to freeze!";
				break;
		}
		System.out.println(message);
		if (coordinates.getHeight() == 0) {
			System.out.println("JetPlane#" + name + "(" + id + ") landing.");
			System.out.println("Tower says: JetPlane#" + name + "(" + id + ") unregistered from weather tower.");
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: JetPlane#" + name + "(" + id + ") registered to weather tower.");
	}
}
