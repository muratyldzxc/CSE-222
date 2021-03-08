import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

import cse222.hw7.part3.*;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("\n Binary Search tree insertion\n");
		addBST(80000);

		System.out.printf("\n Red Black tree in Book  insertion\n");
		addRBTBook(80000);

		System.out.printf("\n Red Black tree in java insertion \n");
		addRBTJava(80000);

		System.out.printf("\n Skip List in Book insertion\n");
		addSLBook(80000);

		System.out.printf("\n Skip List in Q2 insertion\n");
		addSLQ2(80000);

		System.out.printf("\n Skip List in java insertion\n");
		addSLJava(80000);

		System.out.printf("\n BTree in book insertion\n");
		addBTree(80000);

		
			
	}
	
	public static void addBST(int size) {

		BinarySearchTree<Integer> data;
		Random rand = new Random();

		long begin, end;
		for (int j=0; j<10; j++){
			data = new BinarySearchTree<Integer>();

			for (int i=0; i<size; i++)
				data.add(rand.nextInt());

			begin = System.nanoTime();
			for (int i=0; i<10; i++)
				data.add(rand.nextInt());
			end = System.nanoTime();
			System.out.println((end-begin));
		}
	}

	public static void addRBTBook(int size) {

		RedBlackTree<Integer> data;
		Random rand = new Random();

		long begin, end;
		for (int j=0; j<10; j++){
			data = new RedBlackTree<Integer>();

			for (int i=0; i<size; i++)
				data.add(rand.nextInt());

			begin = System.nanoTime();
			for (int i=0; i<10; i++)
				data.add(rand.nextInt());
			end = System.nanoTime();
			System.out.println((end-begin));
		}
	}

	public static void addSLBook(int size) {

		SkipList<Integer> data ;
		Random rand = new Random();

		long begin, end;
		for (int j=0; j<10; j++){
			data = new SkipList<Integer>();

			for (int i=0; i<size; i++)
				data.add(rand.nextInt());

			begin = System.nanoTime();
			for (int i=0; i<10; i++)
				data.add(rand.nextInt());
			end = System.nanoTime();
			System.out.println((end-begin));
		}
	}

	public static void addSLQ2(int size) {

		SkipListQ2<Integer> data ;
		Random rand = new Random();

		long begin, end;
		for (int j=0; j<10; j++){
			data = new SkipListQ2<Integer>(5);

			for (int i=0; i<size; i++)
				data.add(rand.nextInt());

			begin = System.nanoTime();
			for (int i=0; i<10; i++)
				data.add(rand.nextInt());
			end = System.nanoTime();
			System.out.println((end-begin));
		}
	}

	public static void addSLJava(int size) {

		ConcurrentSkipListSet<Integer> data ;
		Random rand = new Random();

		long begin, end;
		for (int j=0; j<10; j++){
			data = new ConcurrentSkipListSet<Integer>();

			for (int i=0; i<size; i++)
				data.add(rand.nextInt());

			begin = System.nanoTime();
			for (int i=0; i<10; i++)
				data.add(rand.nextInt());
			end = System.nanoTime();
			System.out.println((end-begin));
		}
	}

	public static void addRBTJava(int size) {

		TreeMap<Integer,Integer> data ;
		Random rand = new Random();

		long begin, end;
		for (int j=0; j<10; j++){
			data = new TreeMap<Integer,Integer>();

			for (int i=0; i<size; i++)
				data.put(rand.nextInt(), 0);

			begin = System.nanoTime();
			for (int i=0; i<10; i++)
				data.put(rand.nextInt(), 0);
			end = System.nanoTime();
			System.out.println((end-begin));
		}
	}

	public static void addBTree(int size) {

		BTree<Integer> data ;
		Random rand = new Random();

		long begin, end;
		for (int j=0; j<10; j++){
			data = new BTree<Integer>(5);

			for (int i=0; i<size; i++)
				data.add(rand.nextInt());

			begin = System.nanoTime();
			for (int i=0; i<10; i++)
				data.add(rand.nextInt());
			end = System.nanoTime();
			System.out.println((end-begin));
		}
	}





}
