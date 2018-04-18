/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package troubleShootSearch.driver;

import troubleShootSearch.Products.HDDProduct1;
import troubleShootSearch.searchAlgorithms.ExactMatch;
import troubleShootSearch.searchAlgorithms.NaiveStemmingMatch;
import troubleShootSearch.searchAlgorithms.SearchAlgorithms;
import troubleShootSearch.searchAlgorithms.SemanticMatch;


/**
 *
 * @author Megh Shah and Shashwat Maru
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    	HDDProduct1 hddProduct1 = new HDDProduct1();
    	SearchAlgorithms exactMatch = new ExactMatch();
     	SearchAlgorithms naiveStemmingMatch = new NaiveStemmingMatch();
     	SearchAlgorithms semanticMatch = new SemanticMatch();
    	hddProduct1.accept(exactMatch);
    	hddProduct1.accept(naiveStemmingMatch);
    	hddProduct1.accept(semanticMatch);
    	
    }
    
}
