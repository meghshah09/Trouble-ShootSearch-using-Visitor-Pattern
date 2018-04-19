package troubleShootSearch.searchAlgorithms;
import java.util.List;

import troubleShootSearch.Products.HDDProduct;
import troubleShootSearch.Products.MediaPlayers;
import troubleShootSearch.Products.SSDProduct;
import troubleShootSearch.Products.USBProduct;

public interface SearchAlgorithmsVisitorI {
	
	public void visit(HDDProduct hddProduct1, String ProblemKeyword);
	public void visit(MediaPlayers mediaPlayers, String ProblemKeyword);
	public void visit(SSDProduct sddProduct, String ProblemKeyword);
	public void visit(USBProduct usbProduct, String ProblemKeyword);
	
	public List<String> search(String problemKeyword, List<String> technicalProblemGuide);
	
}
