package n2exercici1;

public interface Clock {
	default void alarm () {
		System.out.println("Alarm sounds.");
	}
}
