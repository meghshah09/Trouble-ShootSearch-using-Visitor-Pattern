package troubleShootSearch.searchAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import troubleShootSearch.Products.DSeagateProducts;
import troubleShootSearch.enums.DebugLevel;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.Results;

public class NaiveStemmingMatchVisitor implements SearchAlgorithmsVisitorI {

    private Results result;
/**
 * 
 * @param rIn contains a resuslt class object
 */
    public NaiveStemmingMatchVisitor(Results rIn) {
        result = rIn;
        Logger.writeMessage("In Naive Stemming Match Constructor", DebugLevel.CONSTRUCTOR);
    }
/**
 * 
 * @param dSeagateProducts contains product reference
 */
    @Override
    public void visit(DSeagateProducts dSeagateProducts) {
        Logger.writeMessage("Currently in Naive Stemming Match Search", DebugLevel.SEARCHSTRATEGY);
        Set<String> s = dSeagateProducts.getMapOfTechnicalGuide().keySet();
        for (String technicalGuideIterator : s) {
            Logger.writeMessage("Currently Processing" + technicalGuideIterator + "product for Naive Stemming Match", DebugLevel.PRODUCTS);
            result.fileDisplay(technicalGuideIterator + " : ");
            result.stdoutDisplay(technicalGuideIterator + " : ");
            search(dSeagateProducts.getProblemKeyword(), dSeagateProducts.getMapOfTechnicalGuide().get(technicalGuideIterator));
        }

    }
/**
 * 
 * @param problemKeyword string containing problem keyword to search
 * @param technicalProblemGuide contains a list of problem guide for products.
 * @return 
 */
    @Override
    public List<String> search(String problemKeyword, List<String> technicalProblemGuide) {

        String[] tempArray = problemKeyword.trim().split(" ");
        List<String> naiveStemmingMatchOutput = new ArrayList<String>();
        if (technicalProblemGuide != null) {
            for (String string : technicalProblemGuide) {
                if (string.contains(tempArray[0])) {
                    naiveStemmingMatchOutput.add(string);
                }
            }
        }
        for (String string : naiveStemmingMatchOutput) {
            result.fileDisplay(string + "\n");
            result.stdoutDisplay(string + "\n");
            Logger.writeMessage("Problem Keyword : " + problemKeyword + "Naive Stemming Match result : " + string, DebugLevel.SEARCH);
        }
        return naiveStemmingMatchOutput;
    }

}
