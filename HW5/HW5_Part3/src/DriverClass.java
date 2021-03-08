import cse22.hw5.part3.*;

public class DriverClass {

	public static void main(String[] args) {
		System.out.printf("\n TEST01 - Testing AgeSearchTree no parameter constructor \n");
		AgeSearchTree ageTree = new AgeSearchTree();
		System.out.printf("\n Successfully Created \n");

		System.out.printf("\n TEST02 - Testing add() with null \n");
		try {
			ageTree.add(null);
		}catch (Exception e){
			System.out.printf("\n %s \n", e.toString());
		}

		System.out.printf("\n TEST03 - Testing remove() with null \n");
		try {
			ageTree.remove(null);
		}catch (Exception e){
			System.out.printf("\n %s \n", e.toString());
		}

		System.out.printf("\n TEST04 - Testing find() with null \n");
		try {
			ageTree.find(null);
		}catch (Exception e){
			System.out.printf("\n %s \n", e.toString());
		}

		System.out.printf("\n After add some data \n");
		ageTree.add(new AgeData(12));
		ageTree.add(new AgeData(10));
		ageTree.add(new AgeData(20));
		ageTree.add(new AgeData(5));
		ageTree.add(new AgeData(15));
		ageTree.add(new AgeData(10));
		ageTree.add(new AgeData(15));

		ageTree.add(new AgeData(20));
		ageTree.add(new AgeData(20));

		ageTree.add(new AgeData(5));
		ageTree.add(new AgeData(8));

		ageTree.add(new AgeData(13));
		ageTree.add(new AgeData(12));

		System.out.printf("\n %s \n", ageTree.toString());

		System.out.printf("\n TEST05 - Testing youngerThan() with 13 \n");
		System.out.println(" " + ageTree.youngerThan(13));

		System.out.printf("\n %s \n", ageTree.toString());
		System.out.printf("\n TEST06 - Testing olderThan() with 8 \n");
		System.out.println(" " + ageTree.olderThan(8));

		System.out.printf("\n TEST07 - Testing find() with 15 \n");
		System.out.println(" " + ageTree.find(new AgeData(15)).toString());
		System.out.printf("\n %s \n", ageTree.toString());

		System.out.printf("\n TEST08 - Testing remove() with 15 \n");
		ageTree.remove(new AgeData(15));
		System.out.printf("\n %s \n", ageTree.toString());

		System.out.printf("\n TEST09 - Testing remove() with 15 \n");
		ageTree.remove(new AgeData(15));
		System.out.printf("\n %s \n", ageTree.toString());
		
	}

}
