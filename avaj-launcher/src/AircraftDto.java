public class AircraftDto {

	AircraftDto(AircraftType type, String name, Coordinates coordinates) {
		this.type = type;
		this.name = name;
		this.coordinates = coordinates;
	}

	AircraftType type;
	String name;
	Coordinates coordinates;
}
