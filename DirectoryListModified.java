package directoryListModified;

import java.io.File;
import java.util.Scanner;

public class DirectoryListModified {


	public static void main(String[] args) {

		String directoryName;  // Directory name entered by the user.
		File directory;        // File object referring to the directory.
		String[] files;        // Array of file names in the directory.
		Scanner scanner;       // For reading a line of input from the user.

		scanner = new Scanner(System.in);  // scanner reads from standard input.

		System.out.print("Enter a directory name: ");
		directoryName = scanner.nextLine().trim();
		directory = new File(directoryName);

		if (directory.isDirectory() == false) {
			if (directory.exists() == false)
				System.out.println("There is no such directory!");
			else
				System.out.println("That file is not a directory.");
		}
		else {
			searchDirectory(directory);
		}

	} // end main()
	
	
	public static void searchDirectory(File dir) {
		
		String[] files;
		System.out.println(dir.getName());
		files = dir.list();
		
		for(int i = 0; i < files.length; i++) {
			File fle = new File(dir, files[i]);
			if(fle.isDirectory()) {
				searchDirectory(fle);
			}
			else {
				System.out.println(files[i]);
			}
		}
	}
	
	
}
