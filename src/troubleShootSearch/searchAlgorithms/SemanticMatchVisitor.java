package troubleShootSearch.searchAlgorithms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import troubleShootSearch.Products.DSeagateProducts;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.FilesLoader;

public class SemanticMatchVisitor implements SearchAlgorithmsVisitorI{

	private Map<String,List<String>> synonyms;
	private FilesLoader fl;
	//	private FileProcessor fp;
	public SemanticMatchVisitor(String fileIn, FileProcessor fpIn){
		fl = new FilesLoader(fpIn);
		synonyms = fl.loadSynFile(fileIn);
	}
	/*	List<String> technicalProblemGuideForHDDProduct;
	List<String> technicalProblemGuideForSDDProduct;
	List<String> technicalProblemGuideForUSBProduct;
	List<String> technicalProblemGuideForMediaPlayerProduct;
	 */
	@Override
	public void visit(DSeagateProducts dSeagateProducts) {

		Set<String> s = dSeagateProducts.getMapOfTechnicalGuide().keySet();
		for(String technicalGuideIterator: s) {
			search(dSeagateProducts.getProblemKeyword(), dSeagateProducts.getMapOfTechnicalGuide().get(technicalGuideIterator));
		}

		/*for(List<String> technicalGuide: dSeagateProducts.getListOfTechnicalGuide()) {
			search(dSeagateProducts.getProblemKeyword(), technicalGuide);
		}*//*
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
		String tempArray[]=problemKeyword.trim().split(" ");
		String lastElement=tempArray[tempArray.length-1];
		List <String> tempSynonyms;
		List<String> semanticMatchOutput = new ArrayList<String>();
		String replaceProblemKeyword;
		if(lastElement != null) {
			tempSynonyms= synonyms.get(lastElement);
			if(tempSynonyms != null){
				for(String s : tempSynonyms){
					replaceProblemKeyword = problemKeyword.replace(lastElement, s);
					if(technicalProblemGuide != null) {
						for(String string: technicalProblemGuide) {
							//			if(string.matches("(.*)" + replaceProblemKeyword + "(.*)") || string.matches("(.*)" + replaceProblemKeyword) || string.matches(replaceProblemKeyword + "(.*)")){
							if(string.matches("(.*)(\\A|[^\\w])(" + replaceProblemKeyword + ")(\\Z|[^\\w])(.*)")) {
								semanticMatchOutput.add(string);
							}
						}
					}
				}
			}
		}
		for(String string : semanticMatchOutput) {
			System.out.println("Problem Keyword: "+ problemKeyword + " & Semantic Match Visitor Search: "+ string);
		}
		return semanticMatchOutput;
	}

}
