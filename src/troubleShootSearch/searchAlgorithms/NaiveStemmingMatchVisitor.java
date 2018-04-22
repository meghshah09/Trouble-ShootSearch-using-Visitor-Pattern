package troubleShootSearch.searchAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import troubleShootSearch.Products.DSeagateProducts;

public class NaiveStemmingMatchVisitor implements SearchAlgorithmsVisitorI{
	/*List<String> technicalProblemGuideForHDDProduct;
	List<String> technicalProblemGuideForSDDProduct;
	List<String> technicalProblemGuideForUSBProduct;
	List<String> technicalProblemGuideForMediaPlayerProduct;
	*/
	
	@Override
	public void visit(DSeagateProducts dSeagateProducts) {
	/*	for(List<String> technicalGuide: dSeagateProducts.getListOfTechnicalGuide()) {
			search(dSeagateProducts.getProblemKeyword(), technicalGuide);
		}
	*/	
		Set<String> s = dSeagateProducts.getMapOfTechnicalGuide().keySet();
		for(String technicalGuideIterator: s) {
			search(dSeagateProducts.getProblemKeyword(), dSeagateProducts.getMapOfTechnicalGuide().get(technicalGuideIterator));
		}

		
		/*
		technicalProblemGuideForHDDProduct = dSeagateProducts.getHDDProductTechnicalGuide();
		search(dSeagateProducts.getProblemKeyword(), technicalProblemGuideForHDDProduct);

		technicalProblemGuideForSDDProduct = dSeagateProducts.getSDDProductTechnicalGuide();
		search(dSeagateProducts.getProblemKeyword(), technicalProblemGuideForSDDProduct);

		technicalProblemGuideForUSBProduct = dSeagateProducts.getUSBProductTechnicalGuide();
		search(dSeagateProducts.getProblemKeyword(), technicalProblemGuideForUSBProduct);

		technicalProblemGuideForMediaPlayerProduct = dSeagateProducts.getMediaPlayerProductTechnicalGuide();
		search(dSeagateProducts.getProblemKeyword(), technicalProblemGuideForMediaPlayerProduct);
		 */
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
			System.out.println("Problem Keyword: "+ problemKeyword + " & Naive Stemming Match Visitor Search: "+ string);
		}
		return naiveStemmingMatchOutput;
	}

}
