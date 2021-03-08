import java.util.Stack;

public class DriverClass {

	public static void main(String[] args) {

		String str = null;

		System.out.println("\n TEST01 - reverseString(str) , when str is null\n" );
		try{
			System.out.println( reverseString(str) + "\n" );
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.println("\n TEST02 - reverseString(str)\n" );
		str = "This is a test for CSE 222 homework";
		System.out.println( reverseString(str) );

		str = null;
		System.out.println("\n TEST03 - isElfish(str) , when str is null\n" );
		try{
			System.out.println( isElfish(str) + "\n" );
		}catch (Exception e){
			System.out.println(e);
		}

		str = "whiteleaf";
		System.out.printf("\n TEST04 - isElfish(str), str = %s , Returned: %b\n", str, isElfish(str) );

		str = "whiteeeaf";
		System.out.printf("\n TEST05 - isElfish(str), str = %s , Returned: %b\n", str, isElfish(str) );


		int []arr = {3,7,0,6,13,3,1,8,19,4};
		System.out.printf("\n TEST06 - selectionSort(arr), \n arr = " );
		for (int i=0; i< arr.length; i++){
			System.out.printf("%d, ", arr[i]);
		}
		System.out.printf("\n After selectionSort(arr), \n arr = " );
		selectionSort(arr);
		for (int i=0; i< arr.length; i++){
			System.out.printf("%d, ", arr[i]);
		}

		String strPostfix = "20 15 2 6 * - 3 / + 8 + 16 4 / -";
		String strPrefix =  "+ 20 + / - 15 * 2 6 3 - 8 / 16 4";

		System.out.printf("\n\n TEST07 - evaluatePostfix(strPostfix), strPostfix = %s ",strPostfix );
		System.out.printf("\n Result: %f", evaluatePostfix(strPostfix));

		System.out.printf("\n\n TEST08 - evaluatePrefix(strPrefix), strPrefix = %s ",strPrefix );
		System.out.printf("\n Result: %f", evaluatePrefix(strPrefix));

		strPostfix = strPrefix = null;
		System.out.println("\n\n TEST09 - evaluatePostfix(strPostfix) , when strPostfix is null\n" );
		try{
			System.out.println( evaluatePostfix(strPostfix) + "\n" );
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.println("\n TEST10 - evaluatePrefix(strPrefix) , when strPrefix is null\n" );
		try{
			System.out.println( evaluatePrefix(strPrefix) + "\n" );
		}catch (Exception e){
			System.out.println(e);
		}

		System.out.printf("\n\n TEST11 - printMatrixInSpiralWay(arr1, 0) \n");

		int [][]arr1 = { { 1, 2, 3, 4},
						{ 5, 6, 7, 8},
						{ 9,10,11,12},
						{13,14,15,16},
						{17,18,19,20}	};

		printMatrixInSpiralWay(arr1, 0);

		System.out.printf("\n\n TEST12 - printMatrixInSpiralWay(arr2, 0) \n");
		int [][]arr2 = {{1,2,3}};
		printMatrixInSpiralWay(arr2, 0);

		System.out.printf("\n\n TEST13 - printMatrixInSpiralWay(arr3, 0) \n");
		int [][]arr3 = {{1},{2},{3}};
		printMatrixInSpiralWay(arr3, 0);

		System.out.printf("\n\n TEST14 - printMatrixInSpiralWay(arr4, 0) \n");
		int [][]arr4 = {{1,2,3}, {3,4,5}};
		printMatrixInSpiralWay(arr4, 0);

		System.out.printf("\n\n TEST15 - printMatrixInSpiralWay(arr5, 0) \n");
		int [][]arr5 = {{1,2},{3,4},{5,6}};
		printMatrixInSpiralWay(arr5, 0);

		System.out.printf("\n\n TEST16 - printMatrixInSpiralWay(arr6, 0) \n");
		int [][]arr6 = {
						{1,2,3,4,5},
						{6,7,8,9,10},
						{11,12,13,14,15},
						{16,17,18,19,20},
						{21,22,23,24,25}	};
		printMatrixInSpiralWay(arr6, 0);


	}

	/**
	 * Reverse string order word by word
	 * @param str the string will be reversed word by word
	 * @return reversed string word by word
	 * @throws NullPointerException if str is null
	 */
	public static String reverseString( String str )throws NullPointerException {

		if( str.indexOf(" ") == -1 )
			return str;

		String splitStr = str.substring(0,str.indexOf(" "));
		str = str.substring(str.indexOf(" ") + 1 );

		return reverseString(str) + " " + splitStr ;
	}

	/**
	 * Checks a word is elfish or not, if it is returns true, otherwise false
	 * @param word the word will be checked
	 * @return if it is elfish returns true, otherwise false
	 * @throws NullPointerException if word is null
	 */
	public static boolean isElfish( String word)throws NullPointerException {
		String isElfish = new String();
		return isElfishHelper( word.substring(1), isElfish);
	}

	/**
	 * Checks a word is elfish or not, if it is returns true, otherwise false
	 * <p> it is a helper function to hide some details from user
	 * @param word the word will be checked
	 * @param isElfish to check the word
	 * @return  if it is elfish returns true, otherwise false
	 * @throws NullPointerException if word is null
	 */
	public static boolean isElfishHelper( String word, String isElfish)throws NullPointerException {

		if( isElfish.length() == 3 )
			return true;
		if( word.isEmpty() )
			return false;
		if( word.charAt(0) == 'e' && !isElfish.contains("e")){
			isElfish += "e";
		}
		else if( word.charAt(0) == 'l' && !isElfish.contains("l") ){
			isElfish += "l";
		}
		else if( word.charAt(0) == 'f' && !isElfish.contains("f") ){
			isElfish += "f";
		}

		return isElfishHelper( word.substring(1), isElfish);
	}

	/**
	 * Sorts given array with selection sort
	 * @param arr array will be sorted
	 */
	public static void selectionSort(int arr[]){
		selectionSortHelper(arr, 0);
	}

	/**
	 * Sorts given array with selection sort
	 * <p> it is a helper function to hide some details from user
	 * @param arr array will be sorted
	 * @param startIndex holds index that will started to search
	 */
	public static void selectionSortHelper(int arr[], int startIndex){
		int minIndex;
		int temp;

		if( startIndex < arr.length){
			minIndex = findMinValueIndex(arr,startIndex);
			temp = arr[minIndex];
			arr[minIndex] = arr[startIndex];
			arr[startIndex] = temp;


			selectionSortHelper(arr, startIndex+1);
		}
	}

	/**
	 * Returns minimum value in that array from startIndex to arr.length-1
	 * @param arr array will be searched
	 * @param startIndex holds index that will started to search
	 * @return minimum value in that array from startIndex to arr.length-1
	 */
	public static int findMinValueIndex(int arr[], int startIndex){
		int minIndex;
		if( startIndex < arr.length-1){

			minIndex = findMinValueIndex(arr, startIndex+1);
			if( arr[startIndex] < arr[minIndex] )
				return startIndex;
			else
				return minIndex;
		}
		else{
			return startIndex;
		}
	}

	/**
	 * Evaluate a prefix expression
	 * @param expression given to evaluate
	 * @return result of given prefix expression
	 */
	public static double evaluatePrefix( String expression ){
		Stack <Double> stack = new Stack<Double>();

		return  evaluatePrefixHelper(expression, stack );
	}

	/**
	 * Evaluate a prefix expression
	 * <p> it is a helper function to hide some details from user
	 * @param expression given to evaluate
	 * @param stack to store evaluation data
	 * @return result of given prefix expression
	 */
	public static double evaluatePrefixHelper( String expression, Stack <Double> stack ){
		double leftOperand, rightOperand;
		int cursor = expression.lastIndexOf(' ');
		String token;

		if(cursor != -1)
			token = expression.substring(cursor+1, expression.length());
		else
			token = expression;

		if( token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") ) {
			switch (token) {
				case "+":
					leftOperand = stack.pop();
					rightOperand = stack.pop();
					stack.push(leftOperand + rightOperand);
					break;
				case "-":
					leftOperand = stack.pop();
					rightOperand = stack.pop();
					stack.push(leftOperand - rightOperand);
					break;
				case "*":
					leftOperand = stack.pop();
					rightOperand = stack.pop();
					stack.push(leftOperand * rightOperand);
					break;
				case "/":
					leftOperand = stack.pop();
					rightOperand = stack.pop();
					stack.push(leftOperand / rightOperand);
					break;
			}
		}
		else
			stack.push(Double.valueOf(token));

		if(cursor == -1)
			return stack.pop();

		return evaluatePrefixHelper(expression.substring(0, cursor), stack);
	}

	/**
	 * Evaluate a postfix expression
	 * @param expression given to evaluate
	 * @return result of given postfix expression
	 */
	public static double evaluatePostfix( String expression ){
		Stack <Double> stack = new Stack<Double>();

		return  evaluatePostfixHelper(expression, stack );
	}

	/**
	 * Evaluate a postfix expression
	 * <p> it is a helper function to hide some details from user
	 * @param expression given to evaluate
	 * @param stack to store evaluation data
	 * @return result of given postfix expression
	 */
	public static double evaluatePostfixHelper( String expression, Stack <Double> stack ){
		double leftOperand, rightOperand;
		int cursor = expression.indexOf(' ');
		String token;

		if(cursor != -1)
			token = expression.substring(0, cursor);
		else
			token = expression;

		if( token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") ) {
			switch (token) {
				case "+":
					rightOperand = stack.pop();
					leftOperand = stack.pop();
					stack.push(leftOperand + rightOperand);
					break;
				case "-":
					rightOperand = stack.pop();
					leftOperand = stack.pop();
					stack.push(leftOperand - rightOperand);
					break;
				case "*":
					rightOperand = stack.pop();
					leftOperand = stack.pop();
					stack.push(leftOperand * rightOperand);
					break;
				case "/":
					rightOperand = stack.pop();
					leftOperand = stack.pop();
					stack.push(leftOperand / rightOperand);
					break;
			}
		}
		else
			stack.push(Double.valueOf(token));

		if(cursor == -1)
			return stack.pop();

		return evaluatePostfixHelper(expression.substring(cursor+1), stack);
	}

	/**
	 * Prints matrix in spiral way
	 * @param arr matrix will be printed
	 * @param count Holds which layer to be printed
	 */
	public static void printMatrixInSpiralWay(int [][] arr, int count ){
		int minEdge = arr.length < arr[0].length ? arr.length : arr[0].length;
		minEdge = minEdge == 1 ? 2 : minEdge;

		if( !(minEdge > power(2, count) ))
			return;

		printLayer(arr, count, count, count);
		printMatrixInSpiralWay(arr, ++count);
	}

	/**
	 * It is a basic power function( equals to Math.pow)
	 * @param base base to be cofactor
	 * @param exp  exp to be how many times multiply cofactor
	 * @return exp times multiply cofactor
	 */
	public static int power(int base, int exp){
		if( exp == 0)
			return 1;
		return (base * power(base, --exp));
	}

	/**
	 * Prints matrix in spiral way
	 * <p> it is a helper function to hide some details from user
	 * @param arr matrix will be printed
	 * @param rowPosition row of which value will be printed
	 * @param colPosition column of which value will be printed
	 * @param count Holds which layer to be printed
	 */
	public static void printLayer(int [][] arr, int rowPosition, int colPosition, int count ) {
		int rowBorder = arr.length - count;
		int colBorder = arr[0].length - count;

		System.out.print(arr[rowPosition][colPosition] + ", ");

		if ((arr.length==1 && colPosition == colBorder-1) || (arr[0].length==1 && rowPosition == rowBorder-1))
			return;

		if( colPosition < colBorder-1 && rowPosition == count)
			colPosition++;
		else if( rowPosition < rowBorder-1 && colPosition == colBorder-1)
			rowPosition++;
		else if(  colPosition > count && rowPosition == rowBorder-1)
			colPosition--;
		else if( rowPosition > count && colPosition == count)
			rowPosition--;

		if( !(rowPosition == count && colPosition == count) )
			printLayer(arr, rowPosition, colPosition, count);
	}

	

}
