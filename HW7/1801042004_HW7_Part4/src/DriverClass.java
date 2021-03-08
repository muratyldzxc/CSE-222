import cse222.hw7.part4.*;

import java.util.Scanner;

public class DriverClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SearchTree<SoftwarePackage> softwarePackages = new BinarySearchTree<SoftwarePackage>();
		SoftwareStore store = new SoftwareStore(softwarePackages);
		int choice;
		boolean exit = false;

		do {
			System.out.printf("\n\n Welcome to Software Store \n\n");
			System.out.printf("\n 1- Login as Administrator \n");
			System.out.printf("\n 2- Search by name\n");
			System.out.printf("\n 3- Exit\n");
			System.out.printf("\n Your choice: ");

			choice = sc.nextInt();

			switch (choice) {
				case 1:
					System.out.printf("\n Please enter administrator password:  ");
					String password = sc.next();
					SoftwareStore.Administrator admin = store.enterAsAdministrator(password);

					if (admin != null) {
						System.out.printf("\n\n Select an operaton as Administrator \n\n");
						System.out.printf("\n 1- Add software package \n");
						System.out.printf("\n 2- Remove software package \n");
						System.out.printf("\n 3- Update a software package's quantity \n");
						System.out.printf("\n 4- Update a software package's price \n");
						System.out.printf("\n 5- Return main menu \n");
						System.out.printf("\n Your choice: ");

						choice = sc.nextInt();
						String name;
						int quantity;
						double price;
						SoftwarePackage tempSoftware;

						switch (choice) {
							case 1:
								System.out.printf("\n Please enter name of the software package you want to add: ");
								sc.nextLine();
								name = sc.nextLine();
								System.out.printf("\n Please enter quantity of the software package you want to add: ");
								quantity = sc.nextInt();
								System.out.printf("\n Please enter price of the software package you want to add: ");
								price = sc.nextDouble();
								admin.addSoftwarePackage(new SoftwarePackage(name, quantity, price));
								break;
							case 2:
								System.out.printf("\n Please enter name of the software package you want to delete: ");
								sc.nextLine();
								name = sc.nextLine();
								if (!admin.removeSoftwarePackage(new SoftwarePackage(name, 0, 0.0)))
									System.out.printf("\n There is no software package in that name at the store\n");
								break;
							case 3:
								System.out.printf("\n Please enter name of the software package you want to update its quantity : ");
								sc.nextLine();
								name = sc.nextLine();
								tempSoftware = store.searchSoftwarePackages(name);
								if (tempSoftware == null)
									System.out.printf("\n There is no software package in that name at the store\n");
								else {
									System.out.print("\n Found: " + tempSoftware);
									System.out.printf("\n Please enter new quantity of the software package you want to update : ");
									quantity = sc.nextInt();
									admin.updateSoftwarePackageQuantity(new SoftwarePackage(name, quantity, 0.0));
								}
								break;
							case 4:
								System.out.printf("\n Please enter name of the software package you want to update its price : ");
								sc.nextLine();
								name = sc.nextLine();
								tempSoftware = store.searchSoftwarePackages(name);
								if (tempSoftware == null)
									System.out.printf("\n There is no software package in that name at the store\n");
								else {
									System.out.print("\n Found: " + tempSoftware);
									System.out.printf("\n Please enter new price of the software package you want to update : ");
									price = sc.nextDouble();
									admin.updateSoftwarePackagePrice(new SoftwarePackage(name, 0, price));
								}
								break;
							case 5:
								System.out.printf("\n Returninng to main menu\n");
								break;
							default:
								System.out.printf("\n\n You entered an invalid choice \n\n");
						}

					} else
						System.out.printf("\n\n You entered an invalid password \n\n");
					break;
				case 2:
					System.out.printf("\n Please enter name of the software package you want to search : ");
					sc.nextLine();
					String tempName = sc.nextLine();
					SoftwarePackage tempSoftware = store.searchSoftwarePackages(tempName);
					if (tempSoftware == null)
						System.out.printf("\n There is no software package in that name at the store\n");
					else
						System.out.print(tempSoftware);
					break;
				case 3:
					System.out.printf("\n\n Exiting the program... \n\n");
					exit = true;
					break;
				default:
					System.out.printf("\n\n You entered an invalid choice \n\n");
			}

		}while(!exit);
		
		sc.close();
	}
}
