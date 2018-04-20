package troubleShootSearch.searchAlgorithms;
import java.util.List;

import troubleShootSearch.Products.HDDProduct;
import troubleShootSearch.Products.MediaPlayers;
import troubleShootSearch.Products.SSDProduct;
import troubleShootSearch.Products.USBProduct;

public interface SearchAlgorithmsVisitorI {
	
	public void visit(HDDProduct hddProduct1);
	public void visit(MediaPlayers mediaPlayers);
	public void visit(SSDProduct sddProduct);
	public void visit(USBProduct usbProduct);
	
	public List<String> search(String problemKeyword, List<String> technicalProblemGuide);
	
}
