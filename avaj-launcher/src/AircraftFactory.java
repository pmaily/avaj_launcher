public final class AircraftFactory {

	private long idCounter = 0;

	private static AircraftFactory instance = null;

	private AircraftFactory() {
	}

	public static AircraftFactory getInstance() {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		return instance;
	}

	public Flyable newAircraft(String type, String name, Coordinates coordinates) {
		switch (type) {
			case "Baloon":
				return new Baloon(idCounter++, name, coordinates);
			case "JetPlane":
				return new JetPlane(idCounter++, name, coordinates);
			case "Helicopter":
				return new Helicopter(idCounter++, name, coordinates);
		}
		return null;
	}
}
