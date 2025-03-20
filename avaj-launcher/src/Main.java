import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.err.println("Usage: ./runnable <scenario file>");
			System.exit(1);
		}
		ScenarioDto scenario = ScenarioParser.parseScenario(args[0]);
		if (scenario == null) {
			System.exit(1);
		}

		AircraftFactory factory = AircraftFactory.getInstance();
		WeatherTower weatherTower = new WeatherTower();

		scenario.aircrafts.forEach(aircraft -> {
			Flyable flyable = factory.newAircraft(aircraft.type.getName(), aircraft.name, aircraft.coordinates);
			if (flyable == null) {
				System.exit(1);
			}
			flyable.registerTower(weatherTower);
		});

		for (int i = 0; i < scenario.numberOfSimulations; i++) {
			weatherTower.changeWeather();
		}
	}
}