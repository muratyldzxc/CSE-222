package cse222.hw6.part2;

import java.util.LinkedList;
import java.util.ListIterator;

public class QuickSortLinkedList{

	/**
	 * Sort the table using the quicksort algorithm.
	 * 
	 * @pre table contains Comparable objects.
	 * @post table is sorted.
	 * @param table The array to be sorted
	 */
	public static <T extends Comparable<T>> void sort(LinkedList<T> table) {
		// Sort the whole table.
		quickSort(table, 0, table.size() - 1);
	}

	/**
	 * Sort a part of the table using the quicksort algorithm.
	 * 
	 * @post The part of table from first through last is sorted.
	 * @param table The array to be sorted
	 * @param first The index of the low bound
	 * @param last  The index of the high bound
	 */
	private static <T extends Comparable<T>> void quickSort(LinkedList<T> table, int first, int last) {
		if (first < last) { // There is data to be sorted.
			// Partition the table.
			int pivIndex = partition(table, first, last);
			// Sort the left half.
			quickSort(table, first, pivIndex - 1);
			// Sort the right half.
			quickSort(table, pivIndex + 1, last);
		}
	}
	

	/**
	 * Partition the table so that values from first to pivIndex are less than or
	 * equal to the pivot value, and values from pivIndex to last are greater than
	 * the pivot value.
	 * 
	 * @param table The table to be partitioned
	 * @param first The index of the low bound
	 * @param last  The index of the high bound
	 * @return The location of the pivot value
	 */
	private static <T extends Comparable<T>> int partition(LinkedList<T> table, int first, int last) {
		// Select the first item as the pivot value.
		ListIterator<T> iterFirst = table.listIterator(first);
		ListIterator<T> iterLast = table.listIterator(last);
		
		iterLast.next();
	
		T pivot = iterFirst.next();
		T tempUp = pivot;
		T tempDown = iterLast.previous();
	
		int up = first;
		int down = last;
		do {
			/*
			 * Invariant: All items in table[first . . . up - 1] <= pivot All items in
			 * table[down + 1 . . . last] > pivot
			 */
			while ((up < last) && (pivot.compareTo(tempUp)) >= 0) {
				up++;
				tempUp = iterFirst.next();
			}
			// assert: up equals last or table[up] > pivot.
			while (pivot.compareTo(tempDown) < 0) {
				down--;
				tempDown = iterLast.previous();
			}
			// assert: down equals first or table[down] <= pivot.
			if (up < down) { // if up is to the left of down.
				// Exchange table[up] and table[down].
				//swap(table, up, down);
				
				iterFirst.set(tempDown);
				iterLast.set(tempUp);
			
				T temp = tempUp;
				tempUp = tempDown;
				tempDown = temp;
				
			}

		} while (up < down); // Repeat while up is left of down.
		// Exchange table[first] and table[down] thus putting the
		// pivot value where it belongs.
		
		table.set(first, tempDown);
		iterLast.set(pivot);
	
		// Return the index of the pivot value.
		return down;
	}

}
