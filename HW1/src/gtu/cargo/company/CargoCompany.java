package gtu.cargo.company;

import java.util.ArrayList;


/**
 * Hold a Cargo Company's information and can operate on
 * @author Murat YILDIZ
 */
public class CargoCompany {
	/**
	 * Holds admins that in cargo company
	 * <p> It's initial value is null
	 */
	private ArrayList<Administrator> admins;
	
	/**
     * Initialize fields of CargoCompany class
     * <p> Initialize {@link #admins} as null
     */
	public CargoCompany() {
		this(null);
		admins = new ArrayList<Administrator>();
	}
	/**
     * Initialize fields of Administrator class
     * @param admins to be set as {@link #admins}
     * <p> Initialize {@link #admins} as null
     */
	public CargoCompany(ArrayList<Administrator> admins) {
		this.admins = admins;
	}
	
	// Administrator
	/**
	 * Add a Administrator to CargoCompany's {@link #admins}
	 * @param newAdmin will be added to CargoCompany's {@link #admins}
	 * @return if added successfully return true, otherwise return false
	 */
	public boolean addAdministrator(Administrator newAdmin){
		return admins.add(newAdmin);
	}
	/**
	 * Return admins with given ID from CargoCompany's {@link #admins}
	 * @param ID Administrator ID that will be returned from CargoCompany's {@link #admins}
	 * @param password Administrator password that will be returned from CargoCompany's {@link #admins} 
	 * @return if it is not exist returns null, otherwise return that branch
	 */
	public Administrator getAdministrator( String ID, String password ) {
		Administrator tempAdmin = new Administrator();
		tempAdmin.setID(ID);
		tempAdmin.setPassword(password);
		int index = admins.indexOf(tempAdmin);
		if( index != -1 )
			return admins.get(index);

		return null;
	}
	
	// Customer
	/**
     * Checks given trackID with Shipments's trackID in that CargoCompany
     * @param trackID trackID that will be compared with Shipments's trackID
     * @return If there is a shipment with given trackID, it prints shipment information and returns true, otherwise it returns false
     */
	public boolean learnInformationAsCustomer( int trackID ) {
		for(int i=0; i<admins.size(); i++)
			if( (admins.get(i)).learnInformationAsCustomer(trackID) )
				return true ;
		return false;
	}
	/**
     * Checks given ID with Customers's ID in that CargoCompany
     * @param ID ID that will be compared with Customers's ID
     * @return If there is a customer with given ID returns true, otherwise it returns false
     */
	public boolean checkCustomerID(String ID) {
		
		for(int i=0; i<admins.size(); i++)
			if( (admins.get(i)).checkCustomerID(ID) )
				return true ;
		return false ;
	}
	/**
	 * Return Customer with given ID from under this CargoCompany
	 * @param ID Customer ID that will be returned from under this Administrator 
	 * @return if it is not exist returns null, otherwise return that Customer
	 */
	public Customer getCustomer( String ID ) {
		for(int i=0; i<admins.size(); i++)
			if( (admins.get(i)).getCustomer(ID) != null )
				return (admins.get(i)).getCustomer(ID);
		return null;
	}

	
	// TransportationPersonnel
	/**
	 * Return TransportationPersonnel with given ID from CargoCompany's transportationPersonnel
	 * @param ID TransportationPersonnel ID that will be returned from CargoCompany's transportationPersonnel
	 * @param password TransportationPersonnel password that will be returned from CargoCompany's transportationPersonnel
	 * @return if it is not exist returns null, otherwise return that TransportationPersonnel
	 */
	public TransportationPersonnel getTransportationPersonnel( String ID, String password ) {
		for(int i=0; i<admins.size(); i++)
			if( (admins.get(i)).getTransportationPersonnel(ID, password) != null )
				return (admins.get(i)).getTransportationPersonnel(ID, password) ;
		return null;
	}
	
	// Branch Employee
	/**
	 * Return BranchEmployee with given ID from CargoCompany's branchEmployees
	 * @param ID BranchEmployee ID that will be returned from CargoCompany's branchEmployees
	 * @param password BranchEmployee password that will be returned from CargoCompany's branchEmployees
	 * @return if it is not exist returns null, otherwise return that BranchEmployee
	 */
	public BranchEmployee getBranchEmployee( String ID , String password ) {
		
		for(int i=0; i<admins.size(); i++)
			if( (admins.get(i)).getBranchEmployee(ID, password) != null )
				return (admins.get(i)).getBranchEmployee(ID, password);
		return null;
	}

	// Branch
	/**
	 * Check branch with given ID is exist in CargoCompany's branchs
	 * @param ID Branch ID that will be checked in CargoCompany's branchs
	 * @return if it is exist returns true, otherwise return false
	 */
	public boolean checkBranchID( String ID ){
		for(int i=0; i<admins.size(); i++)
			if( (admins.get(i)).checkBranchID(ID) )
				return true ;
		return false ;
	}

	// Shipment
	/**
	 * Return Shipment with given ID from under this CargoCompany
	 * @param trackID Shipment ID that will be returned from under this CargoCompany
	 * @return if it is not exist returns null, otherwise return that Shipment
	 */
	public Shipment getShipment( int trackID ) {
		
		for(int i=0; i<admins.size(); i++)
			if( (admins.get(i)).getShipment(trackID) != null )
				return (admins.get(i)).getShipment(trackID);
		return null;
	}

	// Employee
	
	// Polymorphism
	/**
	 * It prints given Employee's toString
	 * @param printedEmployee will use for polymorphism to call toString 
	 */
	public void printEmployee( Employee printedEmployee ) {
		printedEmployee.printEmployee();
	}


}
