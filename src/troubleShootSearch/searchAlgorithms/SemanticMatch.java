package troubleShootSearch.searchAlgorithms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import troubleShootSearch.Products.HDDProduct1;
import troubleShootSearch.Products.MediaPlayers;
import troubleShootSearch.Products.SSDProduct;
import troubleShootSearch.Products.USBProduct;

public class SemanticMatch implements SearchAlgorithms{
	
	Map<String,String> synonyms = new HashMap<String, String>();
	
	@Override
	public void visit(HDDProduct1 hddProduct1, String problemKeyword) {
		List<String> technicalProblemGuide = hddProduct1.getHDDProductTechnicalGuide();
		this.search(problemKeyword, technicalProblemGuide);
	}	
	@Override
	public void visit(MediaPlayers mediaPlayers, String problemKeyword) {
		List<String> technicalProblemGuide = mediaPlayers.getMediaPlayerTechnicalGuide();
		this.search(problemKeyword, technicalProblemGuide);
	}	
	@Override
	public void visit(SSDProduct sddProduct, String problemKeyword) {
		List<String> technicalProblemGuide = sddProduct.getSDDProductTechnicalGuide();
		this.search(problemKeyword, technicalProblemGuide);
	}	
	@Override
	public void visit(USBProduct usbProduct, String problemKeyword) {
		List<String> technicalProblemGuide = usbProduct.getUSBProductTechnicalGuide();
		this.search(problemKeyword, technicalProblemGuide);
	}	

	@Override
	public List<String> search(String problemKeyword, List<String> technicalProblemGuide) {
		String tempArray[]=problemKeyword.trim().split("\\s+");
		String lastElement=tempArray[tempArray.length-1];
		String tempSynonyms=null;
		List<String> semanticMatchOutput = new ArrayList<String>();
		if(lastElement != null) {
		tempSynonyms= synonyms.get(lastElement);
		for(String string: technicalProblemGuide) {
			if(string.contains(tempSynonyms)) {
				semanticMatchOutput.add(string);
			}
		}
		}
		return semanticMatchOutput;
	}

}
