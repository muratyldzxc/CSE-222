import java.util.ListIterator;
import java.util.NoSuchElementException;

import cse222.hw3.*;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//************ TEST ADD FUNCTION
		System.out.printf("\n LinkedArrayList constructor called with Integer type\n");
		LinkedArrayList<Integer> l = new LinkedArrayList<Integer>();
		System.out.printf("\n LinkedArrayList is created with Integer type \n");

		try {
			System.out.printf("\n Try to delete element from an empty LinkedArrayList with index(0) \n");
			l.remove(0);
		}
		catch (IndexOutOfBoundsException e){
			System.out.printf("\n %s\n", e.toString());
		}

		System.out.printf("\n Try to add an element(5) to an empty LinkedArrayList \n");
		l.add(0,5);
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());

		System.out.printf("\n Try to add an element(8) to end of the LinkedArrayList \n");
		l.add(1,8);
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());

		System.out.printf("\n Try to add elements(7,7,15,22,35,5,3) to end of the LinkedArrayList \n");
		l.add(7);
		l.add(7);
		l.add(15);
		l.add(22);
		l.add(35);
		l.add(5);
		l.add(3);
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());

		System.out.printf("\n Try to add an element(10) to begin of non empty LinkedArrayList \n");
		l.add(0,10);
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());

		System.out.printf("\n Try to add an element(10) Indexed which is 20 out of bounds to LinkedArrayList \n");
		try {
			l.add(20, 15);
		}
		catch (IndexOutOfBoundsException e){
			System.out.printf("\n %s\n", e.toString());
		}

		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());

		System.out.printf("\n Try to delete an element(10) indexed(0) from LinkedArrayList \n");
		l.remove(0);
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());

		System.out.printf("\n Try to delete an element(%d) indexed(4) from LinkedArrayList \n",l.remove(4));
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());

		System.out.printf("\n Try to delete an element(3) indexed(%d) from LinkedArrayList \n", l.size()-1);
		l.remove(l.size()-1);
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());

		System.out.printf("\n Try to delete an element indexed(20) which is out of bounds from LinkedArrayList \n");
		try {
			l.remove(20);
		}
		catch (IndexOutOfBoundsException e){
			System.out.printf("\n %s\n", e.toString());
		}
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());

		System.out.printf("\n\n TEST GET FUNCTION OF LinkedArrayList \n\n");
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n***** USE OF GET INDEX 0: %d \n", l.get(0));
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n***** USE OF GET INDEX 5: %d \n", l.get(5));
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n***** USE OF GET INDEX SIZE-1: %d \n", l.get(l.size()-1));
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n***** USE OF GET INDEX 20: \n");
		try {
			l.get(20);
		}
		catch (IndexOutOfBoundsException e){
			System.out.printf("\n %s\n", e.toString());
		}

		System.out.printf("\n\n TEST SET FUNCTION OF LinkedArrayList \n\n");
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n***** USE OF SET INDEX 0: OLD VALUE : %d  NEW VALUE : 11 \n", l.set(0,11));
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n***** USE OF SET INDEX 5: OLD VALUE : %d  NEW VALUE : 96 \n", l.set(5,96));
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n***** USE OF SET INDEX SIZE-1: OLD VALUE : %d  NEW VALUE : 65 \n", l.set(l.size()-1,65));
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n***** USE OF SET INDEX 20: \n");
		try {
			l.set(20, 26);
		}
		catch (IndexOutOfBoundsException e){
			System.out.printf("\n %s\n", e.toString());
		}

		System.out.printf("\n\n TEST NEXT FUNCTION OF LinkedArrayListItr \n\n");
		System.out.printf("\n Create LinkedListArrayItr with index(0) \n");
		ListIterator<Integer> listIter = l.listIterator(0);

		System.out.printf("\n Testing listIterator next function as printing forward until hasNext function will return false\n\n");
		while(listIter.hasNext()) {
			System.out.printf(" %d,", listIter.next() );
		}
		System.out.printf("\n After tested next function Testing listIterator previous function as printing backward until hasPrevious function will return false\n\n");
		while(listIter.hasPrevious()) {
			System.out.printf(" %d,", listIter.previous() );
		}
		System.out.printf("\n After tested previous function Testing listIterator next function as printing forward until hasNext function will return false\n\n");
		while(listIter.hasNext()) {
			System.out.printf(" %d,", listIter.next() );
		}
		System.out.printf("\n After tested next function Testing listIterator previous function as printing backward until hasPrevious function will return false\n\n");
		while(listIter.hasPrevious()) {
			System.out.printf(" %d,", listIter.previous() );
		}

		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n Call listIterator function with index size+1 \n");
		try{
			listIter = l.listIterator(l.size()+1);
		}
		catch (IndexOutOfBoundsException e){
			System.out.printf("\n %s\n", e.toString());
		}

		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n Call listIterator function with index -1 \n");
		try{
			listIter = l.listIterator(-1);
		}
		catch (IndexOutOfBoundsException e){
			System.out.printf("\n %s\n", e.toString());
		}

		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n After call listIterator function with index size, call next function \n");
		listIter = l.listIterator(l.size());
		try{
			listIter.next();
		}
		catch (NoSuchElementException e){
			System.out.printf("\n %s\n", e.toString());
		}

		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n After call listIterator function with index 0, call previous function \n");
		listIter = l.listIterator(0);
		try{
			listIter.previous();
		}
		catch (NoSuchElementException e){
			System.out.printf("\n %s\n", e.toString());
		}

		listIter = l.listIterator(5);
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n After call listIterator function with index 5, call nextIndex \n nextIndex = %d \n", listIter.nextIndex());
		System.out.printf("\n After call listIterator function with index 5, call previousIndex \n previousIndex = %d \n", listIter.previousIndex());

		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n After call listIterator function with index 5 , call remove\n");
		try{
			listIter.remove();
		}
		catch (IllegalStateException e) {
			System.out.printf("\n %s\n", e.toString());
		}

		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());

		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		System.out.printf("\n After call listIterator function with index 5 and call next, call remove\n");
		listIter.next();
		listIter.remove();
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());



		listIter = l.listIterator(5);
		System.out.printf("\n After call listIterator function with index 5 , call add(89)\n");
		listIter.add(89);
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());

		listIter = l.listIterator(5);
		System.out.printf("\n After call listIterator function with index 5 , call set(69)\n");
		try{
			listIter.set(69);
		}
		catch (IllegalStateException e) {
			System.out.printf("\n %s\n", e.toString());
		}

		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());
		listIter = l.listIterator(5);
		System.out.printf("\n After call listIterator function with index 5 and call next, call set(69)\n");
		listIter.next();
		listIter.set(69);
		System.out.printf("\n The LinkedArrayList \n %s\n", l.toString());

	}

}
