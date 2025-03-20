import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tower {
	private final List<Flyable> observers = new ArrayList<>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		for (final Flyable observer : observers) {
			observer.updateConditions();
		}
		observers.removeIf(Flyable::getToUnregister);
	}
}
