import cse222.hw5.part1.*;

public class DriverClasss {

	public static void main(String[] args) {
		FileSystemTree t = new FileSystemTree();

		System.out.printf("\n TEST01 - Testing FileSystemTree Constructor with null parameter\n");
		try {
			t = new FileSystemTree(null);
		} catch (Exception e){
			System.out.print("\n " + e.toString() + "\n");
		}

		System.out.printf("\n TEST02 - Testing remove() while file system empty\n");
		t.remove("deneme");

		System.out.printf("\n TEST03 - Testing FileSystemTree Constructor with root parameter\n");
		t = new FileSystemTree("root");
		t.printFileSystem();

		System.out.printf("\n TEST04 - Testing remove() with root directory \n");
		t.remove("root");

		System.out.printf("\n TEST05 - Testing remove() with null parameter \n");
		try {
			t.remove(null);
		} catch (Exception e){
			System.out.print("\n " + e.toString() + "\n");
		}

		System.out.printf("\n TEST06 - Testing addDir() with null parameter \n");
		try {
			t.addDir(null);
		} catch (Exception e){
			System.out.print("\n " + e.toString() + "\n");
		}

		System.out.printf("\n TEST07 - Testing addFile() with null parameter \n");
		try {
			t.addFile(null);
		} catch (Exception e){
			System.out.print("\n " + e.toString() + "\n");
		}

		System.out.printf("\n TEST08 - Testing search() with null parameter \n");
		try {
			t.search(null);
		} catch (Exception e){
			System.out.print("\n " + e.toString() + "\n");
		}

		System.out.printf("\n After add some directories and files\n");

		t.addDir("root/first_directory");
		t.addFile("root/first_directory/new_file1.txt");

		t.addDir("root/second_directory");
		t.addDir("root/second_directory/new_dic");
		t.addDir("root/second_directory/new_dic2");

		t.addFile("root/second_directory/new_dic/new_file2.txt");
		t.addDir("root/second_directory/new_dic2/new_dic3");

		t.addDir("root/third_directory");
		t.addFile("root/third_directory/new_file1.txt");
		t.addDir("root/third_directory/new_dic4");
		t.addDir("root/third_directory/new_dic5");
		t.addDir("root/third_directory/new_dic4/hello_dic");
		t.addFile("root/third_directory/new_dic4/hello_file.txt");

		t.printFileSystem();

		System.out.printf("\n TEST09 - Testing addDir() with already exist \n" +
				" (root/first_directory) \n");
		t.addDir("root/first_directory");
		t.printFileSystem();

		System.out.printf("\n TEST10 - Testing addFile() with already exist \n" +
				" (root/first_directory/new_file1.txt) \n");
		t.addFile("root/first_directory/new_file1.txt");
		t.printFileSystem();

		System.out.printf("\n TEST11 - Testing addDir() ,try to add a directory under invalid filepath \n" +
				" (root/third_directory/new_dic4/hello_/deneme) \n ");
		t.addDir("root/third_directory/new_dic4/hello_/deneme");
		t.printFileSystem();

		System.out.printf("\n TEST12 - Testing addFile() ,try to add a file under a file \n" +
				" (root/third_directory/new_dic4/hello_file.txt/deneme.txt) \n");
		t.addFile("root/third_directory/new_dic4/hello_file.txt/deneme.txt");
		t.printFileSystem();

		System.out.printf("\n TEST13 - Testing addDir() ,try to add a directory under a file \n" +
				" (root/third_directory/new_dic4/hello_file.txt/deneme_dir) \n");
		t.addDir("root/third_directory/new_dic4/hello_file.txt/deneme_dir");
		t.printFileSystem();

		System.out.printf("\n TEST14 - Testing search() with (new) parameter \n");
		t.search("new");
		t.printFileSystem();

		System.out.printf("\n TEST15 - Testing remove() remove a file \n" +
				" (root/second_directory/new_dic/new_file2.txt) \n ");
		t.remove("root/second_directory/new_dic/new_file2.txt");
		t.printFileSystem();


		System.out.printf("\n TEST16 - Testing remove() remove a directory \n" +
				" (root/third_directory/new_dic4) \n ");
		t.remove("root/third_directory/new_dic4");
		t.printFileSystem();


		System.out.printf("\n TEST17 - Testing remove() remove a directory \n" +
				" (root/third_directory) \n ");
		t.remove("root/third_directory");
		t.printFileSystem();

	}
}
