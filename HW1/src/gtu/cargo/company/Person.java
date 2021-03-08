package gtu.cargo.company;

/**
 * Hold a Person's information
 * @author Murat YILDIZ
 */
public class Person {
	/**
	 * Holds Person name as String
	 * <p> It's initial value is Empty
	 */
	private String name;
	/**
	 * Holds Person surname as String
	 * <p> It's initial value is Empty
	 */
	private String surname;
	/**
	 * Holds Person ID as string 
	 * <p> It's initial value is Empty
	 */
	private String ID;
	
	/**
     * Initialize fields of Person class
     * <p> Initialize {@link #name} as Empty
     * <p> Initialize {@link #surname} as Empty
     * <p> Initialize {@link #ID} as Empty
     */
	public Person() {
		this("Empty","Empty", "Empty");
	}
	/**
	 * Initialize fields of Person class with given parameters
	 * @param name name to be set as Person name
	 * @param surname surname to be set as Person surname
	 * @param ID ID to be set as Person ID
	 */
	public Person(String name, String surname, String ID) {
		this.name = name;
		this.surname = surname;
		this.ID = ID;
	}
	/**
     * Returns Person name as a string
     * @return Person name as a string
     */
	public String getName() {
		return name;
	}
	/**
	 * Set the Person name with given name
	 * @param name name will be set to Person name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Returns Person surname as a string
     * @return Person surname as a string
     */
	public String getSurname() {
		return surname;
	}
	/**
	 * Set the Person surname with given surname
	 * @param surname surname will be set to Person surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
     * Returns Person ID as a string
     * @return Person ID as a string
     */
	public String getID() {
		return ID;
	}
	/**
	 * Set the Person ID with given ID
	 * @param ID ID will be set to Person ID
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	/**
     * Checks given ID with ID which Person has
     * @param ID ID that will be compared with Person ID
     * @return If ID is equal to Person ID returns true, otherwise it returns false
     */
	public boolean checkID(String ID) {
		if( this.ID.equals(ID) )
			return true;
		return false ;
	}

	/** If two objects ID is equal returns true, otherwise returns false.
	 * <p> It does not compare other fields
	 * @param o Other Person that will be compared
	 * @return If two Person ID is equal returns true, otherwise returns false.
	 * It does not compare other fields
	 */	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		return this.checkID( ((Person) o).ID ); // polymorphism
	}

	/**
	 * Returns Person informations as a String
	 * @return Person informations as a String
	 */	
	@Override
	public String toString() {
		String str = new String();
		str = "Person Information\n" 
				+ "\n Name: " + name
				+ "\n Surname: " + surname;
		return str;
	}
}
