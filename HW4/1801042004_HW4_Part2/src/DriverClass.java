import cse222.hw4.part2.*;




public class DriverClass {

	public static void main(String[] args) {


		System.out.printf("\n*******TESTING********\n");

		System.out.printf("\nTEST01\n");
		Deque<Integer> deq = new Deque<Integer>();
		System.out.printf("\nDeque was created\n");

		System.out.printf("\nTEST02 - E getFirst() called , when Deque is empty\n");
		try{
			deq.getFirst();
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.printf("\nTEST03 - E getLast() called , when Deque is empty\n");
		try{
			deq.getLast();
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.printf("\nTEST04 - E peekFirst()  called , when Deque is empty\n");
		System.out.println("Returned: " + deq.peekFirst());

		System.out.printf("\nTEST05 - E peekLast()   called , when Deque is empty\n");
		System.out.println("Returned: " + deq.peekLast());

		System.out.printf("\nTEST06 - E element() called , when Deque is empty\n");
		try{
			deq.element();
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.printf("\nTEST07 - E peek()   called , when Deque is empty\n");
		System.out.println("Returned: " + deq.peek());

		System.out.printf("\nTEST08 - E pop() called , when Deque is empty\n");
		try{
			deq.pop();
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.printf("\nTEST09 - E remove() called , when Deque is empty\n");
		try{
			deq.remove();
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.printf("\nTEST10 - E removeFirst() called , when Deque is empty\n");
		try{
			deq.removeFirst();
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.printf("\nTEST11 - E removeLast() called , when Deque is empty\n");
		try{
			deq.removeLast();
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.printf("\nTEST12 - E poll()   called , when Deque is empty\n");
		System.out.println("Returned: " + deq.poll());

		System.out.printf("\nTEST13 - E pollFirst()   called , when Deque is empty\n");
		System.out.println("Returned: " + deq.pollFirst());

		System.out.printf("\nTEST14 - E pollLast()   called , when Deque is empty\n");
		System.out.println("Returned: " + deq.pollLast());

		System.out.printf("\nTEST15 - addFirst(E e) called , when e = null\n");
		try{
			deq.addFirst(null);
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.printf("\nTEST16 - addFirst(E e) called , when e = 15\n");
		deq.addFirst(15);
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST17 - addLast(E e) called , when e = null\n");
		try{
			deq.addLast(null);
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.printf("\nTEST18 - addLast(E e) called , when e = 28\n");
		deq.addLast(28);
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST19 - add(E e) called , when e = null\n");
		try{
			deq.add(null);
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.printf("\nTEST20 - add(E e) called , when e = 39\n");
		deq.add(39);
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST21 - offerFirst(E e) called , when e = null\n");
		try{
			deq.offerFirst(null);
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.printf("\nTEST22 - offerFirst(E e) called , when e = 52\n");
		deq.offerFirst(52);
		System.out.print("\n Deque \n" + deq.toString());

		System.out.printf("\nTEST23 - offerLast(E e) called , when e = null\n");
		try{
			deq.offerLast(null);
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.printf("\nTEST24 - offerLast(E e) called , when e = 83\n");
		deq.offerLast(83);
		System.out.print("\n Deque \n" + deq.toString());

		System.out.printf("\nAfter add some elements (7, 16, 65, 47, 78, 17, 24)\n");
		deq.add(7);
		deq.add(16);
		deq.add(65);
		deq.add(7);
		deq.add(47);
		deq.add(78);
		deq.add(17);
		deq.add(24);
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST25 - E removeFirst() called , Returned: %d\n"
					, deq.removeFirst());
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST26 - E removeLast() called , Returned: %d\n"
				, deq.removeLast());
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST27 - E pollFirst() called , Returned: %d\n"
				,deq.pollFirst());
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST28 - E pollLast() called , Returned: %d \n"
				,deq.pollLast());
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST29 - E getFirst() called , Returned: %d\n"
				,deq.getFirst());
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST30 - E getLast() called , Returned: %d\n"
				,deq.getLast());
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST31 - E peekFirst() called , Returned: %d\n"
				,deq.peekFirst());
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST32 - E peekLast() called , Returned: %d\n"
				,deq.peekLast());
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST33 - boolean removeFirstOccurrence(Object o) called , when o = null\n");
		try{
			deq.removeFirstOccurrence(null);
		}catch (Exception e){
			System.out.println(e);
		}
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST34 - boolean removeFirstOccurrence(Object o) called , o = 83 Returned: %b\n"
				, deq.removeFirstOccurrence(83));
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST35 - boolean removeLastOccurrence(Object o) called , when o = null\n");
		try{
			deq.removeLastOccurrence(null);
		}catch (Exception e){
			System.out.println(e);
		}
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST36 - boolean removeLastOccurrence(Object o) called , o = 7 Returned: %b\n"
				, deq.removeLastOccurrence(7));
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST37 - offer(E e) called , when e = null\n");
		try{
			deq.offer(null);
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.printf("\nTEST38 - offer(E e) called , when e = 78\n");
		deq.offer(78);
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST39 - E remove() called , Returned: %d\n"
				,deq.remove());
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST40 - E poll() called , Returned: %d\n"
				,deq.poll());
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST41- E element() called , Returned: %d\n"
				,deq.element());
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST42 - E peek() called , Returned: %d\n"
				,deq.peek());
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST43 - push(E e), when e = null \n");
		try{
			deq.push(null);
		}catch (Exception e){
			System.out.println(e);
		}
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST44 - push(E e), when e = 31 called \n");
		deq.push(31);
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST45 - E pop() called , Returned: %d\n"
				,deq.pop());
		System.out.print("\n Deque " + deq.toString());

		System.out.printf("\nTEST46 - int size() called , Returned: %d\n"
				,deq.size());
		System.out.print("\n Deque " + deq.toString());
	}
	
}
