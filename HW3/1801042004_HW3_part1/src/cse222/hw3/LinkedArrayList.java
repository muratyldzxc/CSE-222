package cse222.hw3;

import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;



/**
 ** Data structure which hold data 
 * @author murat
 *
 * @param <E> type of data which will be store
 */
public class LinkedArrayList<E> extends AbstractList<E> implements List<E>  {
	
	/**
     * Pointer to first node.
     */
	private Node<E> head;
	/**
     * Pointer to first node.
     */
	private Node<E> tail;
	/**
     * Size of how many Node in list.
     */
	private int nodeSize = 0;
	/**
     * Size of how many element in list.
     */
	private int totalSize = 0;

	/**
	 * Returns how many nodes in there
	 * @return how many nodes in there
	 */
	public int getNodeSize() {
		return nodeSize;
	}

	/**
	 * Returns the number of elements in this list.
	 * @return the number of elements in this list.
	 */
	public int getTotalSize() {
		return totalSize;
	}

	/**
	 * Create an empty LinkedArraylist
	 * <p> Assign head and tail to null
	 */
	public LinkedArrayList(){
		head = null;
		tail = null;
	}

	/**
	 * Class to represent a node in the list. May hold INITIAL_CAPACITY times elements.
	*/
	private static class Node<E> {
		/**
		 * Holds data in array
		 */
        private E[] data ;
		/**
		 * Size of array
		 */
		private int size = 0;
		/**
		 * Holds next node
		 */
        private Node<E> next;
		/**
		 * Holds previous node
		 */
        private Node<E> prev;
		/**
		 * MAX initial capacity of array
		 */
		public static final int INITIAL_CAPACITY = 4;

		/**
		 * Create a Node and an array with INITIAL_CAPACITY which type is E
		 * <p> assign next to next , prev to prev , data[0] to element and increment size
		 * @param prev that will assign to be prev
		 * @param element that will assign to be data[0]
		 * @param next that will assign to be next
		 */
        @SuppressWarnings("unchecked")
		Node(Node<E> prev, E element, Node<E> next) {
        	data = (E[]) new Object [INITIAL_CAPACITY];
            this.data[0] = element;
            this.next = next;
            this.prev = prev;
            size++;
        }

    }
	/**
	 * Iterator class of LinkedArrayList
	 * @author murat
	 *
	 */
   	private class LinkedArrayListItr implements ListIterator<E>{
	   
			/** 
		 * Node that will be returned by next(). 
		 */
		private Node<E> next;
		
		/** 
		 * Node that will be affected by remove() or set(). 
		 */
		private Node<E> lastReturned;
		
		/**
		 * Index of lastReturned element in array
		 */
		private int lastPositionInArray;
		   
		/** 
		 * Index of `next'. 
		 */
		private int position;
		
		/**
		 * Index in array data
		 */
		private int positionInArray;

		/**
		 * Index of next element that will returned by next() function
		 */
		private int nextIndex;

		/**
		 * Create an LinkedArrayListItr with given index
		 * @param index the position, between 0 and size() inclusive, to begin the iteration from
		 * @throws IndexOutOfBoundsException if index
		 */
		public LinkedArrayListItr(int index) {
			if( index < 0 || index > totalSize )
				throw new IndexOutOfBoundsException("Index is not valid");

			position = 0;
			nextIndex = index;
			Node<E> temp = head;

			temp = head;
			while( temp != null && (index > temp.size || index == Node.INITIAL_CAPACITY)  ) {
			   index -= temp.size;
			   temp = temp.next;
				position++;
			}
			positionInArray = index - 1;
			next = temp;
		}

		/**
		 * Returns true if this list iterator has more elements when traversing the list in the forward direction. (In other words, returns true if next() would return an element rather than throwing an exception.)
		 * @return true if the list iterator has more elements when traversing the list in the forward direction
		 */
		@Override
		public boolean hasNext() {	
			if( positionInArray < next.size - 1 )
				return true;
			if( position < nodeSize - 1 )
				return true;
			return false;
		}

