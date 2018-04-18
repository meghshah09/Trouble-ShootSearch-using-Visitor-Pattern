package troubleShootSearch.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Shashwat Maru
 *
 */

public class ReadTechnicalGuidelineFiles {


	private String filePath;
	Scanner scanner ;
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePathIn) {
		filePath = filePathIn;
	}

	/**
	 * @param filePathIn
	 * @throws FileNotFoundException
	 */
	public void FileProcessor() {

		try {
			filePath = "";
			File file = new File(filePath);
			scanner = new Scanner(file);
		}
		catch(FileNotFoundException e) {
			System.err.println("File not found at specified location.");
			System.exit(0);
		}
	}

	public String readFileLine() {
		if(scanner.hasNextLine())
			return scanner.nextLine();
		else
			return null;
	}

	public boolean hasNextLine() {
		return scanner.hasNextLine();

	}
	public String toString() {
		String printMessage;
		printMessage = "FilePath:"+filePath;
		return printMessage;	
	}

}