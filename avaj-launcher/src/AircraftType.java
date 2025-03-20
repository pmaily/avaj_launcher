import static java.lang.System.exit;

public enum AircraftType {
	BALLOON("Baloon"),
	HELICOPTER("Helicopter"),
	JETPLANE("JetPlane");

	private final String name;

	AircraftType(String name) {
		this.name = name;
	}

	public static AircraftType fromName(String name) {
		for (AircraftType type : values()) {
			if (type.name.equals(name)) {
				return type;
			}
		}
		System.err.println("Unknown aircraft type: " + name);
		exit(1);
		return null;
	}

	public String getName() {
		return name;
	}
}
