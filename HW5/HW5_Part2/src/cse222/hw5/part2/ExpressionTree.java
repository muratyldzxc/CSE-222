package cse222.hw5.part2;

import java.util.Scanner;

/**
 * Holds expressions
 */
@SuppressWarnings("serial")
public class ExpressionTree extends BinaryTree<String>{

    /**
     * Create an expression tree according to  given expression
     * @param expression will be created from
     * @throws NullPointerException if parameter is null
     */
    public ExpressionTree(String expression){
        if (expression == null)
            throw new NullPointerException();

        Scanner sc = new Scanner(expression);
        this.root = readBinaryTree( sc ).root;
        sc.close();
    }

    /**
     * Set given node  as root
     * @param root will be set
     */
    public ExpressionTree(Node<String> root){
        this.root = root;
    }

    /**
     * Read data from scanner to ExpressionTree
     * @param scan scanner will be read from
     * @return return an ExpressionTree created by reading scanner
     */
    public static ExpressionTree readBinaryTree(Scanner scan){
        String str = scan.nextLine();
        scan = new Scanner(str);
        str = str.substring(0, str.indexOf(" "));

        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
            return new ExpressionTree(readPreFix(scan));
        else{
            Integer.parseInt(str); // if it is not an integer throw exception
            return new ExpressionTree(readPostFix(scan));
        }
    }

    /**
     * A helper function for eval function
     * @param root current node
     * @return result of expression
     */
    public int evalHelper(Node<String> root){

        if (root.data.equals("+") || root.data.equals("-") || root.data.equals("/") || root.data.equals("*")) {
            switch (root.data) {
                case "+":
                    return evalHelper(root.left) + evalHelper(root.right);
                case "-":
                    return evalHelper(root.left) - evalHelper(root.right);
                case "/":
                    return evalHelper(root.left) / evalHelper(root.right);
                case "*":
                    return evalHelper(root.left) * evalHelper(root.right);
                default:
                    return 0;
            }
        }
        else
            return Integer.parseInt(root.data);
    }

    /**
     * Returns evaluation of the expression
     * @return result of the expression
     * @throws NullPointerException if root is null
     */
    public int eval(){
        if (root == null)
            throw new NullPointerException();
        return evalHelper(root);
    }

    /** Converts a subtree to a string.
     * Performs a preorder traversal.
     * @param node The local root
     *  @param depth The depth
     *  @param sb The StringBuilder to save the output
     */
    private void postOrderTraverse(Node<String> node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        }
        else {
            postOrderTraverse(node.left, depth + 1, sb);
            postOrderTraverse(node.right, depth + 1, sb);
            sb.append(node.toString());
            sb.append("\n");
        }
    }

    /**
     * Returns expression tree in pre order travers as a string
     * @return expression tree in pre order travers as a string
     */
    public String toString2() {
        StringBuilder sb = new StringBuilder();
        postOrderTraverse(root, 1, sb);
        return sb.toString();
    }


    /**
     * Read postfix expression
     * @param scan will be readed
     * @return if scan is null returns null, if not returns a root node of an constructed expression tree
     */
    private static Node<String> readPostFix(Scanner scan){
        String reverse = "";
        Node<String> node = null;

        while ( scan.hasNext() )
            reverse = scan.next() + " " + reverse;
        reverse = reverse.substring(0, reverse.length()-1);

        return readPostFixHelper(new Scanner(reverse));
    }

    /**
     * A helper function for readPostfix
     * @param scan will be readed
     * @return if scan is null returns null, if not returns a root node of an constructed expression tree
     */
    private static Node<String> readPostFixHelper(Scanner scan){
        String str;
        boolean checkData;
        if (!scan.hasNext())
            return null;

        str = scan.next();
        checkData = checkData(str);

        if(!checkData)
            throw new NumberFormatException();

        Node<String> root = new Node<String>(str);

        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
            root.right = readPostFixHelper(scan);
            root.left = readPostFixHelper(scan);
        }
        return  root;
    }


    /**
     * Read prefix expression
     * @param scan will be readed
     * @return if scan is null returns null, a root node of an constructed expression tree
     */
    private static Node<String> readPreFix(Scanner scan){
        String str ;
        boolean checkData ;
        if (!scan.hasNext())
            return null;

        str = scan.next();
        checkData = checkData(str);

        if(!checkData)
            throw new NumberFormatException();

        Node<String> root = new Node<String>(str);

        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
            root.left = readPreFix(scan);
            root.right = readPreFix(scan);
        }

        return root;
    }

    /**
     * Check data is valid or not
     * @param data will be checked
     * @return true if it is valid , otherwise false
     * @throws NullPointerException if parameter is null
     */
    public static boolean checkData(String data){
        if (data == null)
            throw new NullPointerException();
        if(data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/"))
            return true;
        try{
            Integer.parseInt(data);
        }catch (Exception e){
            return  false;
        }
        return  true;
    }

}
