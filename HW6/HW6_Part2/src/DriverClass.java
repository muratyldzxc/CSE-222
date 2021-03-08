import java.util.LinkedList;
import java.util.Random;

import cse222.hw6.part2.*;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Integer> arr1 = new LinkedList<Integer>();
		LinkedList<Integer> arr2 = new LinkedList<Integer>();
		LinkedList<Integer> arr3 = new LinkedList<Integer>();
		
		for( int i=0; i<10; i++) {
			arr1.add(i+1);
		}
		
		for( int i=0; i<10; i++) {
			arr2.add(10 - i);
		}
		
		for( int i=0; i<10; i++) {
			arr3.add(10 - i);
		}
		
		System.out.printf("\n Before use MergeSortLinkedList on arr2:  ");
		for( Integer i:arr2) {
			System.out.print(" " + i + ",");
		}
		
		MergeSortLinkedList.sort(arr2);
		
		System.out.printf("\n\n After use MergeSortLinkedList on arr2:  ");
		for( Integer i:arr2) {
			System.out.print(" " + i + ",");
		}
		
		System.out.printf("\n\n Before use QuickSortLinkedList on arr3:  ");
		for( Integer i:arr3) {
			System.out.print(" " + i + ",");
		}
		
		QuickSortLinkedList.sort(arr3);
		
		System.out.printf("\n\n After use QuickSortLinkedList on arr3:  ");
		for( Integer i:arr3) {
			System.out.print(" " + i + ",");
		}
		
		System.out.printf("\n\n Before use MergeSortLinkedList on arr1:  ");
		for( Integer i:arr2) {
			System.out.print(" " + i + ",");
		}
		
		MergeSortLinkedList.sort(arr1);
		
		System.out.printf("\n\n After use MergeSortLinkedList on arr1:  ");
		for( Integer i:arr2) {
			System.out.print(" " + i + ",");
		}
		
		System.out.printf("\n\n Before use QuickSortLinkedList on arr1:  ");
		for( Integer i:arr1) {
			System.out.print(" " + i + ",");
		}
		
		QuickSortLinkedList.sort(arr1);
		
		System.out.printf("\n\n After use QuickSortLinkedList on arr1:  ");
		for( Integer i:arr1) {
			System.out.print(" " + i + ",");
		}

		
		
		/*	 TESTS 	FOR RUNNING TIMES
	     System.out.printf("\n Selection Sort\n");
		for(int i =0; i<20; i++) {
			eSS();
		}
		
		
		System.out.printf("\n\n Bubble Sort\n");
		for(int i =0; i<3; i++) {
			eBS();
		}
		
		System.out.printf("\n\n Insertion Sort\n");
		for(int i =0; i<20; i++) {
			eIS();
		}
		
		System.out.printf("\n\n Shell Sort\n");
		for(int i =0; i<20; i++) {
			eSellS();
		}
		
		System.out.printf("\n\n Merge Sort\n");
		for(int i =0; i<20; i++) {
			eMS();
		}
		
		System.out.printf("\n\n Heap Sort\n");
		for(int i =0; i<20; i++) {
			eHS();
		}
		
		System.out.printf("\n\n Quick Sort\n");
		for(int i =0; i<20; i++) {
			eQS();
		}
		
		
		System.out.printf("\n\n MergeSortLinkedlist \n");
		for(int i =0; i<20; i++) {
			eMSLL();
		}
		
		System.out.printf("\n\n   QuickSortLinkedlist \n");
		for(int i =0; i<20; i++) {
			eQSLL();
		}	
		*/
		
	}
	
	public static void eSS() {
		Integer [] arr = new Integer[10000];
        Random rand = new Random();
        for( int i = 0 ; i < 10000 ; ++i ) 
            arr[i] = rand.nextInt(10000) ;
        
        
        long begin, end;
        
        begin = System.nanoTime();
		SelectionSort.sort(arr);
        end = System.nanoTime();
        
        System.out.printf("\n%d", (end - begin) /1000000);
        
        begin = System.nanoTime();
		SelectionSort.sort(arr);
        end = System.nanoTime();
        System.out.printf("\nSorted: %d", (end - begin) /1000000);
        
	}
	
	public static void eBS() {
		Integer [] arr = new Integer[10000];
        Random rand = new Random();
        for( int i = 0 ; i < 10000 ; ++i ) 
            arr[i] = rand.nextInt(10000) ;
        
        
        long begin, end;
        
        begin = System.nanoTime();
		BubbleSort.sort(arr);
        end = System.nanoTime();
        
        System.out.printf("\n%d", (end - begin) /1000000);
        
        begin = System.nanoTime();
        BubbleSort.sort(arr);
        end = System.nanoTime();
        System.out.printf("\nSorted: %d", (end - begin) /1000000);
	}
	
	
	public static void eIS() {
		Integer [] arr = new Integer[10000];
        Random rand = new Random();
        for( int i = 0 ; i < 10000 ; ++i ) 
            arr[i] = rand.nextInt(10000) ;
        
        
        long begin, end;
        
        begin = System.nanoTime();
		InsertionSort.sort(arr);
        end = System.nanoTime();
        
        System.out.printf("\n%d", (end - begin) /1000000);
        
        begin = System.nanoTime();
        InsertionSort.sort(arr);
        end = System.nanoTime();
        System.out.printf("\nSorted: %d", (end - begin) /1000000);
	}
	
	public static void eSellS() {
		Integer [] arr = new Integer[10000];
        Random rand = new Random();
        for( int i = 0 ; i < 10000 ; ++i ) 
            arr[i] = rand.nextInt(10000) ;
        
        
        long begin, end;
        
        begin = System.nanoTime();
		ShellSort.sort(arr);
        end = System.nanoTime();
        
        System.out.printf("\n%d", (end - begin) /1000000);
        
        begin = System.nanoTime();
        ShellSort.sort(arr);
        end = System.nanoTime();
        System.out.printf("\nSorted: %d", (end - begin) /1000000);
	}
	
	public static void eMS() {
		Integer [] arr = new Integer[10000];
        Random rand = new Random();
        for( int i = 0 ; i < 10000 ; ++i ) 
            arr[i] = rand.nextInt(10000) ;
        
        
        long begin, end;
        
        begin = System.nanoTime();
		MergeSort.sort(arr);
        end = System.nanoTime();
        
        System.out.printf("\n%d", (end - begin) /1000000);
        
        begin = System.nanoTime();
        MergeSort.sort(arr);
        end = System.nanoTime();
        System.out.printf("\nSorted: %d", (end - begin) /1000000);
	}
	
	public static void eHS() {
		Integer [] arr = new Integer[10000];
        Random rand = new Random();
        for( int i = 0 ; i < 10000 ; ++i ) 
            arr[i] = rand.nextInt(10000) ;
        
        
        long begin, end;
        
        begin = System.nanoTime();
		HeapSort.sort(arr);
        end = System.nanoTime();
        
        System.out.printf("\n%d", (end - begin) /1000000);
        
        begin = System.nanoTime();
        HeapSort.sort(arr);
        end = System.nanoTime();
        System.out.printf("\nSorted: %d", (end - begin) /1000000);
	}
	
	public static void eQS() {
		Integer [] arr = new Integer[10000];
        Random rand = new Random();
        for( int i = 0 ; i < 10000 ; ++i ) 
            arr[i] = rand.nextInt(10000) ;
        
        
        long begin, end;
        
        begin = System.nanoTime();
        QuickSort.sort(arr);
        end = System.nanoTime();
        
        System.out.printf("\n%d", (end - begin) /1000000);
        
        begin = System.nanoTime();
        QuickSort.sort(arr);
        end = System.nanoTime();
        System.out.printf("\nSorted: %d", (end - begin) /1000000);
	}
	
	
	public static void eQSLL() {
		LinkedList<Integer> list = new LinkedList<Integer>();
        Random rand = new Random();
        for( int i = 0 ; i < 10000 ; ++i ) 
            list.add( rand.nextInt(10000) ) ;
        
        long begin, end;
        
        begin = System.nanoTime();
		QuickSortLinkedList.sort(list);
        end = System.nanoTime();
        
        System.out.printf("\n%d", (end - begin) /1000000);
        
        begin = System.nanoTime();
        QuickSortLinkedList.sort(list);
        end = System.nanoTime();
        System.out.printf("\nSorted: %d", (end - begin) /1000000);
    }
	
	public static void eMSLL() {
		LinkedList<Integer> list = new LinkedList<Integer>();
        Random rand = new Random();
        for( int i = 0 ; i < 10000 ; ++i ) 
            list.add( rand.nextInt(10000) ) ;
        
        long begin, end;
        
        begin = System.nanoTime();
		MergeSortLinkedList.sort(list);
        end = System.nanoTime();
        
        System.out.printf("\n%d", (end - begin) /1000000);
        
        begin = System.nanoTime();
        MergeSortLinkedList.sort(list);
        end = System.nanoTime();
        System.out.printf("\nSorted: %d", (end - begin) /1000000);
	}

}