		/**
		 * Returns the next element in the list and advances the cursor position. This method may be called repeatedly to iterate through the list, or intermixed with calls to previous() to go back and forth. (Note that alternating calls to next and previous will return the same element repeatedly.)
		 * @return the next element in the list
		 * @throws NoSuchElementException - if the iteration has no next element
		 */
	    @Override
	    public E next() {
			E returnedValue;
			if (!hasNext())
	            throw new NoSuchElementException("There is no next element");
		
			if( positionInArray < next.size - 1 ) { 
				positionInArray++;
				returnedValue = next.data[positionInArray];
				lastPositionInArray = positionInArray;
				lastReturned = next;
			}
			else {
				next = next.next;
				lastReturned = next;
				position++;
				positionInArray = 0;
				returnedValue = next.data[positionInArray];
				lastPositionInArray = positionInArray;
			}
			return returnedValue;
	
	    }

		/**
		 * Returns true if this list iterator has more elements when traversing the list in the reverse direction. (In other words, returns true if previous() would return an element rather than throwing an exception.)
		 * @return true if the list iterator has more elements when traversing the list in the reverse direction
		 */
		@Override
		public boolean hasPrevious() {
		
			if( positionInArray >= 0 )
				return true;
			if( position > 0 )
				return true;
			
			return false;
		}

		/**
		 * Returns the previous element in the list and moves the cursor position backwards. This method may be called repeatedly to iterate through the list backwards, or intermixed with calls to next() to go back and forth.
		 * @return the previous element in the list
		 * @throws NoSuchElementException - if the iteration has no previous element
		 */
		@Override
		public E previous() {
			E returnedValue;
			if (!hasPrevious())
	            throw new NoSuchElementException("There is no previous element");
			
			if( positionInArray >= 0 ) {
				returnedValue = next.data[positionInArray];
				lastPositionInArray = positionInArray;
				positionInArray--;
				lastReturned = next.prev;
			}
			else {
				lastReturned = next.prev;
				next = next.prev;	
				position--;
				
				positionInArray = next.size - 1;
				returnedValue = next.data[positionInArray];
				lastPositionInArray = positionInArray;
				positionInArray--;
			}
			return returnedValue;	
		}

		/**
		 * Returns the index of the element that would be returned by a subsequent call to next(). (Returns list size if the list iterator is at the end of the list.)
		 * @return the index of the element that would be returned by a subsequent call to next, or list size if the list iterator is at the end of the list
		 */
		@Override
		public int nextIndex() {
			return nextIndex;
		}

		/**
		 * Returns the index of the element that would be returned by a subsequent call to previous(). (Returns -1 if the list iterator is at the beginning of the list.)
		 * @return the index of the element that would be returned by a subsequent call to previous, or -1 if the list iterator is at the beginning of the list
		 */
		@Override
		public int previousIndex() {
			return nextIndex - 1;
		}

		/**
		 * Removes from the list the last element that was returned by next() or previous() (optional operation). This call can only be made once per call to next or previous.
		 * @throws IllegalStateException - if neither next nor previous have been called, or remove or add have been called after the last call to next or previous
		 */
		@Override
		public void remove() {
			if (lastReturned == null)
                throw new IllegalStateException();

			for (int i = lastPositionInArray; i < lastReturned.size - 1; i++) {
				lastReturned.data[i] = lastReturned.data[i + 1];    
			}
			lastReturned.size--;
			totalSize--;
			if(lastReturned.size == 0) {
				Node<E> lastNext = lastReturned.next;
		        Node<E> lastPrev = lastReturned.prev;

		        if (lastPrev == null) {
		            head = lastNext;
		        } 
		        else {
		        	lastPrev.next = lastNext;
		            lastPrev = null;
		        }

		        if (lastNext == null) {
		            tail = lastPrev;
		        } 
		        else {
		        	lastNext.prev = lastPrev;
		            lastNext = null;
		        }
		        nodeSize--;
		        
				if(next == lastReturned)
					next = lastNext;
				else
					position--;
			}
			lastReturned = null;
			lastPositionInArray = -1;
		}

		/**
		 * Replaces the last element returned by next() or previous() with the specified element (optional operation). This call can be made only if neither remove() nor add(E) have been called after the last call to next or previous.
		 * @param e  the element with which to replace the last element returned by next or previous
		 * @throws IllegalStateException - if neither next nor previous have been called, or remove or add have been called after the last call to next or previous
		 */
		@Override
		public void set(E e) {
			if (lastReturned == null)
                throw new IllegalStateException();

			lastReturned.data[lastPositionInArray] = e;
		}

