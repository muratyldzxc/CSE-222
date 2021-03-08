package cse222.hw7.part4;


/**
 * Holds information about a Software Store
 */
public class SoftwareStore {
	/**
	 * Holds software packages in a Software Store
	 */
	private SearchTree<SoftwarePackage> softwarePackages;
	/**
	 * Holds Administrator of Software Store
	 */
	private Administrator admin;

	/**
	 * Create a Software Store object with given parameter
	 * @param softwarePackages will be set
	 */
	public SoftwareStore(SearchTree<SoftwarePackage> softwarePackages) {
		this.softwarePackages = softwarePackages;
		this.admin = new Administrator("1234");
		admin.addSoftwarePackage(new SoftwarePackage("Adobe Photoshop 6.0", 10, 25.0));
		admin.addSoftwarePackage(new SoftwarePackage("Adobe Photoshop 6.2", 10, 35.0));
		admin.addSoftwarePackage(new SoftwarePackage("Norton 4.5", 10, 45.0));
		admin.addSoftwarePackage(new SoftwarePackage("Norton 5.5", 10, 55.0));
		admin.addSoftwarePackage(new SoftwarePackage("Adobe Flash 3.3", 10, 65.0));
		admin.addSoftwarePackage(new SoftwarePackage("Adobe Flash 4.0", 10, 75.0));
	}

	/**
	 * Holds information about administrator of Software Store
	 */
	public class Administrator{
		/**
		 * Holds password needed to login
		 */
		String password;

		/**
		 * Create an Administrator object with given password
		 * @param password will be set
		 */
		public Administrator(String password) {

			this.password = password;
		}

		/**
		 * Add a Software Package to the system (if it is already added, it replace it)
		 * @param sp will be added
		 * @return true if sp is added, otherwise false
		 */
		public boolean addSoftwarePackage(SoftwarePackage sp) {
			SoftwarePackage temp = softwarePackages.find(sp);

			if ( temp == null )
				return softwarePackages.add(sp);
			else{
				temp.price = sp.price;
				temp.quantity = sp.quantity;
			}
			return true;
		}

		/**
		 * Remove a Software Package from the system (if it is exist at the store)
		 * @param sp will be removed
		 * @return true if sp is removed, otherwise false
		 */
		public boolean removeSoftwarePackage(SoftwarePackage sp) {
			return softwarePackages.remove(sp);
		}

		/**
		 * Update quantity of a software package at the system
		 * @param sp will be searched and updated
		 * @return false if store doesnt have it, otherwise true
		 */
		public boolean updateSoftwarePackageQuantity(SoftwarePackage sp) {
			SoftwarePackage temp;

			if (sp.quantity == 0)
				softwarePackages.remove(sp);
			else{
				temp = softwarePackages.find(sp);
				if (temp == null)
					return false;
				temp.quantity = sp.quantity;
			}
			
			return true;
		}

		/**
		 * Update quantity of a software package at the system
		 * @param sp will be searched and updated
		 * @return false if store doesnt have it, otherwise true
		 */
		public boolean updateSoftwarePackagePrice(SoftwarePackage sp) {
			SoftwarePackage temp = softwarePackages.find(sp);

			if(temp == null)
				return false;

			temp.price = sp.price;
			return true;
		}

	}

	/**
	 * Returns software package which found by given parameter
	 * @param sp will be searched for
	 * @return software package which found by given parameter, if not found  return null
	 */
	public SoftwarePackage searchSoftwarePackages(String sp) {
		SoftwarePackage search = new SoftwarePackage(sp, 0, 0.0);
		
		SoftwarePackage temp = softwarePackages.find(search);
		
		if(temp == null)
			return null;
		
		return temp;
	}

	/**
	 * Returns Admin if matchs with given password
	 * @param pw will be checked
	 * @return Admin if matchs with given password, otherwise null
	 */
	public Administrator enterAsAdministrator(String pw) {
		if(admin.password.equals(pw))
			return admin;
		
		return null;
	}

}
