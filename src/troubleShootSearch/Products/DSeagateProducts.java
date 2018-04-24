package troubleShootSearch.Products;
import java.util.ArrayList;
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
public class DSeagateProducts implements ProductsI{
	private List<String> hddProductTechnicalGuide;
	private List<String> sddProductTechnicalGuide;
	private List<String> usbProductTechnicalGuide;
	private List<String> mediaPlayerProductTechnicalGuide;
	private String problemKeyword;
	private List<String> inputs;
                    private Map<String,List<String>> mapOfTechnicalGuide;
                    private Results result;
                    private Logger log;
	public DSeagateProducts(List<String> userSentencesIn,Results rIn,Logger logIn) {
		setInputs(userSentencesIn);

		mapOfTechnicalGuide = new HashMap<String, List<String>>();
                                        result = rIn;
                                        log = logIn;
                                        log.writeMessage("In deSegateProducts Constructor", DebugLevel.CONSTRUCTOR);
	}
	
	@Override
	public void accept(SearchAlgorithmsVisitorI searchAlgorithmsVisitorI) {
		for(String s :inputs){
                                                            result.fileDisplay("\nProblem Keyword : "+s);
                                                            result.stdoutDisplay("\nProblem Keyword : "+s);
			this.setProblemKeyword(s);
			searchAlgorithmsVisitorI.visit(this);
		}
	}
	
	
	public List<String> getHDDProductTechnicalGuide() {
		return hddProductTechnicalGuide;
	}
	public void setHDDProductTechnicalGuide(List<String> hddProductTechnicalGuideIn) {
		hddProductTechnicalGuide = hddProductTechnicalGuideIn;
	}
	public String getProblemKeyword() {
		return problemKeyword;
	}
	public void setProblemKeyword(String problemKeywordIn) {
		problemKeyword = problemKeywordIn;
	}
	public List<String> getInputs() {
		return inputs;
	}
	public void setInputs(List<String> inputs) {
		this.inputs = inputs;
	}
	public List<String> getSDDProductTechnicalGuide() {
		return sddProductTechnicalGuide;
	}
	public void setSDDProductTechnicalGuide(List<String> sddProductTechnicalGuideIn) {
		sddProductTechnicalGuide = sddProductTechnicalGuideIn;
	}
	public List<String> getUSBProductTechnicalGuide() {
		return usbProductTechnicalGuide;
	}
	public void setUSBProductTechnicalGuide(List<String> usbProductTechnicalGuideIn) {
		usbProductTechnicalGuide = usbProductTechnicalGuideIn;
	}
	public List<String> getMediaPlayerProductTechnicalGuide() {
		return mediaPlayerProductTechnicalGuide;
	}
	public void setMediaPlayerProductTechnicalGuide(List<String> mediaPlayerProductTechnicalGuideIn) {
		mediaPlayerProductTechnicalGuide = mediaPlayerProductTechnicalGuideIn;
	}

	public Map<String,List<String>> getMapOfTechnicalGuide() {
		return mapOfTechnicalGuide;
	}

	public void setMapOfTechnicalGuide(Map<String,List<String>> mapOfTechnicalGuide) {
		this.mapOfTechnicalGuide = mapOfTechnicalGuide;
	}


	

}