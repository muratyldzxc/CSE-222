package cse22.hw5.part3;

/**
 * Holds an age and how many people at that age
 */
public class AgeData implements Comparable<AgeData>{
	/**
	 * Hold age
	 */
	protected int age;
	/**
	 * Hold how many people at that age
	 */
	protected int numberOfPeople;

	/**
	 * Create an AgeData with given age
	 * @param age will be set
	 */
	public AgeData(int age) {
		this.age = age;
		this.numberOfPeople = 1;
	}

	/**
	 * Compare two objects according to age
	 * @param o will be compared
	 * @return if they are equal returns 0 , if given object is greater returns -1,if given object is less returns 1
	 * @throws NullPointerException if parameter is null
	 */
	public int compareTo(AgeData o) {
		if (o == null)
			throw new NullPointerException();

		if( this.age == o.age)
			return 0;
		else if(this.age > o.age)
			return 1;
		else
			return -1;
	}

	/**
	 * Returns AgeData as a string
	 * @return AgeData as a string
	 */
	@Override
	public String toString() {
		return  age + " - " + numberOfPeople ;
	}
}
