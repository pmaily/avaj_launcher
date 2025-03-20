public class Helicopter extends Aircraft {


	protected Helicopter(final long p_id, final String p_name, final Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String message = "Helicopter#" + name + "(" + id + "): ";
		switch (weather) {
			case "SUN":
				coordinates.increaseLongitude(2);
				coordinates.increaseHeight(4);
				message += "The weather is nice.";
				break;
			case "RAIN":
				coordinates.increaseHeight(-5);
				message += "It's raining cats and dogs.";
				break;
			case "FOG":
				coordinates.increaseHeight(-3);
				message += "I am lost in the fog!";
				break;
			case "SNOW":
				coordinates.increaseHeight(-15);
				message += "OMG! Winter is coming!";
				break;
		}
		System.out.println(message);
		if (coordinates.getHeight() == 0) {
			System.out.println("Helicopter#" + name + "(" + id + ") landing.");
			System.out.println("Tower says: Helicopter#" + name + "(" + id + ") unregistered from weather tower.");
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: Helicopter#" + name + "(" + id + ") registered to weather tower.");
	}

}

