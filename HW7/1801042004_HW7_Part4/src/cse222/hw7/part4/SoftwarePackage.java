package cse222.hw7.part4;

import java.util.Objects;

/**
 * Holds information of a Software Package
 */
public class SoftwarePackage implements Comparable<SoftwarePackage> {
	/**
	 * Holds name of the Software Package
	 */
	String name;
	/**
	 * Holds amount of the Software Package
	 */
	int quantity;
	/**
	 * Holds price of the Software Package
	 */
	double price;


	/**
	 * Create an SoftwarePackage object
	 * Initialize name = null , quantity = 0, price = 0.0
	 */
	public SoftwarePackage() {
		this(null, 0, 0.0);
	}

	/**
	 * Create an SoftwarePackage object, Initialize them with given parameters
	 * @param name will be set to name
	 * @param quantity will be set to quantity
	 * @param price will be set to price
	 */
	public SoftwarePackage(String name, int quantity, double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	/**
	 * Check given object is equal or not
	 * @param o will be checked
	 * @return true if two object's names are equal, otherwise false
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SoftwarePackage)) return false;
		SoftwarePackage that = (SoftwarePackage) o;

		return Objects.equals(name, that.name);
	}

	/**
	 * Compare given object
	 * @param o will be compared
	 * @return Compare their names and return it
	 */
	public int compareTo(SoftwarePackage o) {
		
		return this.name.compareTo(o.name);
	}

	/**
	 * Returns information of that class as a string
	 * @return information of that class as a string
	 */
	public String toString() {
		
		return "\n Software Package\n\n - name: " + name + "\n - quantity: " + quantity + " \n - price: " + price;
	}
	
}
