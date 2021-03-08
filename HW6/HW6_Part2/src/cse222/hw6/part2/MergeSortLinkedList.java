package cse222.hw6.part2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MergeSortLinkedList {
	/**
	 * Sort the array using the merge sort algorithm. pre: table contains Comparable
	 * objects. post: table is sorted.
	 * 
	 * @param table The array to be sorted
	 */
	public static <T extends Comparable<T>> void sort(LinkedList<T> table) {
		// A table with one element is sorted already.
		if (table.size() > 1) {
			// Split table into halves.
			int halfSize = table.size() / 2;
			int i = 0;
			
			LinkedList<T> leftTable = new LinkedList<T>();
			LinkedList<T> rightTable = new LinkedList<T>() ;
			Iterator<T> iter = table.iterator();
			
			while(i < halfSize) {
				leftTable.add(iter.next());
				i++;
			}
			
			while(halfSize < table.size()) {
				rightTable.add(iter.next());
				halfSize++;
			}
			
			// Sort the halves.
			sort(leftTable);
			sort(rightTable);
			
			// Merge the halves.
			merge(table, leftTable, rightTable);
		}
	}
	

	/**
	 * Merge two sequences.
	 * 
	 * @pre leftSequence and rightSequence are sorted.
	 * @post outputSequence is the merged result and is sorted.
	 * @param outputSequence The destination
	 * @param leftSequence   The left input
	 * @param rightSequence  The right input
	 */
	private static <T extends Comparable<T>> void merge(LinkedList<T> outputSequence, LinkedList<T> leftSequence, LinkedList<T> rightSequence) {
		
		Iterator<T> leftIter = leftSequence.iterator();
		Iterator<T> rightIter = rightSequence.iterator();
		ListIterator<T> outputIter = outputSequence.listIterator();
		
		T tempLeft = leftIter.next();
		T tempRight = rightIter.next();
		
		// Index into the output sequence.
		// While there is data in both input sequences
		while (tempLeft != null && tempRight != null) {
			// Find the smaller and
			// insert it into the output sequence.
			
			if (tempLeft.compareTo(tempRight) < 0) {
				outputIter.next();
				outputIter.set(tempLeft);
				
				if(!leftIter.hasNext())
					tempLeft = null;
				else
					tempLeft = leftIter.next();
				
			} else {
				outputIter.next();
				outputIter.set(tempRight);
				
				if(!rightIter.hasNext())
					tempRight = null;
				else
					tempRight = rightIter.next();
				
			}
		}
		// assert: one of the sequences has more items to copy.
		// Copy remaining input from left sequence into the output.
		while (tempLeft != null) {
			
			outputIter.next();
			outputIter.set(tempLeft);
			
			if(!leftIter.hasNext())
				tempLeft = null;
			else
				tempLeft = leftIter.next();
			
		}
		// Copy remaining input from right sequence into output.
		while (tempRight != null) {
			outputIter.next();
			outputIter.set(tempRight);
			
			if(!rightIter.hasNext())
				tempRight = null;
			else
				tempRight = rightIter.next();
		}
		
		
		
	}
}
