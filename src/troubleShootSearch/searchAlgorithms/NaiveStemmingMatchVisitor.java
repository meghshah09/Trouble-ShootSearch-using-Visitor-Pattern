package troubleShootSearch.searchAlgorithms;

import java.util.ArrayList;
import java.util.List;

import troubleShootSearch.Products.HDDProduct;
import troubleShootSearch.Products.MediaPlayers;
import troubleShootSearch.Products.SSDProduct;
import troubleShootSearch.Products.USBProduct;

public class NaiveStemmingMatchVisitor implements SearchAlgorithmsVisitorI{

	@Override
	public void visit(HDDProduct hddProduct1, String problemKeyword) {
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
		
		String [] tempArray = problemKeyword.trim().split("\\s+");
		List<String> naiveStemmingMatchOutput = new ArrayList<String>();
		for(String string: technicalProblemGuide) {
			if(string.contains(tempArray[0])) {
			naiveStemmingMatchOutput.add(string);
			}
		}
		for(String string : naiveStemmingMatchOutput) {
			System.out.println("NaiveStemmingMatchVisitor "+string);
		}
		return naiveStemmingMatchOutput;
	}

}
