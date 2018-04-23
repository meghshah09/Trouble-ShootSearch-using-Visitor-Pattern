package troubleShootSearch.searchAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import troubleShootSearch.Products.DSeagateProducts;
import troubleShootSearch.util.Results;

public class NaiveStemmingMatchVisitor implements SearchAlgorithmsVisitorI{
	/*List<String> technicalProblemGuideForHDDProduct;
	List<String> technicalProblemGuideForSDDProduct;
	List<String> technicalProblemGuideForUSBProduct;
	List<String> technicalProblemGuideForMediaPlayerProduct;
	*/
	private Results result;
	public NaiveStemmingMatchVisitor(Results rIn) {
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
		}
		return naiveStemmingMatchOutput;
	}

}
