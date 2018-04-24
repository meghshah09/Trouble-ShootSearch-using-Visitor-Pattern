package troubleShootSearch.searchAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import troubleShootSearch.Products.DSeagateProducts;
import troubleShootSearch.enums.DebugLevel;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.Results;

public class NaiveStemmingMatchVisitor implements SearchAlgorithmsVisitorI{
	/*List<String> technicalProblemGuideForHDDProduct;
	List<String> technicalProblemGuideForSDDProduct;
	List<String> technicalProblemGuideForUSBProduct;
	List<String> technicalProblemGuideForMediaPlayerProduct;
	*/
	private Results result;
                    private Logger log;
	public NaiveStemmingMatchVisitor(Results rIn,Logger logIn) {
                            result = rIn;
                            log = logIn;
                            log.writeMessage("In Naive Stemming Match Constructor", DebugLevel.CONSTRUCTOR);
	}

    @Override
    public void visit(DSeagateProducts dSeagateProducts) {
        log.writeMessage("Currently in Naive Stemming Match Search", DebugLevel.SEARCHSTRATEGY);
        Set<String> s = dSeagateProducts.getMapOfTechnicalGuide().keySet();
        for(String technicalGuideIterator: s) {
            log.writeMessage("Currently Processing"+technicalGuideIterator+"product for Naive Stemming Match", DebugLevel.PRODUCTS);
              result.fileDisplay(technicalGuideIterator +" : ");
               result.stdoutDisplay(technicalGuideIterator +" : ");
            search(dSeagateProducts.getProblemKeyword(), dSeagateProducts.getMapOfTechnicalGuide().get(technicalGuideIterator));
        }

    }


	@Override
	public List<String> search(String problemKeyword, List<String> technicalProblemGuide) {

		String [] tempArray = problemKeyword.trim().split(" ");
		List<String> naiveStemmingMatchOutput = new ArrayList<String>();
		if(technicalProblemGuide != null) {
			for(String string: technicalProblemGuide) {
				if(string.contains(tempArray[0])) {
					naiveStemmingMatchOutput.add(string);
				}
			}
		}
		for(String string : naiveStemmingMatchOutput) {
			result.fileDisplay(string+"\n");
                                                            result.stdoutDisplay(string+"\n");
                                                            log.writeMessage("Problem Keyword : "+ problemKeyword +"Naive Stemming Match result : "+ string, DebugLevel.SEARCH);
		}
		return naiveStemmingMatchOutput;
	}

}
