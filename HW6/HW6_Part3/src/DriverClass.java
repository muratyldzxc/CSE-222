import cse222.hw6.part3.LibraryAutomationSystem;

import java.util.Scanner;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LibraryAutomationSystem lb = new LibraryAutomationSystem();
		Scanner sc = new Scanner(System.in);
		boolean exit = true;
		int choice;
		String author, bookName, location,password;
		int corridor, shelf, line;


		while(exit){
			System.out.printf("\n\n Welcome to Library Automation System \n");
			System.out.printf("\n 1- Searching by author name \n");
			System.out.printf("\n 2- Searching by book title \n");
			System.out.printf("\n 3- Enter as administrator \n");
			System.out.printf("\n 4- Exit \n");

			choice = sc.nextInt();

			switch (choice){
				case 1:
					try{
						System.out.printf("\n Please enter author's name: ");
						author = sc.next();
						lb.displayBooksOfAuthor(author);
					}catch (Exception e){

					}
					break;
				case 2:
					try{
						System.out.printf("\n Please enter name of the book: ");
						bookName = sc.next();
						lb.displayFeaturesOfBook(bookName);
					}catch (Exception e){

					}
					break;
				case 3:
					System.out.printf("\n\n Enter the password to move on as administrator \n");
					password = sc.next();
					if( password.equals(lb.adminPassword) ){
						System.out.printf("\n\n Select the operation you want to do as administrator \n");
						System.out.printf("\n 1- Add book \n");
						System.out.printf("\n 2- Delete book \n");
						System.out.printf("\n 3- Update information \n");
						choice = sc.nextInt();

						switch (choice){
							case 1:
								System.out.printf("\n Please enter author of the book: ");
								author = sc.next();
								System.out.printf("\n Please enter name of the book: ");
								bookName = sc.next();
								System.out.printf("\n Please enter corridor where book is: ");
								corridor = sc.nextInt();
								System.out.printf("\n Please enter shelf where book is: ");
								shelf = sc.nextInt();
								System.out.printf("\n Please enter Line where book is: ");
								line = sc.nextInt();

								location = "C" + corridor + ".S" + shelf + ".L" + line;
								if( !lb.addBook(author, bookName, location) )
									System.out.printf("\n ! Already there is a book named %s in location %s! \n", bookName, location);
								break;
							case 2:
								System.out.printf("\n Please enter name of the book you want to delete: ");
								bookName = sc.next();
								System.out.printf("\n Please enter author of the book you want to delete: ");
								author = sc.next();
								lb.removeBook(author, bookName);
								break;
							case 3:
								System.out.printf("\n Please enter author of the book you want to update: ");
								author = sc.next();
								System.out.printf("\n Please enter name of the book you want to update: ");
								bookName = sc.next();

								lb.updateInformation(author, bookName);
								break;
							default:
								System.out.printf("\n ! You entered an invalid choice please try again ! \n");
						}
					}
					else{
						System.out.printf("\n\n ! Password you entered doesn't match with system password ! \n");
					}
					break;
				case 4:
					exit = false;
					System.out.printf("\n ! Exited from the program ! \n");
					break;
				default:
					System.out.printf("\n ! You entered an invalid choice please try again ! \n");

			}



		}
		

	}

}
