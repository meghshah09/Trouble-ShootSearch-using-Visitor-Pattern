
package troubleShootSearch.driver;
import java.util.List;
import java.util.Scanner;
import troubleShootSearch.Products.DSeagateProducts;
import troubleShootSearch.enums.DebugLevel;
import troubleShootSearch.searchAlgorithms.ExactMatchVisitor;
import troubleShootSearch.searchAlgorithms.NaiveStemmingMatchVisitor;
import troubleShootSearch.searchAlgorithms.SearchAlgorithmsVisitorI;
import troubleShootSearch.searchAlgorithms.SemanticMatchVisitor;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.FilesLoader;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.Results;

/**
 *
 * @author Megh Shah and Shashwat Maru
 */
public class Driver {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		if(args.length==2){
			System.out.println("================================================");
			System.out.println("            Trouble Shoot Seacrh             ");
			System.out.println("================================================");
			System.out.println("");
			System.out.println("Starting the Process......");
			System.out.println("Trying to See Search from the given input file : "+ args[0]+" given.....");
			System.out.println("");
			Scanner scan = new Scanner(System.in);
                                                            Logger.setDebugValue(Integer.parseInt(args[1]));
			FileProcessor fp = new FileProcessor(scan);
			FilesLoader fl = new FilesLoader(fp);
                                                             Results r = new Results();
                                                             r.openingOutputFile("output/output.txt");
			List<String> userSentences = fl.loadInputs(args[0]);

			DSeagateProducts dSeagateProducts = new DSeagateProducts(userSentences,r);
			FilesLoader fl1 = new FilesLoader(fp);
			List<String> hddtechnicalGuide = fl1.loadInputs("inputs/Product1Guide.txt");
			dSeagateProducts.setHDDProductTechnicalGuide(hddtechnicalGuide);
			
			FilesLoader fl2 = new FilesLoader(fp);
			List<String> mediaPlayerTechnicalGuide = fl2.loadInputs("inputs/Product3Guide.txt");
			dSeagateProducts.setMediaPlayerProductTechnicalGuide(mediaPlayerTechnicalGuide);
			FilesLoader fl3 = new FilesLoader(fp);
			List<String> SSDtechnicalGuide = fl3.loadInputs("inputs/Product2Guide.txt");
			dSeagateProducts.setSDDProductTechnicalGuide(SSDtechnicalGuide);
			FilesLoader fl4 = new FilesLoader(fp);
			List<String> USBtechnicalGuide = fl4.loadInputs("inputs/Product4Guide.txt");
			dSeagateProducts.setUSBProductTechnicalGuide(USBtechnicalGuide);
				
			dSeagateProducts.setMapOfTechnicalGuide();
			
			SearchAlgorithmsVisitorI exactMatch = new ExactMatchVisitor(r);
			SearchAlgorithmsVisitorI naiveStemmingMatch = new NaiveStemmingMatchVisitor(r);
			SearchAlgorithmsVisitorI semanticMatch = new SemanticMatchVisitor("inputs/synonyms.txt",fp,r);
                                                            r.fileDisplay("\nPerforming [ Exact Match ] on All Products \n");
                                                            r.stdoutDisplay("\nPerforming [ Exact Match ] on All Products \n");
			dSeagateProducts.accept(exactMatch);
                                                             r.fileDisplay("\nPerforming [ Naive Stemming  Match ] on All Products \n");
                                                            r.stdoutDisplay("\nPerforming [ Naive Stemming Match ] on All Products \n");
			dSeagateProducts.accept(naiveStemmingMatch);
                                                             r.fileDisplay("\nPerforming [ Semantic Match ] on All Products \n");
                                                            r.stdoutDisplay("\nPerforming [ Semantic Match ] on All Products \n");
			dSeagateProducts.accept(semanticMatch);
                                                            r.closeingOutputFile();


		}
                                        else{
                                                    Logger.writeMessage("Not Correct Command line Arguements", DebugLevel.NONE);
                                                    System.exit(0);
                                        }
	}

}
