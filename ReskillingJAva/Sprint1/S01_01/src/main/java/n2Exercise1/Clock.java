package n2Exercise1;

public interface Clock {
	default void alarm () {
		System.out.println("Alarm sounds.");
	}
}
