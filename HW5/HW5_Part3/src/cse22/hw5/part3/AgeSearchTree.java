package cse22.hw5.part3;

/**
 * A Binary search tree according to age
 */
@SuppressWarnings("serial")
public class AgeSearchTree extends BinarySearchTree<AgeData>{

	/**
	 * Create AgeSearchTree
	 */
	public AgeSearchTree(){
		root = null;
	}

	/**
	 * If item is already exist increment the numberOfPeople has that item, if not add item
	 * @param item will be added
	 * @return true if successfully added otherwise false
	 * @throws NullPointerException if parameter is null
	 */
	@Override
	public boolean add(AgeData item) {
		if (item == null)
			throw new NullPointerException();

		AgeData temp = find(item);
		if(temp != null)
			temp.numberOfPeople++;
		else
			return super.add(item);

		return true;
	}

	/**
	 * If items numberOfPeople more than 1 decrement numberOfPeople, if not remove item
	 * @param target will be removed
	 * @return true if successfully removed otherwise false
	 * @throws NullPointerException if parameter is null
	 */
	@Override
	public boolean remove(AgeData target) {
		if (target == null)
			throw new NullPointerException();

		AgeData temp = find(target);
		if(temp != null){
			if(temp.numberOfPeople == 1)
				return super.remove(target);
			else {
				temp.numberOfPeople--;
				return true;
			}

		}
		return false;
	}

	/**
	 * A helper function for youngerThan function, Returns how many young people are there than given age
	 * @param age will be compared
	 * @param root will checked
	 * @return how many young people are there than given age
	 */
	private  int youngerThanHelper(int age, Node<AgeData> root){
		if(root == null)
			return 0;

		int state = root.data.compareTo(new AgeData(age));

		if ( state == 0 )
			return youngerThanHelper(age, root.left);
		else if( state == 1)
			return youngerThanHelper(age, root.left);
		else
			return root.data.numberOfPeople + youngerThanHelper(age, root.left) + youngerThanHelper(age, root.right);

	}

	/**
	 * Returns how many young people are there than given age
	 * @param age will be compared
	 * @return how many young people are there than given age
	 */
	public int youngerThan(int age){
		return youngerThanHelper(age, this.root);
	}

	/**
	 * A helper function for youngerThan function, Returns how many old people are there than given age
	 * @param age will be compared
	 * @param root will checked
	 * @return how many old people are there than given age
	 */
	private int olderThanHelper(int age, Node<AgeData> root){
		if(root == null)
			return 0;

		int state = root.data.compareTo(new AgeData(age));

		if ( state == 0 )
			return olderThanHelper(age, root.right);
		else if( state == 1)
			return root.data.numberOfPeople + olderThanHelper(age, root.left) + olderThanHelper(age, root.right);
		else
			return olderThanHelper(age, root.left) ;
	}

	/**
	 * Returns how many old people are there than given age
	 * @param age will be compared
	 * @return how many old people are there than given age
	 */
	public int olderThan(int age){
		return olderThanHelper(age, this.root);
	}

	/**
	 * Search for target in tree
	 * @param target will be checked
	 * @return if it is found returns object, otherwise null
	 * @throws NullPointerException if parameter is null
	 */
	public AgeData find(AgeData target){
		if(target == null)
			throw new NullPointerException();

		return super.find(target);
	}
}
