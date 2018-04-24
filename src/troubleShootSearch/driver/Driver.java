
package troubleShootSearch.driver;
import java.util.List;
import java.util.Scanner;
import troubleShootSearch.Products.DSeagateProducts;
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
 
	/**
	 * @param args
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
                                                            Logger log = new Logger();
                                                             log.setDebugValue(Integer.parseInt(args[1]));
			FileProcessor fp = new FileProcessor(scan,log);
			FilesLoader fl = new FilesLoader(fp,log);
                                                             Results r = new Results();
                                                             r.openingOutputFile("output.txt");
			List<String> userSentences = fl.loadInputs(args[0]);

			DSeagateProducts dSeagateProducts = new DSeagateProducts(userSentences,r,log);
			FilesLoader fl1 = new FilesLoader(fp,log);
			List<String> hddtechnicalGuide = fl1.loadInputs("Product1Guide.txt");
			dSeagateProducts.setHDDProductTechnicalGuide(hddtechnicalGuide);
			
			FilesLoader fl2 = new FilesLoader(fp,log);
			List<String> mediaPlayerTechnicalGuide = fl2.loadInputs("Product3Guide.txt");
			dSeagateProducts.setMediaPlayerProductTechnicalGuide(mediaPlayerTechnicalGuide);
			FilesLoader fl3 = new FilesLoader(fp,log);
			List<String> SSDtechnicalGuide = fl3.loadInputs("Product2Guide.txt");
			dSeagateProducts.setSDDProductTechnicalGuide(SSDtechnicalGuide);
			FilesLoader fl4 = new FilesLoader(fp,log);
			List<String> USBtechnicalGuide = fl4.loadInputs("Product4Guide.txt");
			dSeagateProducts.setUSBProductTechnicalGuide(USBtechnicalGuide);
				
			dSeagateProducts.getMapOfTechnicalGuide().put("HDDProduct", dSeagateProducts.getHDDProductTechnicalGuide());
			dSeagateProducts.getMapOfTechnicalGuide().put("SDDProduct", dSeagateProducts.getSDDProductTechnicalGuide());
			dSeagateProducts.getMapOfTechnicalGuide().put("USBProduct", dSeagateProducts.getUSBProductTechnicalGuide());
			dSeagateProducts.getMapOfTechnicalGuide().put("MediaPlayerProduct", dSeagateProducts.getMediaPlayerProductTechnicalGuide());
			
			SearchAlgorithmsVisitorI exactMatch = new ExactMatchVisitor(r,log);
			SearchAlgorithmsVisitorI naiveStemmingMatch = new NaiveStemmingMatchVisitor(r,log);
			SearchAlgorithmsVisitorI semanticMatch = new SemanticMatchVisitor("synonyms.txt",fp,r,log);
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
                                                    System.out.println("Not Correct Command line Arguements");
                                                    System.exit(0);
                                        }
	}

}
