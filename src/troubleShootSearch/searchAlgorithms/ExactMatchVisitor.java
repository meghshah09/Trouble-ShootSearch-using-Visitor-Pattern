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
		List<String> exactMatchOutput = new ArrayList<String>();
		for(String string :technicalProblemGuide) {
	if(string.matches("(.*)([^\\w])("+problemKeyword+")([^\\w])(.*)")){
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
