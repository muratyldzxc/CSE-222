package gtu.cargo.company;
/**
 * Hold a Employee's information
 * @author Murat YILDIZ
 */
public abstract class Employee extends Person implements Loginable  {
	/**
	 * Holds Employee password as String
	 * <p> It's initial value is Empty
	 */
	private String password ;
	
	/**
     * Initialize fields of Employee class
     * <p> Initialize Employee's name as Empty
     * <p> Initialize Employee'ssurname as Empty
     * <p> Initialize Employee's ID as Empty
     * <p> Initialize Employee's password as Empty
     */
	public Employee() {
		this("Empty", "Empty", "Empty", "Empty");
		
	}
	/**
	 * Initialize fields of Employee class with given parameters
	 * @param name name to be set as Employee name
	 * @param surname surname to be set as Employee surname
	 * @param ID ID to be set as Employee ID
	 * @param password password to be set as Employee password
	 */
	public Employee(String name, String surname, String ID, String password) {
		super(name, surname, ID);
		this.password = password;
	}
	
	/**
     * Returns Employee {@link #password} as a string
     * @return {@link #password} Employee password as a string
     */
	public String getPassword() {
		return password;
	}
	/**
	 * Set the Employee {@link #password} with given password
	 * @param password password will be set to Employee {@link #password}
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
     * Checks given password with {@link #password} which Employee has
     * @param password password that will be compared with Employee's {@link #password}
     * @return If password is equal to Employee's {@link #password} returns true, otherwise it returns false
     */
	public boolean checkPassword(String password) {
		if( this.password.equals(password) )
			return true;
		return false ;
	}
	
	/**
     * Checks given ID with {@link #password} which Employee has
     * @param ID ID that will be compared with Employee's ID
     * @param password password that will be compared with Employee's password
     * @return If ID and password is equal to Employee's ID and password returns true, otherwise it returns false
     */
	public boolean checkEmployee( String ID, String password ) {
		if( this.checkID(ID)  && this.checkPassword(password))
			return true;
		return false ;
	}
	// Polymorphism
	/**
	 * It prints given toString
	 */
	public abstract void printEmployee();
	/** If two Employee's ID is equal returns true, otherwise returns false.
	 * <p> It does not compare other fields
	 * @param o Other Employee that will be compared
	 * @return If two Employee's ID is equal returns true, otherwise returns false.
	 */	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		return super.equals(o);
	}
	
	/**
	 * Returns Employee informations as a String
	 * @return Employee informations as a String
	 */	
	public String toString() {
		String str = new String();
		str = "Employee Information\n"
				+ "\n Name: " + super.getName()
				+ "\n Surname: " + super.getSurname()
				+ "\n ID: " + super.getID();
		return str;
	}
}
