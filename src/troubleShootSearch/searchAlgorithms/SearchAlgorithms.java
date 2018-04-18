package troubleShootSearch.searchAlgorithms;
import java.util.List;

import troubleShootSearch.Products.HDDProduct1;

public interface SearchAlgorithms {
	
	public void visit(HDDProduct1 hddProduct1);
	public List<String> search(String problemKeyword, List<String> technicalProblemGuide);
	
}
