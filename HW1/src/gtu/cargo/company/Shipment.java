package gtu.cargo.company;
/**
 * Hold a Shipment's information
 * @author Murat YILDIZ
 */
public class Shipment {
	/**
	 * It holds states of cargo
	 * @author murat
	 *
	 */
	public enum CargoState{
		ArriveAtBranch, LeaveTheBranch, Delivered ;
		
	}
	/**
	 * Holds Shipment's track ID
	 * <p> It's initial value is zero
	 */
	private int trackID;
	/**
	 * Holds Shipment's cargo state 
	 * <p> It's initial value is AtBranch
	 */
	private CargoState cargoState;
	/**
	 * Holds Shipment's receiver 
	 * <p> It's initial value is null
	 */
	private Customer receiver;
	/**
	 * Holds Shipment's sender 
	 * <p> It's initial value is null
	 */
	private Customer sender;
	/**
	 * Holds Shipment's branch 
	 * <p> It's initial value is null
	 */
	private Branch branch ;
	
	/**
     * Initialize fields of Shipment class
     * <p> Initialize {@link #trackID} as zero
     * <p> Initialize {@link #cargoState} as null
     * <p> Initialize {@link #receiver} as null
     * <p> Initialize {@link #sender} as null
     * <p> Initialize {@link #branch} as null
     */
	public Shipment() {
		
		this( 0, null, null, null, null );
	}
	
	/**
	 * Initialize fields of Shipment class with given parameters
	 * @param trackID trackID to be set as Shipment's trackID
	 * @param cargoState cargoState to be set as Shipment's cargoState
	 * @param receiver receiver to be set as Shipment's receiver
	 * @param sender sender to be set as Shipment's sender
	 * @param branch branch to be set as Shipment's branch
	 */
	public Shipment(int trackID, CargoState cargoState, Customer receiver, Customer sender, Branch branch) {
		
		this.trackID = trackID;
		this.cargoState = cargoState;
		this.receiver = receiver;
		this.sender = sender;
		this.branch = branch;
	}
	

	/**
     * Returns Shipment {@link #trackID} 
     * @return {@link #trackID} Shipment trackID
     */
	public int getTrackID() {
		return trackID;
	}
	/**
	 * Set the Shipment {@link #trackID} with given trackID
	 * @param trackID trackID will be set to Shipment {@link #trackID}
	 */
	public void setTrackID(int trackID) {
		this.trackID = trackID;
	}
	/**
     * Returns Shipment {@link #receiver} 
     * @return {@link #receiver} Shipment receiver
     */
	public Customer getReceiver() {
		return receiver;
	}
	/**
	 * Set the Shipment {@link #receiver} with given receiver
	 * @param receiver receiver will be set to Shipment {@link #receiver}
	 */
	public void setReceiver(Customer receiver) {
		this.receiver = receiver;
	}
	/**
     * Returns Shipment {@link #sender}
     * @return {@link #sender} Shipment sender 
     */
	public Customer getSender() {
		return sender;
	}
	/**
	 * Set the Shipment {@link #sender} with given sender
	 * @param sender sender will be set to Shipment {@link #sender}
	 */
	public void setSender(Customer sender) {
		this.sender = sender;
	}
	/**
     * Returns Shipment {@link #cargoState} 
     * @return {@link #cargoState} Shipment cargo state 
     */
	public CargoState getCargoState() {
		return cargoState;
	}
	/**
	 * Set the Shipment {@link #cargoState} with given cargoState
	 * @param cargoState cargo state will be set to Shipment {@link #cargoState}
	 */
	public void setCargoState(CargoState cargoState) {
		this.cargoState = cargoState;
	}
	/**
     * Returns Shipment {@link #branch} 
     * @return {@link #branch}  Shipment branch
     */
	public Branch getBranch() {
		return branch;
	}
	/**
	 * Set the Shipment {@link #branch}  with given branch
	 * @param branch branch will be set to Shipment {@link #branch} 
	 */
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	/**
     * Checks given trackID with trackID which Shipment has
     * @param trackID trackID that will be compared with Shipment trackID
     * @return If trackID is equal to Shipment trackID returns true, otherwise it returns false
     */
	public boolean checkTrackID(int trackID) {
		if( this.trackID == trackID )
			return true;
		return false ;
	}
	/**
	 * If two Shipment trackID is equal returns true, otherwise returns false.
	 * <p> It does not compare other fields
	 * @param o Other Shipment that will be compared
	 * @return If two Shipment trackID is equal returns true, otherwise returns false.
	 * It does not compare other fields
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		return this.trackID == ((Shipment) o).trackID;
	}
	
	/**
	 * Returns Shipment informations as a String
	 * @return Shipment informations as a String
	 */	
	@Override
	public String toString() {
		String str = new String();
		
		str+= "\n\n Shipment Informations\n\n";
		str+=" Receiver " + receiver + "\n\n Sender " + sender + "\n\n Current Cargo State : " + cargoState.toString() ;
		return str ;
	}
}
