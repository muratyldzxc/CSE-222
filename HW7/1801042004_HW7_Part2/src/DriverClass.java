import cse222.hw7.part2.*;

import java.util.Random;
import java.util.Scanner;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		
		System.out.printf("\n Please enter maximum size(order) of array:  ");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		SkipList<Integer> test = new SkipList<Integer>(size);

		System.out.printf("\n After add 50 random (0-100) element \n");
		
		for(int i=0; i<50;i++)
			test.add(rand.nextInt(100));



		System.out.print("\n" +test.toString());
		
		for(int i=0; i<50;i++)
			test.add(rand.nextInt(100));
		
		int temp ;
		for(int i=0; i<5;i++) {
			temp = rand.nextInt(100);
			System.out.printf("\n Before add " + temp);
			System.out.print("\n" +test.toString());
			
			test.add(temp);
			
			System.out.printf("\n\n After add " + temp);
			System.out.print("\n" +test.toString());
			
		}
			
		sc.close();	

	}

}
