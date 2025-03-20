public abstract class Flyable {

	protected WeatherTower weatherTower;

	private boolean toUnregister = false;

	public abstract void updateConditions();

	public void registerTower(final WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}

	public WeatherTower getWeatherTower() {
		return weatherTower;
	}

	private void setToUnregister() {
		toUnregister = true;
	}

	public boolean getToUnregister() {
		return toUnregister;
	}
}
