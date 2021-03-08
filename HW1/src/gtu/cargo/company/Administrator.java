package gtu.cargo.company;

import java.util.ArrayList;
/**
 * Hold a Administrator's information and can operate on
 * @author Murat YILDIZ
 */
public class Administrator extends Employee {
	/**
	 * Holds transportationPersonnel that admin added
	 * <p> It's initial value is null
	 */
	private ArrayList<TransportationPersonnel> transportationPersonnel;
	/**
	 * Holds branchEmployees that admin added
	 * <p> It's initial value is null
	 */
	private ArrayList<BranchEmployee> branchEmployees;
	/**
	 * Holds branchs that admin added
	 * <p> It's initial value is null
	 */
	private ArrayList<Branch> branchs;
	
	/**
     * Initialize fields of Administrator class
     * <p> Initialize Administrator's name as Empty
     * <p> Initialize Administrator'ssurname as Empty
     * <p> Initialize Administrator's ID as Empty
     * <p> Initialize Administrator's password as Empty
     */
	public Administrator(){
		this("Empty", "Empty", "Empty", "Empty");
	}
	/**
	 * Initialize fields of Administrator class with given parameters
	 * @param name name to be set as Administrator's name
	 * @param surname surname to be set as Administrator's surname
	 * @param ID ID to be set as Administrator's ID
	 * @param password password to be set as Administrator's password
	 * <p> Create object for transportationPersonnel, branchEmployees, branchs field of Administrator  
	 */
	public Administrator(String name, String surname, String ID, String password) {
		super(name, surname, ID, password);
		this.transportationPersonnel = new ArrayList<TransportationPersonnel>();
		this.branchEmployees = new ArrayList<BranchEmployee>();
		this.branchs = new ArrayList<Branch>();
	}
	/**
	 * Initialize fields of Administrator class with given parameters
	 * @param transportationPersonnel will be set as Administrator's transportationPersonnel
	 * @param branchEmployees will be set as Administrator's branchEmployees
	 * @param branchs will be set as Administrator's branchs
	 * <p> Fill empty name, surname, ID, password fields of Administrator
	 */
	public Administrator(ArrayList<TransportationPersonnel> transportationPersonnel,
						 ArrayList<BranchEmployee> branchEmployees, ArrayList<Branch> branchs) {
		this("Empty", "Empty", "Empty", "Empty");
		this.transportationPersonnel = transportationPersonnel;
		this.branchEmployees = branchEmployees;
		this.branchs = branchs;
	}
	
	// begin of setters and getters
	/**
     * Returns transportationPersonnel which Administrator has
     * @return transportationPersonnel which Administrator has
     */
	public ArrayList<TransportationPersonnel> getTransportationPersonnel() {
		return transportationPersonnel;
	}
	/**
     * Returns branchEmployees which Administrator has
     * @return branchEmployees which Administrator has
     */
	public ArrayList<BranchEmployee> getBranchEmployees() {
		return branchEmployees;
	}
	/**
     * Returns branchs which Administrator has
     * @return branchs which Administrator has
     */
	public ArrayList<Branch> getBranchs() {
		return branchs;
	}
	/**
	 * Set the Administrator's {@link #transportationPersonnel} with given transportationPersonnel
	 * @param transportationPersonnel transportationPersonnel will be set to Administrator's {@link #transportationPersonnel}
	 */
	public void setTransportationPersonnel(ArrayList<TransportationPersonnel> transportationPersonnel) {
		this.transportationPersonnel = transportationPersonnel;
	}
	/**
	 * Set the Administrator's {@link #branchEmployees} with given branchEmployees
	 * @param branchEmployees branchEmployees will be set to Administrator's {@link #branchEmployees}
	 */
	public void setBranchEmployees(ArrayList<BranchEmployee> branchEmployees) {
		this.branchEmployees = branchEmployees;
	}
	/**
	 * Set the Administrator's {@link #branchs} with given branchs
	 * @param branchs branchs will be set to Administrator's {@link #branchs}
	 */
	public void setBranchs(ArrayList<Branch> branchs) {
		this.branchs = branchs;
	}
	// end of setters and getters

	// Polymorphism
	/**
	 * It prints given toString
	 */
	public void printEmployee() {
		System.out.println( this.toString() + "\n" );
	}

