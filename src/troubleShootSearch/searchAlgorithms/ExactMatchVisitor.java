package troubleShootSearch.searchAlgorithms;

import java.util.ArrayList;
import java.util.List;

import troubleShootSearch.Products.DSeagateProducts;

public class ExactMatchVisitor implements SearchAlgorithmsVisitorI {
	List<String> technicalProblemGuideForHDDProduct;
	List<String> technicalProblemGuideForSDDProduct;
	List<String> technicalProblemGuideForUSBProduct;
	List<String> technicalProblemGuideForMediaPlayerProduct;

	@Override
	public void visit(DSeagateProducts dSeagateProducts) {
		technicalProblemGuideForHDDProduct = dSeagateProducts.getHDDProductTechnicalGuide();
		this.search(dSeagateProducts.getProblemKeyword(), technicalProblemGuideForHDDProduct);

		technicalProblemGuideForSDDProduct = dSeagateProducts.getSDDProductTechnicalGuide();
		this.search(dSeagateProducts.getProblemKeyword(), technicalProblemGuideForSDDProduct);

		technicalProblemGuideForUSBProduct = dSeagateProducts.getUSBProductTechnicalGuide();
		this.search(dSeagateProducts.getProblemKeyword(), technicalProblemGuideForUSBProduct);

		technicalProblemGuideForMediaPlayerProduct = dSeagateProducts.getMediaPlayerProductTechnicalGuide();
		this.search(dSeagateProducts.getProblemKeyword(), technicalProblemGuideForMediaPlayerProduct);

	}


	@Override
	public List<String> search(String problemKeyword, List<String> technicalProblemGuide) {
		List<String> exactMatchOutput = new ArrayList<String>();
		if(technicalProblemGuide != null) {
			for(String string :technicalProblemGuide) {
				if(string.matches("(.*)" + problemKeyword + "(.*)") || string.matches("(.*)" + problemKeyword) || string.matches(problemKeyword + "(.*)")){
					//		if(string.matches("^problemKeyword$")){
					//		if(string.matches("\\B^"+problemKeyword+"$\\B")){	
					//		if(Pattern.matches("(.*)("+problemKeyword+")(.*)", string)){			
					//			if(string.matches("\bproblem detecting\b")){	
					exactMatchOutput.add(string);
				}
			}
		}
		for(String string : exactMatchOutput) {
			System.out.println("Problem Keyword: "+ problemKeyword + "  & ExactMatchVisitor Search: "+string);
		}
		return exactMatchOutput;
	}

}
