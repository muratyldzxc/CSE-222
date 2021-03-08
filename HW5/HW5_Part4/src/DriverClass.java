import cse222.hw5.part4.*;
public class DriverClass {

	public static void main(String[] args) {

		System.out.printf("\n TEST01 - Creating a MaxHeap\n");
		MaxHeap heap = new MaxHeap();
		System.out.printf("\n Successfully Created\n");

		System.out.printf("\n TEST02 - Testing add() with null\n");
		try{
			heap.add(null);
		}catch (Exception e){
			System.out.printf("\n %s\n", e.toString());
		}

		System.out.printf("\n TEST03 - Testing remove() with null\n");
		try{
			heap.remove(null);
		}catch (Exception e){
			System.out.printf("\n %s\n", e.toString());
		}

		System.out.printf("\n TEST04 - Testing find() with null\n");
		try{
			heap.find(null);
		}catch (Exception e){
			System.out.printf("\n %s\n", e.toString());
		}

		System.out.printf("\n After add some data respectively \n" +
				" (10, 5, 10, 70, 10, 50, 15, 15, 70, 50, 11)\n");

		heap.add(new AgeData(10));
		heap.add(new AgeData(5));
		heap.add(new AgeData(70));
		heap.add(new AgeData(10));
		heap.add(new AgeData(50));
		heap.add(new AgeData(15));
		heap.add(new AgeData(15));
		heap.add(new AgeData(70));
		heap.add(new AgeData(50));
		heap.add(new AgeData(11));

		System.out.print("\n" + heap.toString() + "\n");

		System.out.printf("\n TEST05 - Testing find() with 50\n");
		System.out.print("\n " +heap.find(new AgeData(50)).toString() + "\n");
		System.out.print("\n" + heap.toString() + "\n");

		System.out.printf("\n TEST06 - Testing remove() with 10\n");
		heap.remove(new AgeData(10));
		System.out.print("\n" + heap.toString() + "\n");

		System.out.printf("\n TEST07 - Testing remove() with 50\n");
		heap.remove(new AgeData(50));
		System.out.print("\n" + heap.toString() + "\n");

		System.out.printf("\n TEST08 - Testing remove() with 50\n");
		heap.remove(new AgeData(50));
		System.out.print("\n" + heap.toString() + "\n");

		System.out.printf("\n TEST09 - Testing add() with 5\n");
		heap.add(new AgeData(5));
		System.out.print("\n" + heap.toString() + "\n");

		System.out.printf("\n TEST10 - Testing add() with 5\n");
		heap.add(new AgeData(5));
		System.out.print("\n" + heap.toString() + "\n");

		System.out.printf("\n TEST11 - Testing youngerThan() with 50\n");
		System.out.print("\n " + heap.youngerThan(50) + "\n");
		System.out.print("\n" + heap.toString() + "\n");

		System.out.printf("\n TEST12- Testing olderThan() with 11\n");
		System.out.print("\n " + heap.olderThan(11) + "\n");

	}

}
