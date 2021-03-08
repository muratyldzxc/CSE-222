package cse22.hw5.part3;

public interface SearchTree<E> {
	/**
	 * Adds item
	 * @param item will be added
	 * @return true if successfully added, otherwise false
	 */
	public boolean add(E item);

	/**
	 * Check target if it is in tree or not
	 * @param target will be checked
	 * @return if it is in tree returns true , otherwise false
	 */
	public boolean contains(E target);

	/**
	 * Check target if it is in tree or not
	 * @param target will be checked
	 * @return if it is in tree returns object , otherwise null
	 */
	public E find(E target);

	/**
	 * Delete given object from tree
	 * @param target will be deleted
	 * @return deleted object
	 */
	public E delete(E target);

	/**
	 * Remove given object from tree
	 * @param target will be removed
	 * @return true if it is removed successfully, otherwise false
	 */
	public boolean remove(E target);
	
}
