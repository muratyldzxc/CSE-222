import java.util.Scanner;
import cse222.hw5.part2.*;
public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.printf("\n TEST01 - Testing ExpressionTree() constructor with null \n");
		try{
			ExpressionTree e = new ExpressionTree((String) null);
		}catch (Exception e){
			System.out.printf("\n %s \n", e.toString());
		}

		System.out.printf("\n TEST02 - Testing ExpressionTree() constructor with prefix expression \n " +
				" (/ 64 * 8 + 1 3) \n");
		ExpressionTree e = new ExpressionTree("/ 64 * 8 + 1 3");

		System.out.printf("\n TEST03 - Testing toString() which uses preOrderTraverse \n");
		System.out.printf("\n%s\n", e.toString());

		System.out.printf("\n TEST04 - Testing eval() \n");
		System.out.printf("\n RESULT: %d\n", e.eval());


		System.out.printf("\n TEST05 - Testing ExpressionTree() constructor with postfix expression \n " +
				" (+ + 10 * 5 15 20) \n");
		ExpressionTree e1 = new ExpressionTree("10 5 15 * + 20 +");

		System.out.printf("\n TEST06 - Testing toString() which uses preOrderTraverse \n");
		System.out.printf("\n%s\n", e1.toString());

		System.out.printf("\n TEST07 - Testing eval() \n");
		System.out.printf("\n RESULT: %d\n", e1.eval());

		System.out.printf("\n TEST08 - Testing toString2() which uses postOrderTraverse \n");
		System.out.printf("\n%s\n", e1.toString2());



	}

}
