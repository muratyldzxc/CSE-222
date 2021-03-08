package cse222.hw5.part4;

import java.util.Comparator;

/**
 * To compare two AgeData object according to numberOfPeople that age has
 */
public class AgeDataComparator implements Comparator<AgeData>{
	
	/**
	 * Create a AgeDataComparator
	 */
	public AgeDataComparator() {
		
	}

	/**
	 * Compare two AgeData object according to numberOfPeople that age has
	 * @param o1 will be compared
	 * @param o2 will be compared
	 * @return if they are equal returns 0, if o1 greater returns 1, otherwise returns -1
	 * @throws NullPointerException if one of the parameter is null
	 */
	@Override
	public int compare(AgeData o1, AgeData o2) {
		if (o1 == null || o2 == null)
			throw new NullPointerException();
		if(o1.numberOfPeople == o2.numberOfPeople)
			return 0;
		else if(o1.numberOfPeople > o2.numberOfPeople )
			return 1;
		else
			return -1;
	}
}
