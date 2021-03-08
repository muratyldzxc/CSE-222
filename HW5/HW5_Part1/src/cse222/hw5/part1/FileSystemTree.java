package cse222.hw5.part1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * An organized file system
 */
public class FileSystemTree {
	/**
	 * Holds root directory of file system
	 */
	FileNode root;
	
	/**
	 * To define a document as a file or directory
	 */
	public enum FileType{
		Directory, File ;
		
	}
	
	/**
	 * To hold each documents and its data
	 */
	public static class FileNode{
		/**
		 * name of the file
		 */
		String fileName;
		/**
		 * Holds children of directory
		 */
		LinkedList<FileNode> childNodes;
		/**
		 * Type of document
		 */
		FileType type;
		
		/**
		 * Create a file or dicrectory with given parameters
		 * @param fileName name of the file will be added
		 * @param type The type of document(file or directory)
		 * @throws NullPointerException if one of the parameter is null
		 */
		public FileNode(String fileName, FileType type) {
			if(fileName == null || type == null)
				throw new NullPointerException();
			
			this.fileName = fileName;
			this.type = type;

			if(this.type.compareTo(FileType.Directory) == 0)
				this.childNodes = new LinkedList<FileNode>();
			else
				this.childNodes = null;
		}


		/**
		 * Checks two object is equal or not
		 * @param o object will be compared
		 * @return if two object is equal returns true, otherwise return false
		 * @throws NullPointerException if the parameter is null
		 */
		@Override
		public boolean equals(Object o) {
			if (o == null)
				throw new NullPointerException();
			if (this == o)
				return true;
			if (!(o instanceof FileNode))
				return false;

			FileNode fileNode = (FileNode) o;

			return fileName.equals(fileNode.fileName) && type == fileNode.type;
		}

	}

	/**
	 * Create a file System
	 * @param rootDir root directory of file system
	 * @throws NullPointerException if the parameter is null
	 */
	public FileSystemTree(String rootDir) {
		if (rootDir == null)
			throw new NullPointerException();

		this.root = new FileNode(rootDir, FileType.Directory);

	}

	/**
	 * Create a file System
	 */
	public FileSystemTree() {
		this.root = null;
	}

	/**
	 * A helper function for both addDir and addFile
	 * @param newFile name of the new file to be added file system
	 * @param masterNode superior node which file will be added
	 * @param type type of the new file to be added file system
	 */
	private void add(String newFile, FileNode masterNode, FileType type){
		int cursor = newFile.indexOf('/');
		FileNode tempNode ;
		int childNodeCursor;
		int fileOrNot = 0;

		if( cursor != -1 ) {
			tempNode = new FileNode(newFile.substring(0, cursor), FileType.Directory);
			childNodeCursor = masterNode.childNodes.indexOf(tempNode);
			if (childNodeCursor == -1)
				fileOrNot = masterNode.childNodes.indexOf(new FileNode(newFile.substring(0, cursor), FileType.File));
		}
		else {
			tempNode = new FileNode(newFile, type);
			childNodeCursor = masterNode.childNodes.indexOf(tempNode);
		}

		if( cursor == -1  )
			if( childNodeCursor == -1 )
				masterNode.childNodes.add( tempNode );
			else
				System.out.printf("\n The file named as %s already exist in given class path\n\n ", newFile);
		else if ( childNodeCursor == -1 && fileOrNot != -1)
			System.out.printf("\n You can not add a Directory or File inside a file named as %s\n\n "
					, tempNode.fileName);
		else if( childNodeCursor == -1 )
			System.out.printf("\n The File named %s in the given class path is not found at the File System\n "
					, tempNode.fileName);
		else
			add(newFile.substring(cursor+1), masterNode.childNodes.get(childNodeCursor), type );

	}

	/**
	 * Add a directory to file system , if something went wrong prints an error message
	 * @param newDir name of new directory to be added file system
	 * @throws NullPointerException if parameter is null
	 */
	public void addDir(String newDir) {

		if (newDir == null)
			throw new NullPointerException();

		int cursor = newDir.indexOf('/');
		FileNode tempNode = (cursor == -1) ? new FileNode(newDir, FileType.Directory) : new FileNode(newDir.substring(0, cursor), FileType.Directory);

		if(  cursor == -1 && root == null)
			this.root = tempNode;
		else if( !this.root.equals(tempNode) )
			System.out.printf("\n The Directory named %s in the given class path is not found at the File System\n "
							, tempNode.fileName);
		else
			add(newDir.substring(cursor+1), root, FileType.Directory);
	}

