package cse222.hw6.part2;
/** Implements the bubble sort algorithm. */
public class BubbleSort {
	/**
	 * Sort the array using Bubble sort algorithm.
	 * 
	 * @pre table contains Comparable objects.
	 * @post table is sorted.
	 * @param table The array to be sorted
	 */
	public static void sort(Comparable[] table) {
		boolean exchanges;
		
		do {
			exchanges = false;
			for(int i=0; i< table.length-1; i++) {
				if(table[i].compareTo(table[i+1]) == 1) {
					Comparable temp = table[i];
					table[i] = table[i+1];
					table[i+1] = temp;
					exchanges = true;
				}
			}
		}while(exchanges);
	}
}