		/**
		 * Inserts the specified element into the list (optional operation). The element is inserted immediately before the element that would be returned by next(), if any, and after the element that would be returned by previous(), if any.
		 * @param e the element to insert
		 * @throws IllegalArgumentException - if some aspect of this element prevents it from being added to this list
		 */
		@Override
		public void add(E e) {

			lastReturned = null;
			// if it is empty, or
			if( next == null ) {

				Node<E> tempTail = tail;
				Node<E> newNode = new Node<E>(tempTail, e, null);
				nodeSize++;
				tail = newNode;
				next = newNode;
				if( head == null )
					head = newNode;
				else
					tempTail.next = newNode;
			}
			else if (next.size < Node.INITIAL_CAPACITY) {
				for (int i = next.size; i > positionInArray+1; i--) {
					next.data[i] = next.data[i-1] ;    
				}
				next.data[positionInArray+1] = e; 
				next.size++;
			}

			else if( next.prev != null && next.prev.size < Node.INITIAL_CAPACITY && positionInArray+1 == 0 ) {
				next.prev.data[next.prev.size] = e;
				next.prev.size++;
			}

			else if( positionInArray+1 == 0 ){

				Node<E> newNode = new Node<>(next.prev, e, next);
				if (next.prev == null)
					head = newNode;
				else
					next.prev.next = newNode;

				next.prev = newNode;
				nodeSize++;
			}

			else{
				if( next.prev != null && next.prev.size < Node.INITIAL_CAPACITY ){
					next.prev.data[next.prev.size] = next.data[0];
					next.prev.size++;

					for (int i = 0; i < positionInArray ; i++) {
						next.data[i] = next.data[i + 1];
					}
					next.data[positionInArray ] = e;
				}
				else {
					Node<E> newNode = new Node<E>(next.prev, next.data[next.size-1], next);
					next.prev = newNode;
					next.prev.next = newNode;

					for (int i = next.size; i > positionInArray+1; i--) {
						next.data[i] = next.data[i-1] ;
					}
					next.data[positionInArray+1] = e;
				}
			}
			totalSize++;
		}
		
   	}
	   
   
    /**
     * Returns element at indexed position
     * @param index index that points to the location
	 * @throws IndexOutOfBoundsException - if the index is out of range 
     */
	@Override
	public E get(int index) {
		if( index < 0 || index >= totalSize )
			throw new IndexOutOfBoundsException("Index is not valid");
		ListIterator<E> listIter = listIterator(index);
		return listIter.next();
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list.
	 * @param index the index of the element to be removed
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	@Override
	public E remove(int index) {
		if( index < 0 || index >= totalSize )
			throw new IndexOutOfBoundsException("Index is not valid");
		ListIterator<E> listIter = listIterator(index);
		E temp = listIter.next();
		listIter.remove();

		return temp;
	}
	
	/**
	 * Returns size of total element in LinkedArrayList
	 * @return the number of elements in this list
	 */
	@Override
	public int size() {
		return totalSize;
	}

	/**
	 * Returns a list-iterator of the elements in this list (in proper sequence), starting at the specified position in the list. Obeys the general contract of List.listIterator(int).
	 * @param index  index of the first element to be returned from the list-iterator (by a call to next)
	 * @return a ListIterator of the elements in this list (in proper sequence), starting at the specified position in the list
	 * @throws IndexOutOfBoundsException - if the index is out of range 
	 */
	@Override
	public ListIterator<E> listIterator(final int index) {
		if( index < 0 || index > totalSize )
			throw new IndexOutOfBoundsException("Index is not valid");
		return new LinkedArrayListItr(index);
    }

	/**
	 * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IndexOutOfBoundsException - if the index is out of range 
	 */
	@Override
	public void add(int index, E element){
		if( index < 0 || index > totalSize )
			throw new IndexOutOfBoundsException("Index is not valid");
		ListIterator<E> listIter = listIterator(index);
		listIter.add(element);
	}

	/**
	 * Replaces the element at the specified position in this list with the specified element.
	 * @param index index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException - if the index is out of range 
	 */
	@Override
	public E set(int index, E element) {
		if( index < 0 || index >= totalSize )
			throw new IndexOutOfBoundsException("Index is not valid");

		ListIterator<E> listIter = listIterator(index);
		E temp = listIter.next();
		listIter.set(element);
		return temp;
	}

	/**
	 * Returns all elements together as a string
	 * @return all elements together as a string
	 */
	@Override
	public String toString() {
		ListIterator<E> listIter = new LinkedArrayListItr(0);
		String str = new String();
		while(listIter.hasNext()) {
			str += " " + listIter.next() + ",";
		}
		return str;
	}
}
