package troubleShootSearch.searchAlgorithms;
import java.util.List;

import troubleShootSearch.Products.HDDProduct1;
import troubleShootSearch.Products.MediaPlayers;
import troubleShootSearch.Products.SSDProduct;
import troubleShootSearch.Products.USBProduct;

public interface SearchAlgorithms {
	
	public void visit(HDDProduct1 hddProduct1, String ProblemKeyword);
	public void visit(MediaPlayers mediaPlayers, String ProblemKeyword);
	public void visit(SSDProduct sddProduct, String ProblemKeyword);
	public void visit(USBProduct usbProduct, String ProblemKeyword);
	
	public List<String> search(String problemKeyword, List<String> technicalProblemGuide);
	
}
