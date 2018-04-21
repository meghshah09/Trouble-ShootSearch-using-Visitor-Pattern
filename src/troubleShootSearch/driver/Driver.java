/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Megh Shah and Shashwat Maru
 */
public class Driver {

	/**
	 * @param args the command line arguments
	 */

	public static void main(String[] args) {

		if(args.length==1){
			System.out.println("================================================");
			System.out.println("            Trouble Shoot Seacrh             ");
			System.out.println("================================================");
			System.out.println("");
			System.out.println("Starting the Process......");
			System.out.println("Trying to See Search from the given input file : "+ args[0]+" given.....");
			System.out.println("");
			Scanner scan = new Scanner(System.in);
			FileProcessor fp = new FileProcessor(scan);
			FilesLoader fl = new FilesLoader(fp);
			List<String> userSentences = fl.loadInputs(args[0]);

			DSeagateProducts dSeagateProducts = new DSeagateProducts(userSentences);
			FilesLoader fl1 = new FilesLoader(fp);
			List<String> hddtechnicalGuide = fl1.loadInputs("Product1Guide.txt");
			dSeagateProducts.setHDDProductTechnicalGuide(hddtechnicalGuide);
			FilesLoader fl2 = new FilesLoader(fp);
			List<String> mediaPlayerTechnicalGuide = fl2.loadInputs("Product2Guide.txt");
			dSeagateProducts.setMediaPlayerProductTechnicalGuide(mediaPlayerTechnicalGuide);
			FilesLoader fl3 = new FilesLoader(fp);
			List<String> SSDtechnicalGuide = fl3.loadInputs("Product3Guide.txt");
			dSeagateProducts.setSDDProductTechnicalGuide(SSDtechnicalGuide);
			FilesLoader fl4 = new FilesLoader(fp);
			List<String> USBtechnicalGuide = fl4.loadInputs("Product4Guide.txt");
			dSeagateProducts.setUSBProductTechnicalGuide(USBtechnicalGuide);

			SearchAlgorithmsVisitorI exactMatch = new ExactMatchVisitor();
			SearchAlgorithmsVisitorI naiveStemmingMatch = new NaiveStemmingMatchVisitor();
			SearchAlgorithmsVisitorI semanticMatch = new SemanticMatchVisitor("synonyms.txt",fp);

			dSeagateProducts.accept(exactMatch);
			dSeagateProducts.accept(naiveStemmingMatch);
			dSeagateProducts.accept(semanticMatch);


		}
	}

}
