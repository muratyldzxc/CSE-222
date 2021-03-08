import gtu.cargo.company.*;
import gtu.cargo.company.Shipment.CargoState;
import java.util.Scanner;
public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int choice ;
		boolean checked = false, backToMenu = false, exitProgram = false ;
		String ID, password ;
		Scanner inputConsole = new Scanner ( System.in );
		
		CargoCompany GTUcargo = new CargoCompany();
		Administrator admin = new Administrator("name","surname","admin","1234");

		GTUcargo.addAdministrator(admin);
		//TransportationPersonnel transPersonel = new TransportationPersonnel("kemal", "yilmaz", "1515", "1414");
		/*
		Customer CS, CR ;
		CS = new Customer("murat","yildiz","unik");
		CR = new Customer("kurat","kildiz", "unik2");
		
		Branch B = new Branch("kartal","1515");
		Shipment element = new Shipment( 1234, CargoState.ArriveAtBranch, CR, CS, B );
		BranchEmployee BE = new BranchEmployee("sana","bana","bisey","olabilir", B);
		//shipments.insert(element);
		*/
		
		do {
			backToMenu = false ;
			System.out.printf("\n\n Welcome to Cargo company user interface \n\n");
			System.out.printf("\n Please select a choice to continue \n");
			System.out.printf("\n Proceed as: \n\n"
					+ " 1- Administrator\n" 
					+ " 2- Branch Employee\n" 
					+ " 3- Transporter Personnel\n" 
					+ " 4- Customer\n"
					+ " 0- Exit Program\n");
			
			System.out.printf("\n Selected choice: ");
			choice = inputConsole.nextInt();
			
			switch( choice ){
			
				case 1 : {
					Administrator tempAdmin;

					checked = false;
					System.out.printf("\n\n You selected to proceed as an Administrator\n ");
					System.out.printf("\n Please enter your ID: ");
					ID = inputConsole.next();
					System.out.printf("\n Please enter your password: ");
					password = inputConsole.next();
					tempAdmin = GTUcargo.getAdministrator(ID, password);

					if (tempAdmin != null)
						checked = true;
					do {
						if (checked) {
							System.out.printf("\n\n Please select an operation to continue: \n\n"
									+ " 1- Add Branch\n"
									+ " 2- Remove Branch\n"
									+ " 3- Add Branch Employee\n"
									+ " 4- Remove Branch Employee\n"
									+ " 5- Add Transporter Personnel\n"
									+ " 6- Remove Transporter Personnel\n"
									+ " 0- To go back Menu\n");

							System.out.printf("\n Selected choice: ");
							choice = inputConsole.nextInt();

							switch (choice) {
								case 1: {
									backToMenu = false;
									String tempName, tempID;
									boolean tempChecked = false;

									System.out.printf("\n\n Please enter name for new branch: ");
									tempName = inputConsole.next();
									System.out.printf("\n\n Please enter ID for new branch: ");
									tempID = inputConsole.next();
									tempChecked = GTUcargo.checkBranchID(tempID);

									if (tempChecked)
										System.out.printf("\n\n There is a branch with that ID : %s \n", tempID);

									if (!tempChecked) {
										Branch tempBranch = new Branch(tempName, tempID);
										if (tempAdmin.addBranch(tempBranch))
											System.out.printf("\n\n Branch with ID : %s  successfully added \n", tempID);
										System.out.println(admin.getBranchs().toString());
									}
								}
								break;
								case 2: {
									String tempID;
									System.out.printf("\n\n Please enter ID of branch to be deleted: ");
									tempID = inputConsole.next();

									if (tempAdmin.deleteBranch(tempID))
										System.out.printf("\n\n Branch with ID : %s  successfully removed \n", tempID);
									else
										System.out.printf("\n\n There is no branch with ID : %s  " +
												"or you are not authorized to delete that branch\n", tempID);

									System.out.println(admin.getBranchs().toString());
								}
								break;
								case 3: {
									String tempName, tempID, tempSurname, tempPassword, tempBranchID;
									Branch tempBranch;
									boolean tempChecked = false;

									System.out.printf("\n\n Please enter name for new branch employee: ");
									tempName = inputConsole.next();
									System.out.printf("\n\n Please enter surname for new branch employee: ");
									tempSurname = inputConsole.next();
									System.out.printf("\n\n Please enter ID for new branch employee: ");
									tempID = inputConsole.next();
									tempChecked = tempAdmin.checkBranchEmployeeID(tempID);

									if (tempChecked)
										System.out.printf("\n\n There is someone with that ID : %s \n", tempID);

									if (!tempChecked) {
										System.out.printf("\n\n Please enter password for new branch employee: ");
										tempPassword = inputConsole.next();
										System.out.printf("\n\n Please enter Branch ID which new branch employee belongs to: ");
										tempBranchID = inputConsole.next();
										tempBranch = admin.getBranch(tempBranchID);
										if (tempBranch != null) {
											BranchEmployee tempBE = new BranchEmployee(tempName, tempSurname, tempID, tempPassword, tempBranch);
											tempAdmin.addBranchEmployee(tempBE);
										} else
											System.out.printf("\n\n There is no Branch with that ID: %s ", tempBranchID);
									}
									System.out.println(admin.getBranchEmployees().toString());
								}
								break;
								case 4: {
									String tempID;
									System.out.printf("\n\n Please enter ID of branch employee to be deleted: ");
									tempID = inputConsole.next();

									if (tempAdmin.deleteBranchEmployee(tempID))
										System.out.printf("\n\n Branch employee with ID : %s  successfully removed \n", tempID);
									else
										System.out.printf("\n\n There is no branch employee with ID : %s  " +
												"or you are not authorized to delete that branch employee\n", tempID);
									System.out.println(admin.getBranchEmployees().toString());
								}
								break;
								case 5: {
									String tempName, tempSurname, tempID, tempPassword;
									boolean tempChecked = false;

									System.out.printf("\n\n Please enter name for new Transportation Personnel: ");
									tempName = inputConsole.next();
									System.out.printf("\n\n Please enter surname for new Transportation Personnel: ");
									tempSurname = inputConsole.next();
									System.out.printf("\n\n Please enter ID for new Transportation Personnel: ");
									tempID = inputConsole.next();
									tempChecked = tempAdmin.checkTransportationPersonelID(tempID);

									if (tempChecked)
										System.out.printf("\n\n There is someone with that ID : %s \n", tempID);

									if (!tempChecked) {
										System.out.printf("\n\n Please enter password for new Transportation Personnel: ");
										tempPassword = inputConsole.next();
										TransportationPersonnel tempTP = new TransportationPersonnel(tempName, tempSurname, tempID, tempPassword);
										tempAdmin.addTransportationPersonel(tempTP);
									}
									System.out.println(admin.getTransportationPersonnel().toString());
								}
								break;
								case 6: {
									String tempID;

									System.out.printf("\n\n Please enter ID of Transportation Personnel to be deleted: ");
									tempID = inputConsole.next();

									if (tempAdmin.deleteTransportationPersonel(tempID))
										System.out.printf("\n\n Transportation Personnel with ID : %s  successfully removed \n", tempID);
									else
										System.out.printf("\n\n There is no Transportation Personnel with ID : %s  " +
												"or you are not authorized to delete that Transportation Personnel\n", tempID);
									System.out.println(admin.getTransportationPersonnel().toString());
								}
								break;
								case 0:
									System.out.printf("\n Going back to Menu\n ");
									backToMenu = true;
									break;
								default:
									System.out.printf("\n You entered an invalid operation\n ");
							}
						} else {
							System.out.printf("\n\n Information ID and password does not match any admin in the system\n\n ");
							backToMenu = true;
						}

					} while (!backToMenu);
				}
					break;
				case 2 : {
					checked = false;
					BranchEmployee tempBE;

					System.out.printf("\n\n You selected to proceed as a Branch Employee\n ");
					System.out.printf("\n Please enter your ID: ");
					ID = inputConsole.next();
					System.out.printf("\n Please enter your password: ");
					password = inputConsole.next();

					tempBE = GTUcargo.getBranchEmployee(ID, password);
					if (tempBE != null)
						checked = true;
					do {
						if (checked) {
							System.out.printf("\n\n Please select an operation to continue: \n\n"
									+ " 1- Add Customer\n"
									+ " 2- Remove Customer\n"
									+ " 3- Add Shipment\n"
									+ " 4- Remove Shipment\n"
									+ " 5- Change a Shipment's statu\n"
									+ " 0- To go back Menu\n");

							System.out.printf("\n Selected choice: ");
							choice = inputConsole.nextInt();

							switch (choice) {
								case 1: {
									String tempName, tempSurname, tempID;
									boolean tempChecked = false;
									System.out.printf("\n\n Please enter name for new customer: ");
									tempName = inputConsole.next();

									System.out.printf("\n\n Please enter surname for new customer: ");
									tempSurname = inputConsole.next();

									System.out.printf("\n\n Please enter ID for new customer: ");
									tempID = inputConsole.next();
									tempChecked = GTUcargo.checkCustomerID(tempID);

									if (tempChecked) {
										System.out.printf("\n\n There is someone with that ID : %s \n", tempID);
										backToMenu = true;
									}
									if (!tempChecked) {
										Customer tempCustomer = new Customer(tempName, tempSurname, tempID);
										tempBE.addCustomer(tempCustomer);
									}
									System.out.println(tempBE.getCurrentBranch().getCustomers().toString());
								}
								break;
								case 2: {
									String tempID;
									System.out.printf("\n\n Please enter ID of customer to be deleted: ");
									tempID = inputConsole.next();

									if (tempBE.deleteCustomer(tempID))
										System.out.printf("\n\n Customer with ID : %s  successfully removed \n", tempID);
									else {
										System.out.printf("\n\n There is no customer with ID : %d  or you are not authorized to delete that customer\n", tempID);
										backToMenu = true;
									}
									System.out.println(tempBE.getCurrentBranch().getCustomers().toString());
								}
								break;
								case 3: {
									int tempTrackID;
									Shipment tempShipment;
									Customer receiver, sender;
									String receiverID, senderID;

									System.out.printf("\n\n Please enter track ID of shipment to be added: ");
									tempTrackID = inputConsole.nextInt();
									tempShipment = GTUcargo.getShipment(tempTrackID);

									if (tempShipment == null) {
										System.out.printf("\n\n Please enter ID of sender to be added: ");
										senderID = inputConsole.next();
										sender = GTUcargo.getCustomer(senderID);

										System.out.printf("\n\n Please enter ID of receiver to be added: ");
										receiverID = inputConsole.next();
										receiver = GTUcargo.getCustomer(receiverID);

										tempShipment = new Shipment(tempTrackID, CargoState.ArriveAtBranch, receiver, sender, tempBE.getCurrentBranch());
										tempBE.addShipment(tempShipment);
									} else {
										System.out.printf("\n\n A shipment with that track ID: %d already exist.\n ", tempTrackID);
										backToMenu = true;
									}
									System.out.println(tempBE.getCurrentBranch().getShipments().toString());
								}
								break;
								case 4: {
									int tempTrackID;
									System.out.printf("\n\n Please enter track ID of shipment to be deleted: ");
									tempTrackID = inputConsole.nextInt();

									if (tempBE.deleteShipment(tempTrackID))
										System.out.printf("\n\n Shipment with track ID : %d  successfully removed \n", tempTrackID);
									else {
										System.out.printf("\n\n There is no shipment with track ID : %d or you are not authorized to delete that shipment\n", tempTrackID);
										backToMenu = true;
									}
									System.out.println(tempBE.getCurrentBranch().getShipments().toString());
								}
								break;
								case 5: {
									int tempTrackID;
									Shipment tempShipment;

									System.out.printf("\n\n Please enter track ID of shipment to be change its statue: ");
									tempTrackID = inputConsole.nextInt();

									tempShipment = GTUcargo.getShipment(tempTrackID);
									if (tempShipment != null)
										tempBE.updateShipmentAsBranchEmployee(tempShipment);
									else
										System.out.printf("\n\n There is no shipment with track ID : %d or you are not authorized to change statue of that shipment\n", tempTrackID);
								}
								break;
								case 0: {
									System.out.printf("\n Going back to Menu\n ");
									backToMenu = true;
								}
								break;
								default: {
									System.out.printf("\n\n You selected undefined process. Please select a valid process to continue ");
									backToMenu = true;
								}
								break;
							}

						} else {
							System.out.printf("\n\n Information you entered does not match with a Branch Employee. Please try again \n\n");
							backToMenu = true;
						}
					} while (!backToMenu);
				}
					break;
				case 3: {
					System.out.printf("\n\n You selected to proceed as a Transporter Personnel\n ");
					checked = false;
					Shipment tempShipment;
					int trackID;
					TransportationPersonnel tempTP;

					System.out.printf("\n Please enter your ID: ");
					ID = inputConsole.next();
					System.out.printf("\n Please enter your password: ");
					password = inputConsole.next();

					tempTP = GTUcargo.getTransportationPersonnel(ID, password);
					if (tempTP != null)
						checked = true;

					if (checked) {
						System.out.printf("\n Give the track ID which you want to update Shipment as delivered\n");
						trackID = inputConsole.nextInt();
						tempShipment = GTUcargo.getShipment(trackID);

						if (tempShipment != null) {
							tempTP.setAsDelivered(tempShipment);
							System.out.printf("\n\n The Cargo with track ID : %d is successfully changed as delivered \n\n", trackID);
						}
					}
					else
						System.out.printf("\n\n Information you entered does not match with a Transportation Personnel. Please try again \n\n");
				}
					break;
				case 4:  {
					int trackID;
					System.out.printf("\n\n You selected to proceed as a Customer.\n ");
					checked = false;
					System.out.printf("\n Please enter your track ID: ");
					trackID = inputConsole.nextInt();

					checked = GTUcargo.learnInformationAsCustomer(trackID);
					if (!checked)
						System.out.printf("\n\n Information you entered  %s does not match with a Track ID. ", trackID);
				}
				 	break;
				case 0:  {
					System.out.printf("\n\n Exited program successfully.\n ");
					exitProgram = true;
				}
					break;
				default: {
					System.out.printf("\n\n You selected undefined process." +
							" Please select a valid process to continue ");
				}
					break;
					
			}
		}while( !exitProgram );
			
		inputConsole.close();
		
	}

}
