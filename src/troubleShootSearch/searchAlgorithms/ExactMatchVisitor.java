package troubleShootSearch.searchAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import troubleShootSearch.Products.HDDProduct;
import troubleShootSearch.Products.MediaPlayers;
import troubleShootSearch.Products.SSDProduct;
import troubleShootSearch.Products.USBProduct;

public class ExactMatchVisitor implements SearchAlgorithmsVisitorI {

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
		List<String> exactMatchOutput = new ArrayList<String>();
		for(String string :technicalProblemGuide) {
                if(string.matches("(.*)" + problemKeyword + "(.*)") || string.matches("(.*)" + problemKeyword) || string.matches(problemKeyword + "(.*)")){
//		if(string.matches("^problemKeyword$")){
//		if(string.matches("\\B^"+problemKeyword+"$\\B")){	
//		if(Pattern.matches("(.*)("+problemKeyword+")(.*)", string)){			
//			if(string.matches("\bproblem detecting\b")){	
			exactMatchOutput.add(string);
			}
		}
		for(String string : exactMatchOutput) {
			System.out.println("ExactMatchVisitor "+string);
		}
		return exactMatchOutput;
	}
	
}
