public class WeatherProvider {

	private static WeatherProvider instance = null;
	private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {
	}

	public static WeatherProvider getInstance() {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int weatherIndex = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
		return weather[weatherIndex];
	}

}
