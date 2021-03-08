package gtu.cargo.company;
/**
 * Hold a Customer's information
 * @author Murat YILDIZ
 */
public class Customer extends Person {
	
	/**
     * Initialize fields of Customer class
     * <p> Initialize Customer's name as Empty
     * <p> Initialize Customer's surname as Empty
     * <p> Initialize Customer's ID as Empty
     */
	public Customer() {
		this("Empty", "Empty", "Empty");	
	}
	/**
	 * Initialize fields of Customer class with given parameters
	 * @param name name to be set as Person name
	 * @param surname surname to be set as Person surname
	 * @param ID ID to be set as Person ID
	 */
	public Customer(String name, String surname, String ID) {
		super(name, surname, ID);
	}
	/**
	 * If two objects ID is equal returns true, otherwise returns false.
	 * <p> It does not compare other fields
	 * @return If two Customer ID is equal returns true, otherwise returns false.
	 * It does not compare other fields
	 */
	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
	/**
	 * Returns Customer informations as a String
	 * @return Customer informations as a String
	 */	
	@Override
	public String toString() {
		
		return "\n Customer " + super.toString();
	}
}
