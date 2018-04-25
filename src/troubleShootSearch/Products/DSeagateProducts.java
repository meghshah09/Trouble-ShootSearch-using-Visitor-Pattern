package troubleShootSearch.Products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import troubleShootSearch.enums.DebugLevel;

import troubleShootSearch.searchAlgorithms.SearchAlgorithmsVisitorI;
import troubleShootSearch.util.Logger;
import troubleShootSearch.util.Results;

/**
 * @author Megh Shah & Shashwat Maru
 *
 */
public class DSeagateProducts implements ProductsI {

    private List<String> hddProductTechnicalGuide;
    private List<String> sddProductTechnicalGuide;
    private List<String> usbProductTechnicalGuide;
    private List<String> mediaPlayerProductTechnicalGuide;
    private String problemKeyword;
    private List<String> inputs;
    private Map<String, List<String>> mapOfTechnicalGuide;
    private Results result;

    /**
     *
     * @param userSentencesIn is list containing the UserInputs of problem
     * Keyword
     * @param rIn is the Result Class object
     */
    public DSeagateProducts(List<String> userSentencesIn, Results rIn) {
        setInputs(userSentencesIn);

        mapOfTechnicalGuide = new HashMap<String, List<String>>();
        result = rIn;
        Logger.writeMessage("In deSegateProducts Constructor", DebugLevel.CONSTRUCTOR);
    }

    /**
     *
     * @param searchAlgorithmsVisitorI is the Visitor reference of the Search
     * Algorithm
     */
    @Override
    public void accept(SearchAlgorithmsVisitorI searchAlgorithmsVisitorI) {
        for (String s : inputs) {
            result.fileDisplay("\nProblem Keyword : " + s);
            result.stdoutDisplay("\nProblem Keyword : " + s);
            this.setProblemKeyword(s);
            searchAlgorithmsVisitorI.visit(this);
        }
    }

    /**
     *
     * @return the List of the Technical guide for Product 1
     */
    public List<String> getHDDProductTechnicalGuide() {
        return hddProductTechnicalGuide;
    }
/**
 * 
 * @param hddProductTechnicalGuideIn is  the List of the Technical guide for Product 1
 */
    public void setHDDProductTechnicalGuide(List<String> hddProductTechnicalGuideIn) {
        hddProductTechnicalGuide = hddProductTechnicalGuideIn;
    }
/**
 * 
 * @return string containing the problem keyword.
 */
    public String getProblemKeyword() {
        return problemKeyword;
    }
/**
 * 
 * @param problemKeywordIn sets the Problem Keyword. 
 */
    public void setProblemKeyword(String problemKeywordIn) {
        problemKeyword = problemKeywordIn;
    }
/**
 * 
 * @return the List of Inputs
 */
    public List<String> getInputs() {
        return inputs;
    }
/**
 * 
 * @param inputs sets the list of user inputs
 */
    public void setInputs(List<String> inputs) {
        this.inputs = inputs;
    }
/**
 * 
 * @return the list of Products 2 
 */
    public List<String> getSDDProductTechnicalGuide() {
        return sddProductTechnicalGuide;
    }
/**
 * 
 * @param sddProductTechnicalGuideIn contains the list of product 2
 */
    public void setSDDProductTechnicalGuide(List<String> sddProductTechnicalGuideIn) {
        sddProductTechnicalGuide = sddProductTechnicalGuideIn;
    }
/**
 * 
 * @return  the list of Products 3
 */
    public List<String> getUSBProductTechnicalGuide() {
        return usbProductTechnicalGuide;
    }
/**
 * 
 * @param usbProductTechnicalGuideIn  contains the list of product 3
 */
    public void setUSBProductTechnicalGuide(List<String> usbProductTechnicalGuideIn) {
        usbProductTechnicalGuide = usbProductTechnicalGuideIn;
    }
/**
 * 
 * @return  the list of Products 4
 */
    public List<String> getMediaPlayerProductTechnicalGuide() {
        return mediaPlayerProductTechnicalGuide;
    }
/**
 * 
 * @param mediaPlayerProductTechnicalGuideIn  contains the list of product 4 
 */
    public void setMediaPlayerProductTechnicalGuide(List<String> mediaPlayerProductTechnicalGuideIn) {
        mediaPlayerProductTechnicalGuide = mediaPlayerProductTechnicalGuideIn;
    }
/**
 * 
 * @return the map of Technical guide for all product 
 */
    public Map<String, List<String>> getMapOfTechnicalGuide() {
        return mapOfTechnicalGuide;
    }
/**
 * 
 * @param mapOfTechnicalGuide contains the map of all of technical guide for all products 
 */
    public void setMapOfTechnicalGuide() {
        mapOfTechnicalGuide.put("HDDProduct", this.getHDDProductTechnicalGuide());
       mapOfTechnicalGuide.put("SDDProduct", this.getSDDProductTechnicalGuide());
        mapOfTechnicalGuide.put("USBProduct", this.getUSBProductTechnicalGuide());
        mapOfTechnicalGuide.put("MediaPlayerProduct",this.getMediaPlayerProductTechnicalGuide());
    }

}
