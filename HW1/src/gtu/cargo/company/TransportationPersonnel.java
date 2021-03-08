package gtu.cargo.company;

import gtu.cargo.company.Shipment.CargoState;
/**
 * Hold a TransportationPersonel's information
 * @author Murat YILDIZ
 */
public class TransportationPersonnel extends Employee {	
	
	/**
     * Initialize fields of TransportationPersonnel class
     * <p> Initialize TransportationPersonnel's name as Empty
     * <p> Initialize TransportationPersonnel's surname as Empty
     * <p> Initialize TransportationPersonnel's ID as Empty
     * <p> Initialize TransportationPersonnel's password as Empty
     */
	public TransportationPersonnel() {
		this("Empty", "Empty", "Empty", "Empty");
	}
	/**
	 * Initialize fields of TransportationPersonnel class with given parameters
	 * @param name name to be set as TransportationPersonnel name
	 * @param surname surname to be set as TransportationPersonnel surname
	 * @param ID ID to be set as Employee ID
	 * @param password password to be set as TransportationPersonnel password
	 */
	public TransportationPersonnel(String name, String surname, String ID, String password) {
		super(name, surname, ID, password);
	}	
	/**
	 * Update given Shipment's cargoState
	 * @param cargo will be updated Shipment's cargoState
	 * @return if given cargo is not null returns true, otherwise returns false
	 */
	public boolean setAsDelivered(Shipment cargo) {
		if( cargo != null)
			cargo.setCargoState(CargoState.Delivered);
		else
			return false;
		return true;
	}

	// Polymorphism
	/**
	 * It prints given toString
	*/ 
	public void printEmployee() {
		System.out.println( this.toString() + "\n" );
	}

	/** If two TransportationPersonnel's ID is equal returns true, otherwise returns false.
	 * <p> It does not compare other fields
	 * @param o Other TransportationPersonnel that will be compared
	 * @return If two TransportationPersonnel's ID is equal returns true, otherwise returns false.
	 */	
	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
	/**
	 * Returns TransportationPersonnel informations as a String
	 * @return TransportationPersonnel informations as a String
	 */	
	@Override
	public String toString() {
		
		return "Transportation " + super.toString();
	}
	
}