	/**
	 * Add a file to file system , if something went wrong prints an error message
	 * @param newFile name of new file to be added file system
	 * @throws NullPointerException if parameter is null
	 */
	public void addFile(String newFile) {

		if (newFile == null)
			throw new NullPointerException();

		int cursor = newFile.indexOf('/');
		FileNode tempNode = new FileNode(newFile.substring(0, cursor), FileType.Directory);

		if(  cursor == -1 )
			System.out.printf("\n You can only add a File under a Directory\n ");
		else if( !this.root.equals(tempNode) )
			System.out.printf("\n The Directory named %s in the given class path is not found at the File System\n "
					, tempNode.fileName);
		else
			add(newFile.substring(cursor+1), root, FileType.File);
	}

	/**
	 * A helper function for remove function
	 * @param removeFile name of the file to be removed file system
	 * @param tempNode file node which wanted to be removed
	 * @return	removed file node if find it, null if can not find it
	 */
	public FileNode removeHelper(String removeFile, FileNode tempNode){

		if(tempNode == null)
			return null;

		FileNode removeNode ;
		int cursor = removeFile.indexOf('/');
		String str = (cursor == -1) ? removeFile : removeFile.substring(0,cursor);

		if(cursor == -1 ){
			if( tempNode.equals(root) ) {
				System.out.printf("\n\n You can not delete root Directory\n");
				return root;
			}
			else if(tempNode.fileName.equals(str)) {
				if (tempNode.childNodes != null) {
					System.out.print("\n\n"+printFileSytemHelper(tempNode, 0));
					System.out.printf("\n\n If you delete directory, files under the directory will be deleted too\n"
							+ "Do you want to delete the directory ? (Y\\N)");
					Scanner input = new Scanner(System.in);
					if(input.next().equals("Y"))
						return tempNode;

					input.close();
					return tempNode;
				}
				return tempNode;
			}

			return null;
		}
		else if(tempNode.fileName.equals(str)){
			removeFile = removeFile.substring(cursor+1);
			for (int i=0; i<tempNode.childNodes.size(); i++) {
				removeNode = removeHelper(removeFile, tempNode.childNodes.get(i));
				if (removeNode != null && !removeNode.equals(root) ) {
					tempNode.childNodes.remove(removeNode);
					return removeNode;
				}
			}
		}

		return null;
	}

	/**
	 * Removes file with given name from file system
	 * @param removeFile name of the file will be removed
	 * @throws NullPointerException if removeFile parameter is null
	 */
	public void remove(String removeFile)  {
		if (removeFile == null)
			throw new NullPointerException();
		if (root ==  null)
			System.out.print("\n You can not delete from empty file system\n");

		else if( removeHelper(removeFile, root) == null )
			System.out.printf("\n\n The given file path not found \n\n");
	}

	/**
	 * A helper function for search function
	 * @param searchFile will be searched at file system
	 * @param tempNode	current directory or file in file system
	 * @param classPath stores file path of the searched file
	 */
	public void searchHelper(String searchFile, FileNode tempNode, String classPath){

		if( tempNode == null || searchFile == null )
			return ;

		classPath += tempNode.fileName;

		if( tempNode.fileName.contains(searchFile))
			System.out.printf("\n// %s - %s", tempNode.type, classPath);

		if( tempNode.childNodes == null || tempNode.childNodes.size() == 0)
			return ;

		classPath += "\\";
		for (int i=0; i<tempNode.childNodes.size(); i++)
			searchHelper(searchFile, tempNode.childNodes.get(i), classPath);
	}

	/**
	 * Search given file name at th file system
	 * @param searchFile name of the file will be searched
	 * @throws NullPointerException if parameter is null
	 */
	public void search(String searchFile) {
		if (searchFile == null)
			throw new NullPointerException();

		String classPath = new String();
		searchHelper(searchFile, root, classPath);
	}

	/**
	 * A helper function for toString and printFileSystem function
	 * @param tempNode current file in file system
	 * @param depth	depth of the current file
	 * @return whole file system as a String
	 */
	private String printFileSytemHelper(FileNode tempNode, int depth){
		String str = new String();

		if( tempNode == null )
			return "";

		for (int i=0; i<depth; i++)
			str += "\t";

		str += "\\" + tempNode.fileName + "\n";

		if( tempNode.childNodes == null || tempNode.childNodes.size() == 0)
			return str;

		depth++;
		for (int i=0; i<tempNode.childNodes.size(); i++)
			str += printFileSytemHelper(tempNode.childNodes.get(i), depth);

		return str;
	}

	/**
	 * Prints whole file system
	 */
	public void printFileSystem() {
		System.out.printf("%s",toString());
	}

	/**
	 * Returns whole file system as a String
	 * @return whole file system as a String
	 */
	public String toString(){

		return "\n" + printFileSytemHelper(root, 0) + "\n";
	}
	
}
