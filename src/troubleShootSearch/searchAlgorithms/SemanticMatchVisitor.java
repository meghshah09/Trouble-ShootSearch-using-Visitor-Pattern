package troubleShootSearch.searchAlgorithms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import troubleShootSearch.Products.HDDProduct;
import troubleShootSearch.Products.MediaPlayers;
import troubleShootSearch.Products.SSDProduct;
import troubleShootSearch.Products.USBProduct;

public class SemanticMatchVisitor implements SearchAlgorithmsVisitorI{
	
	Map<String,String> synonyms = new HashMap<String, String>();
	
	@Override
	public void visit(HDDProduct hddProduct1) {
		List<String> technicalProblemGuide = hddProduct1.getHDDProductTechnicalGuide();
		this.search(hddProduct1.getProblemKeyword(), technicalProblemGuide);
	}	
	@Override
	public void visit(MediaPlayers mediaPlayers) {
		List<String> technicalProblemGuide = mediaPlayers.getMediaPlayerTechnicalGuide();
		this.search(mediaPlayers.getProblemKeyword(), technicalProblemGuide);
	}	
	@Override
	public void visit(SSDProduct sddProduct) {
		List<String> technicalProblemGuide = sddProduct.getSSDProductTechnicalGuide();
		this.search(sddProduct.getProblemKeyword(), technicalProblemGuide);
	}	
	@Override
	public void visit(USBProduct usbProduct) {
		List<String> technicalProblemGuide = usbProduct.getUSBProductTechnicalGuide();
		this.search(usbProduct.getProblemKeyword(), technicalProblemGuide);
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
		for(String string : semanticMatchOutput) {
			System.out.println(string);
		}
		return semanticMatchOutput;
	}

}
