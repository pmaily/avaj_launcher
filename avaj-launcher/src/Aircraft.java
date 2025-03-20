public class Aircraft extends Flyable{
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(final long p_id, final String p_name, final Coordinates p_coordinates) {
		name = p_name;
		coordinates = p_coordinates;
		id = p_id;
	}

	@Override
	public void updateConditions() {
	}

	public long getId() {
		return id;
	}

	public void setId(final long newId) {
		id = newId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String newName) {
		name = newName;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(final Coordinates newCoordinates) {
		coordinates = newCoordinates;
	}
}
