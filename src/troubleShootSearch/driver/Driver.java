/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package troubleShootSearch.driver;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import troubleShootSearch.Products.HDDProduct;
import troubleShootSearch.Products.MediaPlayers;
import troubleShootSearch.Products.SSDProduct;
import troubleShootSearch.Products.USBProduct;
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
                
                HDDProduct hddProduct = new HDDProduct(userSentences);
                FilesLoader fl1 = new FilesLoader(fp);
                List<String> HDDtechnicalGuide = fl1.loadInputs("Product1Guide.txt");
                hddProduct.setHDDProductTechnicalGuide(HDDtechnicalGuide);
                
        	MediaPlayers mediaPlayers = new MediaPlayers(userSentences);
                FilesLoader fl2 = new FilesLoader(fp);
                List<String> mediaPlayerTechnicalGuide = fl2.loadInputs("Product2Guide.txt");
                mediaPlayers.setMediaPlayerTechnicalGuide(mediaPlayerTechnicalGuide);
                
                SSDProduct ssdProduct = new SSDProduct(userSentences);
                FilesLoader fl3 = new FilesLoader(fp);
                List<String> SSDtechnicalGuide = fl3.loadInputs("Product3Guide.txt");
                ssdProduct.setSSDProductTechnicalGuide(SSDtechnicalGuide);
                
                USBProduct usbProduct = new USBProduct(userSentences);
                FilesLoader fl4 = new FilesLoader(fp);
                List<String> USBtechnicalGuide = fl4.loadInputs("Product4Guide.txt");
                usbProduct.setUSBProductTechnicalGuide(USBtechnicalGuide);

                SearchAlgorithmsVisitorI exactMatch = new ExactMatchVisitor();
                SearchAlgorithmsVisitorI naiveStemmingMatch = new NaiveStemmingMatchVisitor();
                SearchAlgorithmsVisitorI semanticMatch = new SemanticMatchVisitor();
                hddProduct.accept(exactMatch);
                hddProduct.accept(naiveStemmingMatch);
                /*hddProduct.accept(semanticMatch);*/
                mediaPlayers.accept(exactMatch);
               /* mediaPlayers.accept(naiveStemmingMatch);
                mediaPlayers.accept(semanticMatch);
                ssdProduct.accept(exactMatch);
                ssdProduct.accept(naiveStemmingMatch);
                ssdProduct.accept(semanticMatch);
                usbProduct.accept(exactMatch);
                usbProduct.accept(naiveStemmingMatch);
                usbProduct.accept(semanticMatch);
                //hddProduct.accept(naiveStemmingMatch);*/
                /*for(String s : userSentences){
                    System.out.println(s);
                }*/
                
        }
    	/*HDDProduct hddProduct1 = new HDDProduct();
/*    	MediaPlayers mediaPlayers = new MediaPlayers();
    	SSDProduct ssdProduct = new SSDProduct();
    	USBProduct usbProduct = new USBProduct();
   	List<String> tempSentences = new ArrayList<String>();
    	tempSentences.add("If Debian has a problem detectinge the drive, it could be that the portable drive is not receiving enough power.");
    	tempSentences.add("If Mihir has a aproblem detect the drive, it could be that the portable drive is not receiving enough power.");
    	tempSentences.add("If Megh has a roblem detecting the drive, it could be that the portable drive is not receiving enough power.");
    	tempSentences.add("If Shashwat has a problem detecting the drive, it could be that the portable drive is not receiving enough power.");
    	tempSentences.add("If Shubham has a problem adetecting the drive, it could be that the portable drive is not receiving enough power.");

    	hddProduct1.setHDDProductTechnicalGuide(tempSentences);
    	hddProduct1.setProblemKeyword("problem detecting");
    	SearchAlgorithmsVisitorI exactMatch = new ExactMatchVisitor();
    	SearchAlgorithmsVisitorI naiveStemmingMatch = new NaiveStemmingMatchVisitor();
  //  	SearchAlgorithmsVisitorI semanticMatch = new SemanticMatchVisitor();
    	hddProduct1.accept(exactMatch);
    	hddProduct1.accept(naiveStemmingMatch);
    //	hddProduct1.accept(semanticMatch);
    	
    	
    	 	mediaPlayers.accept(exactMatch);
    	mediaPlayers.accept(naiveStemmingMatch);
    	mediaPlayers.accept(semanticMatch);
    	ssdProduct.accept(exactMatch);
    	ssdProduct.accept(naiveStemmingMatch);
    	ssdProduct.accept(semanticMatch);
    	usbProduct.accept(exactMatch);
    	usbProduct.accept(naiveStemmingMatch);
    	usbProduct.accept(semanticMatch);
*/	
    }
    
}
