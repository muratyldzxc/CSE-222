package cse222.hw5.part4;

import java.util.ArrayList;

/**
 * A heap structure that holds max as root
 */
public class MaxHeap {
	/**
	 * Hold data in heap
	 */
	ArrayList<AgeData> table;

	/**
	 * Create a MaxHeap
	 */
	public MaxHeap() {
		this.table = new ArrayList<AgeData>();
	}

	/**
	 * Remove given item from heap (if it exist)
	 * @param item will be removed
	 * @return if item exist in heap and removed successfully return true, otherwise return false
	 * @throws NullPointerException if parameter is null
	 */
	public boolean remove(AgeData item) {
		if (item == null)
			throw new NullPointerException();

		int parent, leftChild, rightChild, maxChild, removedIndex;
		AgeDataComparator ageDataComparator = new AgeDataComparator();

		removedIndex = parent = table.indexOf(item);
		leftChild = 2*parent+1;
		rightChild = 2*parent+2;
		maxChild = leftChild;

		if (parent == -1)
			return false;

		if (table.get(parent).numberOfPeople > 1){
			table.get(parent).numberOfPeople--;
		}
		else{
			table.set(parent, table.get(table.size()-1));
			table.remove(table.size()-1);
		}

		while( leftChild <= table.size() ){

			if(rightChild < table.size() && ageDataComparator.compare(table.get(leftChild), table.get(rightChild)) < 0)
				maxChild = rightChild;
			else  if (rightChild < table.size() )
				maxChild = leftChild;
			if(ageDataComparator.compare(table.get(parent), table.get(maxChild)) < 0){
				AgeData temp = table.get(parent);
				table.set(parent, table.get(maxChild));
				table.set(maxChild, temp);
				parent = maxChild;
			}
			else
				break;

			leftChild = 2*parent+1;
			rightChild = 2*parent+2;
		}

		parent = (removedIndex-1)/2;
		while  (parent >= 0 && ageDataComparator.compare(table.get(parent), table.get(removedIndex)) == -1){
			AgeData temp = table.get(parent);
			table.set(parent, table.get(removedIndex));
			table.set(removedIndex, temp);

			removedIndex = parent;
			parent = (removedIndex-1)/2;
		}

		return true;
	}

	/**
	 * Add given item
	 * @param item will be added
	 * @return if item added successfully return true, otherwise false;
	 * @throws NullPointerException if parameter is null
	 */
	public boolean add(AgeData item) {
		if (item == null)
			throw new NullPointerException();

		AgeData temp = find(item);
		AgeData tempParentData;
		AgeDataComparator ageDataComparator = new AgeDataComparator();
		int child, parent;

		if(temp != null) {
			temp.numberOfPeople++;
			child = table.indexOf(item);
			parent = (child-1)/2;
		}
		else{
			table.add(item);
			child = table.size()-1;
			parent = (child-1)/2;
		}
		while  (parent >= 0 && ageDataComparator.compare(table.get(parent), table.get(child)) == -1 ){
			tempParentData = table.get(parent);
			table.set(parent, table.get(child));
			table.set(child, tempParentData);

			child = parent;
			parent = (child-1)/2;
		}
		return true;
	}

	/**
	 * Find given AgeData object in heap and return it
	 * @param target will be searched
	 * @return Find given AgeData object in heap and return it
	 * @throws NullPointerException if parameter is null
	 */
	public AgeData find(AgeData target) {
		if(target == null)
			throw new NullPointerException();

		for(int i=0; i<table.size(); i++){
			if(target.compareTo(table.get(i)) == 0)
				return table.get(i);
		}

		return null;
	}

	/**
	 * Count younger people than given age and return it
	 * @param age will be compared
	 * @return younger people than given age
	 */
	public int youngerThan(int age) {
		AgeData temp;
		int count =0;

		for (int i=0; i<table.size(); i++){
			temp = table.get(i);
			if (temp.age < age)
				count += temp.numberOfPeople;
		}

		return count;
	}

	/**
	 * Count older people than given age and return it
	 * @param age will be compared
	 * @return younger people than given age
	 */
	public int olderThan(int age) {
		AgeData temp;
		int count =0;

		for (int i=0; i<table.size(); i++){
			temp = table.get(i);
			if (temp.age > age)
				count += temp.numberOfPeople;
		}

		return count;
	}

	/**
	 * Returns whole heap as a String
	 * @return whole heap as a String
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		for (int i=0; i<table.size(); i++){
			str.append(" " + table.get(i) + "\n");
		}

		return str.toString();
	}
}

