package troubleShootSearch.searchAlgorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import troubleShootSearch.Products.DSeagateProducts;
import troubleShootSearch.enums.DebugLevel;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.Results;

public class ExactMatchVisitor implements SearchAlgorithmsVisitorI {

                    private Results result;
	public ExactMatchVisitor(Results rIn) {
                            result = rIn;
                            Logger.writeMessage("In Exact Match Constructor", DebugLevel.CONSTRUCTOR);
	}

                    @Override
                    public void visit(DSeagateProducts dSeagateProducts) {
                        Logger.writeMessage("Currently in Exact Match Search", DebugLevel.SEARCHSTRATEGY);
                        Set<String> s = dSeagateProducts.getMapOfTechnicalGuide().keySet();
                        for(String technicalGuideIterator: s) {
                            Logger.writeMessage("Currently Processing"+technicalGuideIterator+"product for Exact Match", DebugLevel.PRODUCTS);
                             result.fileDisplay(technicalGuideIterator +" : ");
                             result.stdoutDisplay(technicalGuideIterator +" : ");
                            search(dSeagateProducts.getProblemKeyword(), dSeagateProducts.getMapOfTechnicalGuide().get(technicalGuideIterator));

                        }

                    }


	@Override
	public List<String> search(String problemKeyword, List<String> technicalProblemGuide) {
		List<String> exactMatchOutput = new ArrayList<String>();
		if(technicalProblemGuide != null) {
			for(String string :technicalProblemGuide) {
//				if(string.matches("(.*)" + problemKeyword + "(.*)") || string.matches("(.*)" + problemKeyword) || string.matches(problemKeyword + "(.*)")){
				if(string.matches("(.*)(\\A|[^\\w])(" + problemKeyword + ")(\\Z|[^\\w])(.*)")) {
					exactMatchOutput.add(string);
				}
			}
		}
		for(String string : exactMatchOutput) {
			result.fileDisplay(string+"\n");
                                                            result.stdoutDisplay(string+"\n");
                                                            Logger.writeMessage("Problem Keyword : "+ problemKeyword +"Exact Match result : "+ string, DebugLevel.SEARCH);
		}
		return exactMatchOutput;
	}

}
