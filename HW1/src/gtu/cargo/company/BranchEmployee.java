package gtu.cargo.company;
/**
 * Hold a BranchEmployee's information
 * @author Murat YILDIZ
 */
public class BranchEmployee extends Employee {
	/**
	 * Holds Branch that Branch employees belongs to 
	 * <p> It's initial value is Empty
	 */
	private Branch currentBranch;
	
	/**
     * Initialize fields of BranchEmployee class
     * <p> Initialize BranchEmployee's name as null
     * <p> Initialize BranchEmployee's surname as null
     * <p> Initialize BranchEmployee's ID as null
     * <p> Initialize BranchEmployee's password as null
     * <p> Initialize BranchEmployee's currentBranch as null
     */
	public BranchEmployee() {
		this(null,null,null,null,null);
	}
	/**
	 * Initialize fields of Employee class with given parameters
	 * @param name name to be set as BranchEmployee's name
	 * @param surname surname to be set as BranchEmployee's surname
	 * @param ID ID to be set as BranchEmployee's ID
	 * @param password password to be set as BranchEmployee's password
	 * @param currentBranch currentBranch to be set as BranchEmployee {@link #currentBranch}
	 */
	public BranchEmployee(String name, String surname, String ID, String password, Branch currentBranch) {
		super(name, surname, ID, password);
		this.currentBranch = currentBranch;
	}
	
	// begin of setters and getters
	/**
     * Returns currentBranch which Branch employees belong to
     * @return currentBranch which Branch employees belong to
     */
	public Branch getCurrentBranch() {
		return currentBranch;
	}
	/**
	 * Set the BranchEmployee's {@link #currentBranch} with given currentBranch
	 * @param currentBranch currentBranch will be set to BranchEmployee's {@link #currentBranch}
	 */
	public void setCurrentBranch(Branch currentBranch) {
		this.currentBranch = currentBranch;
	}
	// end of setters and getters

	// Polymorphism
	/**
	 * It prints given toString
	 */
	public void printEmployee() {
		System.out.println( this.toString() + "\n" );
	}

	// Customer
	/**
     * Checks given ID with Customers's ID in branch which BranchEmployee belongs to
     * @param ID ID that will be compared with Customers's ID
     * @return If there is a customer with given ID returns true, otherwise it returns false
     */
	public boolean checkCustomerID(String ID) {
		return currentBranch.checkCustomerID(ID);
	}
	/**
     * Checks given trackID with Shipments's trackID in branch which BranchEmployee belongs to
     * @param trackID trackID that will be compared with Shipments's trackID
     * @return If there is a shipment with given trackID, it prints shipment information and returns true, otherwise it returns false
     */
	public boolean learnInformationAsCustomer( int trackID ) {
		
		return currentBranch.learnInformationAsCustomer(trackID);
	}
	/**
     * Checks given ID with Customers's ID in branch which BranchEmployee belongs to and delete that customer
     * @param ID ID that will be compared with Customers's ID
     * @return If there is a customer with given ID , it deletes that customer and returns true, otherwise it returns null
     */
	public boolean deleteCustomer( String ID ) {
		
		return currentBranch.deleteCustomer(ID);
	}
	/**
     * Add given customer to the end of customers ArrayList in branch which BranchEmployee belongs to
     * @param newCustomer newCustomer that will be added     
    */
	public void addCustomer( Customer newCustomer ) {
		currentBranch.addCustomer(newCustomer);
	}
		
	// Shipment
	/**
     * Checks given trackID with Shipments's trackID in branch which BranchEmployee belongs to and delete that shipment
     * @param trackID trackID that will be compared with Shipments's trackID
     * @return If there is a shipment with given trackID , it deletes that shipment and returns true, otherwise it returns null
     */
	public boolean deleteShipment( int trackID ) {
		
		return currentBranch.deleteShipment(trackID);
	}
	/**
     * Add given shipment to the end of shipments ArrayList in branch which BranchEmployee belongs to
     * @param newShipment newShipment that will be added     
    */
	public void addShipment( Shipment newShipment ) {
		currentBranch.addShipment(newShipment);
	}
	/**
	 * Update given cargo as ArriveAtBranch or LeavesTheBranch
	 * @param cargo cargo to be changed its cargo state
	 */
	public void updateShipmentAsBranchEmployee( Shipment cargo ) {
		currentBranch.updateShipmentAsBranchEmployee(cargo);
	}

	@Override
	public String toString() {
		return " Branch" +super.toString()+
				"\n currentBranch=" + currentBranch ;

	}
}
