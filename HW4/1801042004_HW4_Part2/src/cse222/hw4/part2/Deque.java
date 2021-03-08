package cse222.hw4.part2;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A Deque class to organize some data
 * @author murat
 *
 * @param <E> Data type will be hold
 */
public class Deque<E> extends AbstractCollection<E> implements java.util.Deque<E> {

	/**
	 * start of the Deque
	 */
	private Node<E> head;
	/**
	 * end of the Deque
	 */
	private Node<E> tail;
	/**
	 * head of the deleted nodes
	 */
	private Node<E> deletedNodes;
	/**
	 * how many elements in  Deque
	 */
	private int size;

	/**
	 *  Class to represent an entry in the Deque. 
	 */
	private static class Node<E> {
		/**
		 * Holds data 
		 */
        private E data ;
		/**
		 * Holds next node
		 */
        private Node<E> next;

        /**
		 * Holds prev node
		 */
        private Node<E> prev;
        
		/**
		 * Create a Node
		 * <p> assign next to next , data to element
		 * @param prev that will assign to be prev
		 * @param element that will assign to be data[0]
		 * @param next that will assign to be next
		 */
		Node(Node<E> prev, E element, Node<E> next) {
            this.data = element;
            this.next = next;
            this.prev = prev;
        }
    }

	/**
	 * An iterator class which over the elements in this deque in proper sequential order
	 * @author murat
	 *
	 */
	private class DequeItr implements Iterator<E>{
		
		/**
		 * Node that will be returned by next(). 
		 */
		protected Node<E> next;
		
		/** 
		 * Node that will be affected by remove() or set(). 
		 */
		protected Node<E> lastReturned;

		protected int nextIndex;
		
		/**
		 * Create an DequeItr 
		 */
		public DequeItr() {
			next = head;
			nextIndex = 0;
			lastReturned =  null;
		}
		
		/**
		 * Returns if next is exist or not
		 * @return if next is exist returns true , otherwise false
		 */
		@Override
		public boolean hasNext() {
			
			return (nextIndex < size);
		}
	
		/**
		 * Returns next node data
		 * @return next node data
		 */
		@Override
		public E next() {
			if (!hasNext())
                throw new NoSuchElementException();
			
			lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
		}
		
		/**
		 * Removes last returned node
		 */
		@Override
		public void remove() {
			if (lastReturned == null)
                throw new IllegalStateException();

			if( lastReturned.prev == null )
				removeFirst();
			else if( lastReturned.next == null )
				removeLast();
			else
				removeMiddle(lastReturned);

			lastReturned = null;
		}

		/**
		 * Removes given node
		 * @param deleteNode will be deleted
		 * @return deletedNode data
		 */
		private E removeMiddle(Node<E> deleteNode){
			deleteNode.prev.next = deleteNode.next;
			deleteNode.next.prev = deleteNode.prev;
			addToDeletedNodes(deleteNode);

			return deleteNode.data;
		}
	}
	
	/**
	 * An iterator class which over the elements in this deque in reverse sequential order
	 * @author murat
	 *
	 */
	private class DescendingIterator extends DequeItr {
		
		
		/**
		 * Create an DescendingIterator
		 */
		public DescendingIterator(){
			next = tail;
			nextIndex = size;
			lastReturned =  null;
		}
		
		/**
		 * Returns if next is exist or not
		 * @return if next is exist returns true , otherwise false
		 */
		@Override
		public boolean hasNext() {
			return (nextIndex > 0 );
		}
		
		/**
		 * Returns next node data
		 * @return next node data
		 */
		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();

