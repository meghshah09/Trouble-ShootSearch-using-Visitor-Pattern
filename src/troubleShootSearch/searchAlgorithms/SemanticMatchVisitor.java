package troubleShootSearch.searchAlgorithms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import troubleShootSearch.Products.DSeagateProducts;
import troubleShootSearch.enums.DebugLevel;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.FilesLoader;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.Results;

public class SemanticMatchVisitor implements SearchAlgorithmsVisitorI{

	private Map<String,List<String>> synonyms;
	private FilesLoader fl;
                    private Results result;
                    private Logger log;
	public SemanticMatchVisitor(String fileIn, FileProcessor fpIn,Results rIn, Logger logIn){
		fl = new FilesLoader(fpIn,logIn);
		synonyms = fl.loadSynFile(fileIn);
                                           result=rIn;
                                           log = logIn;
                                           log.writeMessage("In Semantic Match Constructor", DebugLevel.CONSTRUCTOR);
	}

	@Override
	public void visit(DSeagateProducts dSeagateProducts) {
                                        log.writeMessage("Currently in Semantic Match Search", DebugLevel.SEARCHSTRATEGY);
		Set<String> s = dSeagateProducts.getMapOfTechnicalGuide().keySet();
		for(String technicalGuideIterator: s) {
                                                             log.writeMessage("Currently Processing"+technicalGuideIterator+"product for Semantic Match", DebugLevel.PRODUCTS);
                                                             result.fileDisplay(technicalGuideIterator +" : ");
                                                               result.stdoutDisplay(technicalGuideIterator +" : ");
			search(dSeagateProducts.getProblemKeyword(), dSeagateProducts.getMapOfTechnicalGuide().get(technicalGuideIterator));
		}

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
			result.fileDisplay(string+"\n");
                                                            result.stdoutDisplay(string+"\n");
                                                            log.writeMessage("Problem Keyword : "+ problemKeyword +"Semantic Match result : "+ string, DebugLevel.SEARCH);
		}
		return semanticMatchOutput;
	}

}
