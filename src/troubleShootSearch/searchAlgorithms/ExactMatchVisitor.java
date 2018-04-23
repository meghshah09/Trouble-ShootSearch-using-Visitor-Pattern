package troubleShootSearch.searchAlgorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import troubleShootSearch.Products.DSeagateProducts;
import troubleShootSearch.util.Results;

public class ExactMatchVisitor implements SearchAlgorithmsVisitorI {
/*	List<String> technicalProblemGuideForHDDProduct;
	List<String> technicalProblemGuideForSDDProduct;
	List<String> technicalProblemGuideForUSBProduct;
	List<String> technicalProblemGuideForMediaPlayerProduct;
*/
                    private Results result;
	public ExactMatchVisitor(Results rIn) {
                            result = rIn;
	}

                    @Override
                    public void visit(DSeagateProducts dSeagateProducts) {

                        Set<String> s = dSeagateProducts.getMapOfTechnicalGuide().keySet();
                        for(String technicalGuideIterator: s) {
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
		}
		return exactMatchOutput;
	}

}
