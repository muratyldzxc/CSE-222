package gtu.cargo.company;

import java.util.ArrayList;

import gtu.cargo.company.Shipment.CargoState;
/**
 * Hold a Branch's information
 * @author Murat YILDIZ
 */
public class Branch {
	/**
	 * Holds Branch name as String
	 * <p> It's initial value is Empty
	 */
	private String name;
	/**
	 * Holds Branch ID as string 
	 * <p> It's initial value is Empty
	 */
	private String ID;
	/**
	 * Hold Shipments in that branch
	 * <p> It's initial value is null
	 */
	private ArrayList<Shipment> shipments;
	/**
	 * Hold Customers in that branch
	 * <p> It's initial value is null
	 */
	private ArrayList<Customer> customers;
	
	/**
     * Initialize fields of Branch class
     * <p> Initialize {@link #name} as Empty
     * <p> Initialize {@link #ID} as Empty
     * <p> Initialize {@link #shipments} as null
     * <p> Initialize {@link #customers} as null
     */
	public Branch(){
		this("Empty","Empty", null, null);
		shipments = new ArrayList<Shipment>();
		customers = new ArrayList<Customer>();
	}
	/**
     * Initialize fields of Branch class with given parameters
     * @param name name to be set as Branch name
	 * @param ID ID to be set as Branch ID
     */
	public Branch(String name, String ID) {
		this.name = name;
		this.ID = ID;
		shipments = new ArrayList<Shipment>();
		customers = new ArrayList<Customer>();
	}
	/**
     * Initialize fields of Branch class with given parameters
     * @param name name to be set as Branch name
	 * @param ID ID to be set as Branch ID
	 * @param shipments shipments to be set as Branch shipments
	 * @param customers customers to be set as Branch customers
     */
	public Branch(String name, String ID, ArrayList<Shipment> shipments, ArrayList<Customer> customers ) {
		this.name = name;
		this.ID = ID;
		this.shipments = shipments;
		this.customers = customers;
	}

	/**
     * Returns Branch name as a string
     * @return Branch name as a string
     */
	public String getName() {
		return name;
	}
	/**
	 * Set the Branch name with given name
	 * @param name name will be set to Branch name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Returns Branch ID as a string
     * @return Branch ID as a string
     */
	public String getID() {
		return ID;
	}
	/**
	 * Set the Branch ID with given ID
	 * @param ID ID will be set to Branch ID
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	/**
	 * Returns Branch's shipments 
     * @return Branch's shipments 
	 */
	public ArrayList<Shipment> getShipments() {
		return shipments;
	}
	/**
	 * Set the Branch's shipments with given shipments
	 * @param shipments shipments will be set to Branch's shipments
	 */
	public void setShipments(ArrayList<Shipment> shipments) {
		this.shipments = shipments;
	}
	/**
	 * Returns Branch's customers 
     * @return Branch's customers 
	 */
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	/**
	 * Set the Branch's customers  with given shipments
	 * @param customers customers  will be set to Branch's customers 
	 */
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	// Customer
	/**
     * Checks given ID with Customers's ID in that branch
     * @param ID ID that will be compared with Customers's ID
     * @return If there is a customer with given ID returns true, otherwise it returns false
     */
	public boolean checkCustomerID(String ID) {
		Customer tempCustomer = new Customer();
		tempCustomer.setID(ID);
		if( customers.contains(tempCustomer) )
			return true ;
		return false ;
	}
	/**
     * Checks given trackID with Shipments's trackID in that branch
     * @param trackID trackID that will be compared with Shipments's trackID
     * @return If there is a shipment with given trackID, it prints shipment information and returns true, otherwise it returns false
     */
	public boolean learnInformationAsCustomer( int trackID ) {
		Shipment tempShipment = new Shipment();
		tempShipment.setTrackID(trackID);
		int index = shipments.indexOf( tempShipment );
		if( index != -1 ) {
			System.out.printf("%s", shipments.get(index).toString());
			return true;
		}
		return false;
	}
	/**
     * Checks given ID with Customers's ID in that branch and returns founded customer
     * @param ID ID that will be compared with Customers's ID
     * @return If there is a customer with given ID returns that customer, otherwise it returns null
     */
	public Customer getCustomer( String ID ) {
		Customer tempCustomer = new Customer();
		tempCustomer.setID(ID);
		int index = customers.indexOf( tempCustomer );
		if( index != -1 )
			return customers.get(index);

		return null;
	}
	/**
     * Checks given ID with Customers's ID in that branch and delete that customer
     * @param ID ID that will be compared with Customers's ID
     * @return If there is a customer with given ID , it deletes that customer and returns true, otherwise it returns null
     */
	public boolean deleteCustomer( String ID ) {
		Customer tempCustomer = new Customer();
		tempCustomer.setID(ID);
		return this.deleteCustomer(tempCustomer);
	}
	/**
     * Checks given customer with Customers in that branch and delete that customer
     * @param tempCustomer customer that will be compared with Customers's
     * @return If there is a customer as given customer , it deletes that customer and returns true, otherwise it returns null
     */
	public boolean deleteCustomer( Customer tempCustomer ) {
		return customers.remove(tempCustomer);
	}
	
