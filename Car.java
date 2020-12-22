package cs405;

/**
 * Each {@code Car} instance maintains information about a {@code Car}.
 * 
 * @author Quincy Asemota CSI405 Homework #2
 */
public class Car {

	/**
	 * The color red.
	 */
	public static int RED = rgb(255, 0, 0);

	/**
	 * The color green.
	 */
	public static int GREEN = rgb(0, 255, 0);

	/**
	 * The color blue.
	 */
	public static int BLUE = rgb(0, 0, 255);

	/**
	 * The plate number of this {@code Car}.
	 */
	protected String plateNumber;

	/**
	 * The exterior color of this {@code Car}.
	 */
	protected int exteriorColor;

	/**
	 * Constructs a {@code Car} instance.
	 * 
	 * @param plateNumber   the plate number of the {@code Car}.
	 * @param exteriorColor the exterior color of the {@code Car}.
	 */
	public Car(String plateNumber, int exteriorColor) {
		// This is used to assign the values for the instance variables
		this.plateNumber = plateNumber;
		this.exteriorColor = exteriorColor;
		// Problem 1
	}

	/**
	 * Sets the plate number of this {@code Car}.
	 * 
	 * @param plateNumber the new plate number of this {@code Car}.
	 */
	public void setPlateNumber(String plateNumber) {
		// This is used to assign the plateNumber
		this.plateNumber = plateNumber;
		// Problem 3
	}

	/**
	 * Returns the plate number of this {@code Car}.
	 * 
	 * @return the plate number of this {@code Car}.
	 */
	public String getPlateNumber() {
		// Problem 4
		return plateNumber;
	}

	/**
	 * Returns an {@code int} value that corresponds to the specified color.
	 * 
	 * @param r the red component.
	 * @param g the green component.
	 * @param b the blue component.
	 * @return an {@code int} value that corresponds to the specified color.
	 */
	public static int rgb(int r, int g, int b) {
		return (0xFF << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | ((b & 0xFF) << 0);
	}

	@Override
	public String toString() {
		return "(plateNumber: " + plateNumber + ",exteriorColor:" + exteriorColor + ")";
	}

	// Problem 5
	@Override
	public boolean equals(Object obj) {

		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Car)) {
			return false;
		}

		Car car = (Car) obj;

		return plateNumber.equals(car.plateNumber) && (exteriorColor == car.exteriorColor);

	}

	/**
	 * The main method.
	 * 
	 * @param args the program arguments.
	 */
	public static void main(String[] args) {
		// Problems 1 and 2
		Car red = new Car("1", Car.RED);
		System.out.println(red);

		// Problem 3
		red.setPlateNumber("2");
		System.out.println(red);

		// Problem 4
		System.out.println(red.getPlateNumber());

		// Problem 5
		System.out.println(red.equals(new Car("1", Car.RED)));
		System.out.println(red.equals(new Car("2", Car.RED)));
		System.out.println(red.equals(new Car("1", Car.GREEN)));
		System.out.println(red.equals("1"));
	}

}
