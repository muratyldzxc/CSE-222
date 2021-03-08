package cse222.hw6.part3;

import java.util.*;

public class LibraryAutomationSystem {
	/**
	 * Holds system data
	 */
	public Map<String,Map<String, Set<String>>> system ;
	/**
	 * Holds admin's password
	 */
	public final String adminPassword = "1234";
	
	
	/**
	 * Create a LibraryAutomationSystem object
	 * 
	 */
	public LibraryAutomationSystem() {
		this.system = new HashMap<String,Map<String, Set<String>>>();
	}

	/**
	 * Adds book
	 * @param author will be set
	 * @param bookName will be set
	 * @param location will be set
	 * @return true if given book is not in given location, otherwise false
	 */
	public boolean addBook(String author, String bookName, String location){

		if(!system.containsKey(author)) {
			Set<String> locationSet = new HashSet<String>();
			locationSet.add(location);

			Map<String,Set<String>> bookMap = new HashMap<String, Set<String>>();
			bookMap.put(bookName,locationSet);

			system.put(author, bookMap);
		}
		else{
			Map<String,Set<String>> bookMap= system.get(author);
			if ( !bookMap.containsKey(bookName) ){
				Set<String> bookLocationSet = new HashSet<String>();
				bookLocationSet.add(location);
				bookMap.put(bookName,bookLocationSet);
			}
			else{
				Set<String> bookLocationSet = bookMap.get(bookName);
				if ( !bookLocationSet.contains(location) )
					bookLocationSet.add(location);
				else
					return  false;
			}

		}

		return true;
	}

	/**
	 * Display all books of given author
	 * @param author will be searched
	 */
	public void displayBooksOfAuthor(String author){
		
		if(system.get(author) == null) {
			System.out.printf("\n ! invalid input ! \n");
			return;
		}
			
		Iterator<String> iter = system.get(author).keySet().iterator();
		Scanner sc = new Scanner(System.in);

		System.out.printf("\n - Author's books: \n");

		while(iter.hasNext())
			System.out.printf("\n - Book name: %s", iter.next());

		System.out.printf("\n\n - Please enter the book name you want to display as a word: ");
		String bookName = sc.next();
		
		if(system.get(author).get(bookName) == null) {
			System.out.printf("\n ! invalid input ! \n");
			return;
		}
		Set<String> locations = system.get(author).get(bookName);
		System.out.printf("\n - Book Locations: %s", locations );

	}

	/**
	 * Display author, book name, location of a book
	 * @param bookName will be searched
	 * @return true if given book is exist, otherwise false
	 */
	public boolean displayFeaturesOfBook(String bookName){
		Iterator<String> iter = system.keySet().iterator();

		while(iter.hasNext()){
			String tempAuthor = iter.next();
			Set<String> locations = system.get(tempAuthor).get(bookName);
			if ( locations != null)
				System.out.printf("\n\n - Book Name: %s\n - Book Author: %s\n - Book Locations: %s"
				, bookName, tempAuthor, locations );
			else
				return false;
		}
		return  true;
	}
	
	/**
	 * Remove book
	 * @param author will be searched
	 * @param bookName will be searched
	 */
	public void removeBook(String author, String bookName){
		Scanner sc = new Scanner(System.in);
		
		if(system.get(author) == null ) {
			System.out.printf("\n ! invalid input ! \n");
			return;
		}
		else if(system.get(author).get(bookName) == null) {
			System.out.printf("\n ! invalid input ! \n");
			return;
		}
		
		Set<String> locationSet = system.get(author).get(bookName);
		Iterator<String> iter = locationSet.iterator();


		System.out.printf("\n\n - Book Locations: ");
		while (iter.hasNext()){
			String location = iter.next();
			if ( location != null)
				System.out.printf("\n - %s", location );
		}
		System.out.printf("\n\n Please enter location information of the book you want to delete: ");

		System.out.printf("\n\n Please enter corridor where book is: ");
		int corridor = sc.nextInt();
		System.out.printf("\n Please enter shelf where book is: ");
		int shelf = sc.nextInt();
		System.out.printf("\n Please enter Line where book is: ");
		int line = sc.nextInt();

		String deleteLocation = "C" + corridor + ".S" + shelf + ".L" + line;
		
		if( !locationSet.remove(deleteLocation)) {
			System.out.printf("\n ! invalid input ! \n");
			return;
		}
			
	}

	/**
	 * Update given author, book name of book 's location 
	 * @param author will be searched
	 * @param bookName will be searched
	 */
	public void updateInformation(String author, String bookName){
		Scanner sc = new Scanner(System.in);
		Set<String> locationSet = system.get(author).get(bookName);
		Iterator<String> iter = locationSet.iterator();

		System.out.printf("\n\n - Book Locations: ");
		while (iter.hasNext()){
			String location = iter.next();
			if ( location != null)
				System.out.printf("\n - %s", location );
		}
		System.out.printf("\n\n Please enter location information of the book you want to update: ");

		System.out.printf("\n\n Please enter corridor where book is: ");
		int corridor = sc.nextInt();
		System.out.printf("\n Please enter shelf where book is: ");
		int shelf = sc.nextInt();
		System.out.printf("\n Please enter Line where book is: ");
		int line = sc.nextInt();

		String location = "C" + corridor + ".S" + shelf + ".L" + line;

		System.out.printf("\n Please enter new location information to update location: ");

		System.out.printf("\n\n Please enter corridor where book will be: ");
		corridor = sc.nextInt();
		System.out.printf("\n Please enter shelf where book will be: ");
		shelf = sc.nextInt();
		System.out.printf("\n Please enter Line where book will be: ");
		line = sc.nextInt();

		String newLocation = "C" + corridor + ".S" + shelf + ".L" + line;

		locationSet = system.get(author).get(bookName);
		locationSet.remove(location);
		locationSet.add(newLocation);

	}

}