	/**
     * Add given customer to the end of customers ArrayList in that branch
     * @param newCustomer newCustomer that will be added     
    */
	public void addCustomer( Customer newCustomer ) {
		customers.add(newCustomer);
	}
	
	// Shipment
	/**
     * Checks given trackID with Shipments's trackID in that branch and delete that shipment
     * @param trackID trackID that will be compared with Shipments's trackID
     * @return If there is a shipment with given trackID , it deletes that shipment and returns true, otherwise it returns null
     */
	public boolean deleteShipment( int trackID ) {
		Shipment tempShipment = new Shipment();
		tempShipment.setTrackID(trackID);
		return this.deleteShipment(tempShipment);
	}
	/**
     * Checks given shipment with Shipments in that branch and delete that shipment
     * @param tempShipment shipment that will be compared with Shipments's
     * @return If there is a shipment as given shipment , it deletes that shipment and returns true, otherwise it returns null
     */
	public boolean deleteShipment( Shipment tempShipment ) {
		return shipments.remove(tempShipment);
	}
	/**
     * Add given shipment to the end of shipments ArrayList in that branch
     * @param newShipment newShipment that will be added     
    */
	public void addShipment( Shipment newShipment ) {
		shipments.add(newShipment);
	}
	/**
     * Checks given trackID with Shipments's trackID in that branch and returns founded shipment
     * @param trackID trackID that will be compared with Shipment's trackID
     * @return If there is a shipment with given trackID returns that shipment, otherwise it returns null
     */
	public Shipment getShipment( int trackID ) {
		Shipment tempShipment = new Shipment();
		tempShipment.setTrackID(trackID);
		int index = shipments.indexOf( tempShipment );
		if( index != -1 )
			return shipments.get(index);

		return null;
	}
	
	/**
	 * Update given cargo as ArriveAtBranch or LeavesTheBranch
	 * @param cargo cargo to be changed its cargo state
	 */
	public void updateShipmentAsBranchEmployee( Shipment cargo ) {
		cargo.setCargoState(CargoState.LeaveTheBranch);
	}
	/**
	 * If two Branch ID is equal returns true, otherwise returns false.
	 * <p> It does not compare other fields
	 * @param o Other Branch that will be compared
	 * @return If two Branch ID is equal returns true, otherwise returns false.
	 * It does not compare other fields
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		return this.ID.equals(((Branch) o).ID) ;
	}
	
	/**
	 * Returns Branch informations as a String
	 * @return Branch informations as a String
	 */	
	@Override
	public String toString() {

		return "\nBranch ID : "+ ID +"\nBranch name : " + name +"\n";
	}

}
