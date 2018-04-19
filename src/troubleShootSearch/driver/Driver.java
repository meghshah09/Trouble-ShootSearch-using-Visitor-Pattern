/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package troubleShootSearch.driver;

import java.util.ArrayList;
import java.util.List;

import troubleShootSearch.Products.HDDProduct;
import troubleShootSearch.Products.MediaPlayers;
import troubleShootSearch.Products.SSDProduct;
import troubleShootSearch.Products.USBProduct;
import troubleShootSearch.searchAlgorithms.ExactMatchVisitor;
import troubleShootSearch.searchAlgorithms.NaiveStemmingMatchVisitor;
import troubleShootSearch.searchAlgorithms.SearchAlgorithmsVisitorI;
import troubleShootSearch.searchAlgorithms.SemanticMatchVisitor;


/**
 *
 * @author Megh Shah and Shashwat Maru
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    	HDDProduct hddProduct1 = new HDDProduct();
/*    	MediaPlayers mediaPlayers = new MediaPlayers();
    	SSDProduct ssdProduct = new SSDProduct();
    	USBProduct usbProduct = new USBProduct();
*/    	List<String> tempSentences = new ArrayList<String>();
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
    	
    	
    	/* 	mediaPlayers.accept(exactMatch);
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
