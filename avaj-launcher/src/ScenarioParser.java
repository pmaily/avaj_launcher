import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class ScenarioParser {
	public static ScenarioDto parseScenario(String filePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			ScenarioDto scenario = new ScenarioDto();

			scenario.numberOfSimulations = Integer.parseInt(reader.readLine().trim());

			scenario.aircrafts = new ArrayList<>();

			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(" ");
				if (parts.length != 5) {
					System.err.println("Invalid line format: " + line);
					exit(1);
				}

				AircraftType type = AircraftType.fromName(parts[0]);
				String name = parts[1];
				int longitude = Integer.parseInt(parts[2]);
				int latitude = Integer.parseInt(parts[3]);
				int height = Integer.parseInt(parts[4]);

				Coordinates coordinates = new Coordinates(longitude, latitude, height);
				AircraftDto aircraft = new AircraftDto(type, name, coordinates);
				scenario.aircrafts.add(aircraft);
			}

			return scenario;
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + filePath);
		} catch (NumberFormatException e) {
			System.err.println("Invalid file format.");
		} catch (IOException e) {
			System.err.println("Error reading file: " + filePath);
		}
		exit(1);
		return null;
	}
}