	// Branch
	/**
	 * Add a branch to Administrator's {@link #branchs}
	 * @param newBranch will be added to Administrator's {@link #branchs}
	 * @return if added successfully return true, otherwise return false
	 */
	public boolean addBranch(Branch newBranch) {
		return branchs.add(newBranch);
	}
	/**
	 * Remove given branch from Administrator's {@link #branchs}
	 * @param tempBranch will be removed from Administrator's {@link #branchs}
	 * @return if removed successfully return true, otherwise return false
	 */
	public boolean deleteBranch( Branch tempBranch ) { // can be try catch
		return branchs.remove(tempBranch);
	}
	/**
	 * Remove branch with given ID from Administrator's {@link #branchs}
	 * @param ID Branch ID that will be removed from Administrator's {@link #branchs}
	 * @return if removed successfully return true, otherwise return false
	 */
	public boolean deleteBranch( String ID ) {
		Branch tempBranch = new Branch();
		tempBranch.setID(ID);
		return this.deleteBranch(tempBranch);
	}
	/**
	 * Check branch with given ID is exist in Administrator's {@link #branchs}
	 * @param ID Branch ID that will be checked in Administrator's {@link #branchs}
	 * @return if it is exist returns true, otherwise return false
	 */
	public boolean checkBranchID(String ID) {
		Branch tempBranch = new Branch();
		tempBranch.setID(ID);
		return branchs.contains(tempBranch);
	}
	/**
	 * Return branch with given ID from Administrator's {@link #branchs}
	 * @param ID Branch ID that will be returned from Administrator's {@link #branchs}
	 * @return if it is not exist returns null, otherwise return that branch
	 */
	public Branch getBranch( String ID ) {
		Branch tempBranch = new Branch();
		tempBranch.setID(ID);
		int index = branchs.indexOf(tempBranch);
		if( index != -1 )
			return branchs.get(index);

		return null;
	}

 	// Branch Employee
	/**
	 * Add a BranchEmployee to Administrator's {@link #branchEmployees}
	 * @param newBranchEmployee will be added to Administrator's {@link #branchEmployees}
	 * @return if added successfully return true, otherwise return false
	 */
	public boolean addBranchEmployee(BranchEmployee newBranchEmployee) {
		return branchEmployees.add(newBranchEmployee);
	}
	/**
	 * Remove given BranchEmployee from Administrator's {@link #branchEmployees}
	 * @param tempBranchEmployee will be removed from Administrator's {@link #branchEmployees}
	 * @return if removed successfully return true, otherwise return false
	 */
	public boolean deleteBranchEmployee( BranchEmployee tempBranchEmployee ) {
		return branchEmployees.remove(tempBranchEmployee);
	}
	/**
	 * Remove branch with given ID from Administrator's {@link #branchEmployees}
	 * @param ID BranchEmployee ID that will be removed from Administrator's {@link #branchEmployees}
	 * @return if removed successfully return true, otherwise return false
	 */
	public boolean deleteBranchEmployee( String ID ) {
		BranchEmployee tempBranchEmployee = new BranchEmployee();
		tempBranchEmployee.setID(ID);
		return this.deleteBranchEmployee(tempBranchEmployee);
	}
	/**
	 * Check branch with given ID is exist in Administrator's {@link #branchEmployees}
	 * @param ID BranchEmployee ID that will be checked in Administrator's {@link #branchEmployees}
	 * @return if it is exist returns true, otherwise return false
	 */
	public boolean checkBranchEmployeeID(String ID) {
		BranchEmployee tempBranchEmployee = new BranchEmployee();
		tempBranchEmployee.setID(ID);
		return branchEmployees.contains(tempBranchEmployee);
	}
	/**
	 * Return BranchEmployee with given ID from Administrator's {@link #branchEmployees}
	 * @param ID BranchEmployee ID that will be returned from Administrator's {@link #branchEmployees}
	 * @param password BranchEmployee password that will be returned from Administrator's {@link #branchEmployees}
	 * @return if it is not exist returns null, otherwise return that BranchEmployee
	 */
	public BranchEmployee getBranchEmployee( String ID, String password ) {
		BranchEmployee tempBranchEmployee = new BranchEmployee();
		tempBranchEmployee.setID(ID);
		int index = branchEmployees.indexOf(tempBranchEmployee);
		if( index != -1 )
			return branchEmployees.get(index);

		return null;
	}

	// Transportation Personel
	