			lastReturned = next;
			next = next.prev;
			nextIndex--;
			return lastReturned.data;
		}
	}
	
	/**
	 * Initialize head, tail, deletedNodes to null and size to 0
	 */
	public Deque(){
		head = tail = deletedNodes = null;
		size = 0;
	}
	
	/**
	 * Adds newNode to deletedNodes
	 * @param newNode will be added to deletedNodes
	 */
	private void addToDeletedNodes( Node<E> newNode){
		if( deletedNodes == null )
			deletedNodes = newNode;
		else {
			deletedNodes.prev = newNode;
			newNode.prev = null;
			newNode.next = deletedNodes;
			deletedNodes = newNode;
		}
	}

	/**
	 * Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque)
	 * @param e the element to add
	 * @return true (as specified by Collection.add(E))
	 * @throws NullPointerException if the specified element is null and this deque does not permit null elements
	 */
	@Override
	public boolean add(E e) throws NullPointerException {
		addLast(e);
		return true;
	}

	/**
	 * Inserts the specified element at the front of this deque
	 * @param e the element to add
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public void addFirst(E e) throws NullPointerException  {
		offerFirst(e);
	}

	/**
	 * 	Inserts the specified element at the end of this deque
	 * @param e the element to add
	 * @throws NullPointerException  if the specified element is null
	 */
	@Override
	public void addLast(E e) throws NullPointerException {
		offerLast(e);
	}

	/**
	 * Inserts the specified element at the front of this deque
	 * @param e the element to add
	 * @return true if the element was added to this deque, else false
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public boolean offerFirst(E e) throws NullPointerException {
		if( e == null)
			throw new NullPointerException();

		Node<E> newNode;
		if( deletedNodes == null)
			newNode = new  Node<E>(null, e, head);
		else{
			newNode = deletedNodes;
			deletedNodes = deletedNodes.next;
			newNode.data = e;
			newNode.prev = null;
			newNode.next = head;
		}

		if( head != null )
			head.prev = newNode;
		else
			tail = newNode;

		head = newNode;
		size++;

		return true;
	}

	/**
	 * Inserts the specified element at the end of this deque
	 * @param e the element to add
	 * @return true if the element was added to this deque, else false
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public boolean offerLast(E e) throws NullPointerException {
		if( e == null)
			throw new NullPointerException();

		Node<E> newNode;
		if (deletedNodes == null)
			newNode = new Node<E>(tail, e, null);
		else {
			newNode = deletedNodes;
			deletedNodes = deletedNodes.next;
			newNode.data = e;
			newNode.prev = tail;
			newNode.next = null;
		}

		if( tail != null )
			tail.next = newNode;
		else
			head = newNode;

		tail = newNode;
		size++;

		return true;
	}

	/**
	 * 	Retrieves and removes the first element of this deque. This method differs from pollFirst only in that it throws an exception if this deque is empty.
	 * @return the head of this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	@Override
	public E removeFirst() throws NoSuchElementException {
		E temp = pollFirst();
		if(temp == null)
			throw new NoSuchElementException();
		return temp;
	}

	/**
	 * Retrieves and removes the last element of this deque. This method differs from pollLast only in that it throws an exception if this deque is empty.
	 * @return the tail of this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	@Override
	public E removeLast() throws NoSuchElementException {
		E temp = pollLast();
		if(temp == null)
			throw new NoSuchElementException();
		return temp;
	}

	/**
	 * Retrieves and removes the first element of this deque, or returns null if this deque is empty.
	 * @return the head of this deque, or null if this deque is empty
	 */
	@Override
	public E pollFirst() {
		if( head == null)
			return null;

		if(size == 1)
			tail = null;

		Node<E> tempHead = head;
		head = head.next;
		head.prev = null;
		addToDeletedNodes( tempHead );
		size--;

		return tempHead.data;
	}

	/**
	 * Retrieves and removes the last element of this deque, or returns null if this deque is empty.
	 * @return the tail of this deque, or null if this deque is empty
	 */
	@Override
	public E pollLast() {
		if( head == null)
			return null;

		if(size == 1)
			head = null;

		Node<E> tempTail = tail;
		tail = tail.prev;
		tail.next = null;
		addToDeletedNodes( tempTail );

		size--;
		return tempTail.data;
	}

	/**
	 * Retrieves, but does not remove, the first element of this deque. This method differs from peekFirst only in that it throws an exception if this deque is empty.
	 * @return the head of this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	@Override
	public E getFirst() throws NoSuchElementException {
		if( peekFirst() == null)
			throw new NoSuchElementException();
		return head.data;
	}

	/**
	 * Retrieves, but does not remove, the last element of this deque. This method differs from peekLast only in that it throws an exception if this deque is empty.
	 * @return the tail of this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	@Override
	public E getLast() throws NoSuchElementException {
		if( peekLast() == null)
			throw new NoSuchElementException();
		return tail.data;
	}

	/**
	 * Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
	 * @return the head of this deque, or null if this deque is empty
	 */
	@Override
	public E peekFirst() {
		if( head == null )
			return  null;
		return head.data;
	}

	/**
	 * Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
	 * @return the tail of this deque, or null if this deque is empty
	 */
	@Override
	public E peekLast() {
		if( tail == null )
			return  null;
		return tail.data;
	}

	/**
	 * Removes the first occurrence of the specified element from this deque.
	 * @param o  element to be removed from this deque, if present
	 * @return true if an element was removed as a result of this call
	 * @throws NullPointerException if the specified element is null and this deque does not permit null elements
	 */
	@Override
	public boolean removeFirstOccurrence(Object o) throws NullPointerException {
		if(o == null)
			throw new NullPointerException();

		Iterator<E> iter = new DequeItr();
		while ( iter.hasNext() ){
			if (o.equals(iter.next())){
				iter.remove();
				size--;
				return true;
			}
		}

		return false;
	}

	/**
	 * Removes the last occurrence of the specified element from this deque.
	 * @param o element to be removed from this deque, if present
	 * @return true if an element was removed as a result of this call
	 * @throws NullPointerException if the specified element is null and this deque does not permit null elements
	 */
	@Override
	public boolean removeLastOccurrence(Object o) throws NullPointerException{
		if(o == null)
			throw new NullPointerException();

		Iterator<E> iter = new DescendingIterator();
		while ( iter.hasNext() ){
			if (o.equals(iter.next())){
				iter.remove();
				size--;
				return true;
			}
		}
		return false;
	}

	/**
	 * Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque)
	 * @param e the element to add
	 * @return true if the element was added to this deque, else false
	 * @throws NullPointerException if the specified element is null and this deque does not permit null elements
	 */
	@Override
	public boolean offer(E e) throws NullPointerException{
		return offerLast(e);
	}

	/**
	 * Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque). This method differs from poll only in that it throws an exception if this deque is empty.
	 * @return the head of the queue represented by this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	@Override
	public E remove() throws NoSuchElementException {
		return removeFirst();
	}

	/**
	 * Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
	 * @return the first element of this deque, or null if this deque is empty
	 */
	@Override
	public E poll() {
		return pollFirst();
	}

	/**
	 * Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque). This method differs from peek only in that it throws an exception if this deque is empty.
	 * @return the head of the queue represented by this deque
	 */
	@Override
	public E element() throws NoSuchElementException {
		return getFirst();
	}

	/**
	 * Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
	 * @return the head of the queue represented by this deque, or null if this deque is empty
	 */
	@Override
	public E peek() {
		return peekFirst();
	}

	/**
	 * Pushes an element onto the stack represented by this deque (in other words, at the head of this deque)
	 * @param e the element to push
	 * @throws NullPointerException if the specified element is null and this deque does not permit null elements
	 */
	@Override
	public void push(E e) throws NullPointerException  {
		addFirst(e);
	}

	/**
	 * Pops an element from the stack represented by this deque. In other words, removes and returns the first element of this deque.
	 * @return the element at the front of this deque (which is the top of the stack represented by this deque)
	 * @throws NullPointerException if this deque is empty
	 */
	@Override
	public E pop() throws NullPointerException {
		return removeFirst();
	}

	/**
	 * Returns an iterator over the elements in this deque in reverse sequential order. The elements will be returned in order from last (tail) to first (head).
	 * @return an iterator over the elements in this deque in reverse sequence
	 */
	@Override
	public Iterator<E> descendingIterator() {
		return new DescendingIterator();
	}

	/**
	 * Returns an iterator over the elements in this deque in proper sequence. The elements will be returned in order from first (head) to last (tail).
	 * @return an iterator over the elements in this deque in proper sequence
	 */
	@Override
	public Iterator<E> iterator() {
		return new DequeItr();
	}

	/**
	 * Returns the number of elements in this deque.
	 * @return the number of elements in this deque
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * Returns Deque as a string
	 * @return Deque as a string
	 */
	public String toString(){
		String str = new String();
		Iterator<E> iter = iterator();

		while ( iter.hasNext() ){
			str += iter.next() + ", " ;
		}

		return "\n" + str + "\n" ;
	}
}