	/**
	 * Add a TransportationPersonel to Administrator's {@link #transportationPersonnel}
	 * @param newTransportationPersonel will be added to Administrator's {@link #transportationPersonnel}
	 * @return if added successfully return true, otherwise return false
	 */
	public boolean addTransportationPersonel(TransportationPersonnel newTransportationPersonel) {
		return transportationPersonnel.add(newTransportationPersonel);
	}
	/**
	 * Remove given TransportationPersonnel from Administrator's {@link #transportationPersonnel}
	 * @param newTransportationPersonel will be removed from Administrator's {@link #transportationPersonnel}
	 * @return if removed successfully return true, otherwise return false
	 */
	public boolean deleteTransportationPersonel( TransportationPersonnel newTransportationPersonel ) {
		return transportationPersonnel.remove(newTransportationPersonel);
	}
	/**
	 * Remove TransportationPersonel with given ID from Administrator's {@link #transportationPersonnel}
	 * @param ID TransportationPersonel ID that will be removed from Administrator's {@link #transportationPersonnel}
	 * @return if removed successfully return true, otherwise return false
	 */
	public boolean deleteTransportationPersonel( String ID ) {
		TransportationPersonnel tempTransportationPersonnel = new TransportationPersonnel();
		tempTransportationPersonnel.setID(ID);
		return this.deleteTransportationPersonel(tempTransportationPersonnel);
	}
	/**
	 * Check TransportationPersonel with given ID is exist in Administrator's {@link #transportationPersonnel}
	 * @param ID TransportationPersonel ID that will be checked in Administrator's {@link #transportationPersonnel}
	 * @return if it is exist returns true, otherwise return false
	 */
	public boolean checkTransportationPersonelID(String ID) {
		TransportationPersonnel tempTransportationPersonel = new TransportationPersonnel();
		tempTransportationPersonel.setID(ID);
		return transportationPersonnel.contains(tempTransportationPersonel);
	}
	/**
	 * ReturnTransportationPersonnel with given ID from Administrator's {@link #transportationPersonnel}
	 * @param ID TransportationPersonnel ID that will be returned from Administrator's {@link #transportationPersonnel}
	 * @param password TransportationPersonnel password that will be returned from Administrator's {@link #transportationPersonnel}
	 * @return if it is not exist returns null, otherwise return that TransportationPersonnel
	 */
	public TransportationPersonnel getTransportationPersonnel( String ID, String password ) {
		TransportationPersonnel tempTransportationPersonel = new TransportationPersonnel();
		tempTransportationPersonel.setID(ID);
		int index = transportationPersonnel.indexOf(tempTransportationPersonel);
		if( index != -1 )
			return transportationPersonnel.get(index);

		return null;
	}

	/**
	 * Update given Shipment's cargoState
	 * @param cargo will be updated Shipment's cargoState
	 * @return if updated successfully returns true, otherwise returns false
	 */
	public boolean updateCargoAsTransportationPersonnel( Shipment cargo ) {
		return ( transportationPersonnel.get(0) ).setAsDelivered(cargo);
	}


	// Shipment
	/**
	 * Return Shipment with given ID from under this Administrator 
	 * @param trackID Shipment ID that will be returned from under this Administrator
	 * @return if it is not exist returns null, otherwise return that Shipment
	 */
	public Shipment getShipment( int trackID ) {
		for(int i=0; i<branchs.size(); i++)
			if( (branchs.get(i)).getShipment(trackID) != null )
				return (branchs.get(i)).getShipment(trackID);
		return null;
	}

	// Customer
	/**
     * Checks given trackID with Shipments's trackID in that Administrator has
     * @param trackID trackID that will be compared with Shipments's trackID
     * @return If there is a shipment with given trackID, it prints shipment information and returns true, otherwise it returns false
     */
	public boolean learnInformationAsCustomer( int trackID ) {
		for(int i=0; i<branchEmployees.size(); i++)
			if( (branchEmployees.get(i)).learnInformationAsCustomer(trackID) )
				return true ;
		return false;
	}
	/**
     * Checks given ID with Customers's ID in that Administrator has
     * @param ID ID that will be compared with Customers's ID
     * @return If there is a customer with given ID returns true, otherwise it returns false
     */
	public boolean checkCustomerID(String ID) {
		for(int i=0; i<branchs.size(); i++)
			if( (branchs.get(i)).checkCustomerID(ID) == true )
				return true ;
		return false ;
	}
	/**
	 * Return Customer with given ID from under this Administrator 
	 * @param ID Customer ID that will be returned from under this Administrator 
	 * @return if it is not exist returns null, otherwise return that Customer
	 */
	public Customer getCustomer( String ID ) {
		for(int i=0; i<branchs.size(); i++)
			if( (branchs.get(i)).getCustomer(ID) != null )
				return (branchs.get(i)).getCustomer(ID);
		return null;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		return this.checkEmployee( ((Employee)o).getID(), ((Employee)o).getPassword());
	}
	
}